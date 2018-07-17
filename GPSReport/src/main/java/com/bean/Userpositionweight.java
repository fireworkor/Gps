package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/20  18:17  星期日
 * 描述  :
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userpositionweight")
public class Userpositionweight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String address;
    private  Long num;
}
