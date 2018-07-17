package com.service;

import com.bean.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  9:05  星期三
 * 描述  :
 */
@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;

    public Optional<User> findById(Long id) {

        return userRepository.findById(id);

    }



}
