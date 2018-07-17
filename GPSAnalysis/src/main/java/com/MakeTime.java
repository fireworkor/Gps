package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  11:27  星期三
 * 描述  :
 */
public class MakeTime {

    static Date datebase;

    public static void main(String[] args) throws ParseException {

        System.out.println(getTime());
        System.out.println(getTime());
        System.out.println(getTime());
        System.out.println(getTime());

    }


    public  static  String getTime(){
            if (datebase == null) {
                Date date = new Date();
                datebase = new Date(date.getTime() - 24 * 60 * 60 * 1000 * 20);
            }
            Date dataTmp =getMyDate(0,0,1);
            datebase = dataTmp;
            dateToString(dataTmp);
        return dateToString(dataTmp);
    }

    /**
     * 根据日期拿到字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * 根据日期拿到字符串
     *
     * @return
     */
    public static Date stringToDate(String string) {

        return null;
    }

    /**
     * 原来时间基础上加减
     *
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public static Date getMyDate(  int day, int hour, int minute) {
        return new Date(datebase.getTime() +  1000*(60 *minute+60*60*hour+60*60*24*day));
    }


}

