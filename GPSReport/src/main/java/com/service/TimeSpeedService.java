package com.service;

import com.bean.TimeSpeed;
import com.repository.TimeSpeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  9:05  星期三
 * 描述  :
 */
@Service
public class TimeSpeedService {

    @Autowired
    TimeSpeedRepository timeSpeedRepository;
    public Iterable<TimeSpeed> findAll(){
        return timeSpeedRepository.findAll();
    }

}
