package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/18  17:31  星期五
 * 描述  :
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "timespeed")
public class TimeSpeed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String time;
    private String speed;
}
