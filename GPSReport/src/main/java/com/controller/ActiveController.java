package com.controller;

import com.bean.Userdistribution;
import com.bean.Userpositionweight;
import com.repository.UserdistributionRepository;
import com.repository.UserpositionweightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  8:35  星期三
 * 描述  :
 */
@Controller
public class ActiveController {
    @Autowired
    UserpositionweightRepository userpositionweightRepository;
    @RequestMapping("/active")
    public String position() {
        return "active";
    }

    @PostMapping("/getzifudata")
    @ResponseBody
    public List<Userpositionweight> GetZifuData() {
        ArrayList<Userpositionweight> list = new ArrayList<>();
        Iterable<Userpositionweight>  all  = userpositionweightRepository.findAll();
        all.forEach(x -> list.add(x));
        System.out.println(list);
        return list;
    }


}