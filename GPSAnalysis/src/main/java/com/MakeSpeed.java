package com;

import java.util.Random;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  16:24  星期三
 * 描述  :
 */
public class MakeSpeed {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

        System.out.println(getSpeed());
        }
    }

    /**
     * 拿到0-160之间的速度值 [0,160)
     * @return
     */
    public static  String getSpeed(){
        Random random = new Random();
        Double d=random.nextDouble()+ random.nextInt(160);
        return d.toString();
    }
}
