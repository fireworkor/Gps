package com.controller;

import com.bean.User;
import com.bean.Userdistribution;
import com.bean.Userpositionweight;
import com.repository.UserdistributionRepository;
import com.repository.UserpositionweightRepository;
import com.service.UserService;
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
public class PositionController {
    @Autowired
    UserdistributionRepository   userdistributionRepository;

    @RequestMapping("/position")
    public String position() {
        return "position";
    }



    @PostMapping("/GetMapData")
    @ResponseBody
    public List<Userdistribution> GetMapData() {
        ArrayList<Userdistribution> list = new ArrayList<>();
        Iterable<Userdistribution>  all  = userdistributionRepository.findAll();
        all.forEach(x -> list.add(x));
        System.out.println(list);
        return list;


    }
}