package com.qiang.listener;

import com.qiang.pojo.Type;
import com.qiang.service.TypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

//在监听器中获取service,来得到所有商品类别的列表，把它放到application全局作用域中。

@WebListener
public class TypeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //获取spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_*.xml");

        //从spring容器中获取TypeServiceImpl对象
        TypeService typeService = (TypeService) context.getBean("typeServiceImpl");

        //ProductTypeServiceImpl对象调用业务逻辑层的getAll()获取所有商品类型
        List<Type> typeList = typeService.getAllType();

        //将商品类型保存在application全局作用域中,供新增页面、修改页面、前台查询功能提供全部商品的集合
        sce.getServletContext().setAttribute("typeList",typeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
