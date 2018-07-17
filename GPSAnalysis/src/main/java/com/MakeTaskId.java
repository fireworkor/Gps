package com;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  14:37  星期三
 * 描述  :
 */
public class MakeTaskId {
    static int taskId = 0;

    public static void main(String[] args) {
//        System.out.println(getTaskId());
        System.out.println(getTaskId());
    }

    public static String getTaskId() {

        taskId++;
        return  taskId+"";
    }
}
