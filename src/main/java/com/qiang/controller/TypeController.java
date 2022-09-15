package com.qiang.controller;

import com.qiang.pojo.Type;
import com.qiang.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //显示全部类目
    @RequestMapping("/findType")
    public String getAll(Model model){

        List<Type> typeList = typeService.getAllType();

        model.addAttribute("typeList",typeList);

        return "type/type";
    }

    //添加新增商品类型
//    @RequestMapping("/add")
//    public String add(){
//
//        return "type/add";
//
//    }

    //保存新增商品类型
    @RequestMapping("/saveAdd")
    public String saveAdd(Type type){

        typeService.insert(type);

        //增加成功后，应该重新访问数据库，所以跳转到findType上
        return "forward:/type/findType";
    }

    //删除商品类目
    @RequestMapping("/delete")
    public String delete(Integer typeId){

        typeService.delete(typeId);

        return "forward:/type/findType";
    }

    //类目回显
    @RequestMapping("/findId")
    public String findId(Integer typeId, Model model){

        Type type = typeService.getById(typeId);

        model.addAttribute("type",type);

        return "type/update";
    }

    //更新商品类目
    @RequestMapping("/update")
    public String update(Type type){

        typeService.update(type);

        return "forward:/type/findType";
    }


}
