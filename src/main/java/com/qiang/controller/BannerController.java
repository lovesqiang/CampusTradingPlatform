package com.qiang.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiang.pojo.Banner;
import com.qiang.service.BannerService;
import com.qiang.utils.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    String fileName="";

    //展示轮播图
    @RequestMapping("/showBanner")
    public String showBanner(Model model){
        List<Banner> bannerList = bannerService.listAllBanner();
        model.addAttribute("bannerList",bannerList);
        return "banner/banner";
    }

    //根据轮播图Id删除轮播图
    @RequestMapping("/deleteBanner")
    public String deleteBanner(Integer bannerId){
        bannerService.deleteBanner(bannerId);
        return "forward:/banner/showBanner";
    }

    //ajax文件(图片)的异步上传
    @ResponseBody
    @RequestMapping("ajaxImg")
    public Object ajaxImg(MultipartFile bannerImage, HttpServletRequest request){
        //提取生成文件名UUID+上传图片的后缀
        fileName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(bannerImage.getOriginalFilename());

        System.out.println("fileName==============="+fileName);


        //获取存储路径
        String path = request.getServletContext().getRealPath("/image/banner");

        System.out.println("path===="+path);

        //转存
        try {
            bannerImage.transferTo(new File(path+File.separator+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //为了在客户端显示图片，要将存储的文件名回传下去，由于是自定义的上传插件，所以此处要手工处理JSON
        JSONObject object = new JSONObject();
        object.put("imgURL",fileName);
        //切记切记：JSON对象一定要toString()回到客户端
        return object.toString();
    }

    //保存轮播
    @RequestMapping("/saveBannerImage")
    public String saveBannerImage(Banner banner){
        banner.setBannerImage(fileName);
        bannerService.insertBanner(banner);
        fileName = "";
        return "forward:/banner/showBanner";
    }

    //根据轮播图Id查询轮播信息（商品回显）
    @RequestMapping("/getOneBanner")
    public String getOneBanner(Integer bannerId,Model model){
        Banner banner = bannerService.getBannerById(bannerId);
        model.addAttribute("banner",banner);
        return "banner/updateBanner";
    }

    //更新轮播图
    @RequestMapping("/updateBanner")
    public String updateBanner(Banner banner){
        banner.setBannerImage(fileName);
        bannerService.updateBanner(banner);
        fileName="";
        return "forward:/banner/showBanner";
    }

}
