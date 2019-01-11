package com.yz.controller;


import com.yz.exception.AppException;
import com.yz.model.Department;
import com.yz.model.User;
import com.yz.service.IDepartmentService;
import com.yz.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @Autowired
    IDepartmentService departmentService;

    @PostMapping("/login")
    public String login(User user, Model model, HttpServletRequest request){
        try{
            boolean isLogin = userService.isLogin(user);
            if(isLogin){
                request.getSession().setAttribute("user",user);
                List<Department> departments = departmentService.getAll();
                if(!CollectionUtils.isEmpty(departments)){
                    request.getSession().setAttribute("departments",departments);
                }
                return "redirect:/main";
            }else{
                model.addAttribute("msg","用户名密码错误");
                return "index";
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("LoginController-login"+e);

        }
        return "index";

    }

    @RequestMapping("/testException")
    public void login(Model model){
       throw new AppException("错误啦");
    }
}
