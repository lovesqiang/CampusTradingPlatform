package com.qiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.qiang.pojo.Goods;
import com.qiang.pojo.Type;
import com.qiang.pojo.User;
import com.qiang.service.GoodsService;
import com.qiang.service.TypeService;
import com.qiang.utils.FileNameUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    public static final int PAGE_SIZE = 5;

    String fileName = "";   //防止空指针异常

    //用户分页(显示第一页的五条数据)
    @RequestMapping("/onePage")
    public String onePage(HttpSession session){

        PageInfo<Goods> goodsInfo = goodsService.pageSplit(1, PAGE_SIZE);

        session.setAttribute("goodsInfo",goodsInfo);


        return "goods/goods";
    }

    //Ajax分页翻页处理
    @RequestMapping("/ajaxSplit")
    @ResponseBody   //ajax请求来的，一定要使用@ResponseBody注解
    public void ajaxSplit(int page, HttpSession session){

        //取得当前page的页面数据
        PageInfo<Goods> goodsInfo = goodsService.pageSplit(page, PAGE_SIZE);

        //把数据传递到jsp页面上
        session.setAttribute("goodsInfo",goodsInfo);
    }

    //根据商品类型获取商品信息
    @RequestMapping("goodsType")
    public String goodsType(Integer goodsType,Model model){
        List<Goods> goodsList = goodsService.listGoodsByType(goodsType);
        Type type = typeService.getTypeById(goodsType);
        model.addAttribute("type",type);
        model.addAttribute("goodsList",goodsList);
        return "goods/goodsList";
    }

    //用户首页搜索框，模糊查询
    @RequestMapping("likeGoodsName")
    public String likeGoodsName(String likeName,Model model){
        List<Goods> goodsLikeList = goodsService.listLikeGoodsName(likeName);
        model.addAttribute("likeName",likeName);
        model.addAttribute("goodsLikeList",goodsLikeList);
        return "goods/goodsLikeList";
    }

    //根据主键获取商品
    @RequestMapping("/viewGood")
    public String viewGood(Integer goodsId,Model model){
        Goods good = goodsService.getGoodsById(goodsId);  //获取商品Id
        model.addAttribute("good",good);
        return "goods/viewGood";
    }

    //上传商品页面
    @RequestMapping("uploadGoods")
    public String uploadGoods(){
        return "goods/uploadGoods";
    }


    //ajax文件(图片)的异步上传
    @ResponseBody
    @RequestMapping("ajaxImg")
    public Object ajaxImg(MultipartFile goodsImage, HttpServletRequest request){
        //提取生成文件名UUID+上传图片的后缀
        fileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(goodsImage.getOriginalFilename());

        System.out.println("fileName==============="+fileName);


        //获取存储路径
        String path = request.getServletContext().getRealPath("/image");

        System.out.println("path===="+path);    //E:\code\campus-trading-platform\target\campus-trading-platform-1.0.0\image

        //转存
        try {
            goodsImage.transferTo(new File(path+File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //为了在客户端显示图片，要将存储的文件名回传下去，由于是自定义的上传插件，所以此处要手工处理JSON
        JSONObject object = new JSONObject();
        object.put("imgURL",fileName);
        //切记切记：JSON对象一定要toString()回到客户端
        return object.toString();
    }


    //用户上传商品（保存商品）
    @RequestMapping(value = "/saveGoods",method = RequestMethod.POST)
    public String savaGoods(Goods goods,HttpServletRequest request){
        goods.setGoodsImage(fileName);
        goods.setGoodsUploadDate(new Date());   //调用系统时间
        goods.setGoodsStatus(0);    //默认未审核
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user"); //获取当前用户

        if (user==null || user.getUserNumber()==null || user.getUserNumber()=="" ) {
            // 用户未登录，重定向到登录页面
            return "redirect:/login/uLogin";
        } else {
            goods.setGoodsUserId(user.getUserId());
        }
        int i = goodsService.insetGoods(goods);

        if(i>0){
            request.setAttribute("msg","添加成功");
        }else {
            request.setAttribute("msg","添加失败");
        }

        System.out.println("fileName:"+fileName);

        //清空fileName变量中的内容，为了下次增加或修改的异步Ajax的上传处理
        fileName = "";

        return "goods/uploadGoods";
    }

    //用户（显示上传的商品）
    @RequestMapping("/showGoodsByUser")
    public String showGoodsByUser(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Goods> goodsList = goodsService.listGoodsByUser(user.getUserId());
        model.addAttribute("goodsList",goodsList);
        return "goods/showUserGoodsById";
    }

    //商品审核
    @ResponseBody
    @RequestMapping(value = "/checkGoods")
    public String checkGoods(@RequestParam("goodsStatus") Integer goodsStatus, @RequestParam("goodsId") Integer goodsId){
        System.out.println("goodsStatus:"+goodsStatus);
        System.out.println("goodsId:"+goodsId);
        goodsService.updateGoodsStatus(goodsStatus,goodsId);
        JSONObject object = new JSONObject();
        return object.toString();
    }

}
