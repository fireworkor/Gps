package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/18  18:46  星期五
 * 描述  :
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diffhighspeed")
public class DiffHighSpeed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String  imei;
    private String time;
    private String speed;
}
