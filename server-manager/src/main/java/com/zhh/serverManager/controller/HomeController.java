package com.zhh.serverManager.controller;

import com.zhh.serverManager.dao.UserDao;
import com.zhh.serverManager.model.admin.User;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author:zhh
 * @Date:Created in 14:54 2019/6/18 0018
 */
@Controller
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserDao userDao;

    @ApiOperation(value = "请求到登录界面",notes = "请求到登录界面")
    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model){
        /*if((null != SecurityUtils.getSubject() && SecurityUtils.getSubject().isAuthenticated()) || SecurityUtils.getSubject().isRemembered()){
            //todo 获取菜单栏
            return "login";
        }else{
            System.out.println("--进行登录验证..验证开始");
            return "login";
        }*/
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(User user,HttpServletRequest request){
        String userName = user.getUserName();
        String password = user.getPassword();
        System.out.println("登录验证。。。。 userName: "+userName+" password: "+password);
        ModelAndView view =new ModelAndView();
        view.setViewName("admin/index");
        return view;
    }
}