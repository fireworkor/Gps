package com.controller;

import com.bean.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  8:35  星期三
 * 描述  :
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    @PostMapping("/toIndex")
    public String toIndex(User user){
        User u = userService.findById(1L).get();
        if (user.getName().equals(u.getName())&&user.getPassword().equals(u.getPassword())) {
            return "index";
        }
        return "error";


    }
}
