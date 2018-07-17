package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  8:59  星期三
 * 描述  :
 */
@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;
    private  String name;
    private  String password;
}
