package com.controller;

import com.bean.DiffHighSpeed;
import com.bean.DiffSlowSpeed;
import com.bean.TimeSpeed;
import com.bean.User;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.service.DiffHighSpeedService;
import com.service.DiffSlowSpeedService;
import com.service.TimeSpeedService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  8:35  星期三
 * 描述  :
 */
@Controller
public class SpeedController {
    @Autowired
    TimeSpeedService timeSpeedService;
    @Autowired
    DiffHighSpeedService diffHighSpeedService;
    @Autowired
    DiffSlowSpeedService diffSlowSpeedService;
    @RequestMapping("/speed")
    public String speed(){
        return "index";
    }
    @PostMapping("/getlinedata")
    @ResponseBody
    public List<TimeSpeed>  getLineData(){
        Iterable<TimeSpeed> all = timeSpeedService.findAll();
        List<TimeSpeed>     list = new ArrayList<>();
        all.forEach(x->list.add(x));
        System.out.println(list);
        return list;
    }

    @GetMapping("/diffhighspeed")
    @ResponseBody
    public List<DiffHighSpeed>  DiffHighSpeed(){
        Iterable<DiffHighSpeed> all = diffHighSpeedService.findAll();
        List<DiffHighSpeed>     list = new ArrayList<>();
        all.forEach(x->list.add(x));
        System.out.println(list);
        return list;
    }
    @GetMapping("/diffslowspeed")
    @ResponseBody
    public List<DiffSlowSpeed>  DiffSlowSpeed(){
        Iterable<DiffSlowSpeed> all = diffSlowSpeedService.findAll();
        List<DiffSlowSpeed>     list = new ArrayList<>();
        all.forEach(x->list.add(x));
        System.out.println(list);
        return list;
    }


}
