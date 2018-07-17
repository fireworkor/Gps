package com;



import java.io.FileWriter;
import java.io.IOException;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  9:45  星期三
 * 描述  :
 * 实时：
 * 同一辆车实时的位置变化
 * 离线：
 * 用户的行为属性：
 * 车辆的时间分布情况，
 * 车辆在地域维度上的分布情况，同一个用户的活动位置
 * 从一辆车每天开车的距离，同一辆车的平均路程长度，车辆的迁徙图，
 * 最快的车速topn，
 * 用户标识，任务id，时间，经纬度，速度
 */
public class MakeGpsData {
    /**
     * 造多少条数据
     */
    static int num = 300;

    public static void main(String[] args) throws Exception {
//      makeData1();
//        makeData4();
//       makeData3();
       makeData5();


    }

    /**
     * 不同车辆，顺序任务id，同一时间，（随机地理位置和速度）+address
     */
    public static void makeData5() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("data/etl/input/1111differentCarSameTimeAddress.log");
            boolean flag = true;
            String  time = MakeTime.getTime();
            for (int i = 0; i < 300; i++) {
                String imei   = MakeUserId.getIMEI();
                String taskId = MakeTaskId.getTaskId();
                String lat    = MakeGeo.getlat();
                String lon    = MakeGeo.getLon();
                String speed  = MakeSpeed.getSpeed();
                String address = MakeGeo.getProvince();
                String str = imei + "," + taskId + "," + time + "," + lat + "," + lon + "," + speed+","+address;
                fileWriter.write(str);
                if (i == num - 1) {
                    break;
                }
                fileWriter.write("\r\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 不同车辆，顺序任务id，同一时间，（随机地理位置和速度）
     */
    public static void makeData3() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("data/etl/input/differentCarSameTime.log");
            boolean flag = true;
            String  time = MakeTime.getTime();
            for (int i = 0; i < 300; i++) {
                String imei   = MakeUserId.getIMEI();
                String taskId = MakeTaskId.getTaskId();
                String lat    = MakeGeo.getlat();
                String lon    = MakeGeo.getLon();
                String speed  = MakeSpeed.getSpeed();
                String str = imei + "," + taskId + "," + time + "," + lat + "," + lon + "," + speed;
                fileWriter.write(str);
                if (i == num - 1) {
                    break;
                }
                fileWriter.write("\r\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 同一辆车车辆，顺序任务id，不同时间，（随机地理位置和速度）+address
     */
    public static void makeData4() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("data/etl/input/sameCarDifferentTime.log");
            boolean flag = true;
            String  imei = MakeUserId.getMac();
            int     num  = 300;
            for (int i = 0; i < num; i++) {
                String taskId = MakeTaskId.getTaskId();
                String time   = MakeTime.getTime();
                String lat    = MakeGeo.getlat();
                String lon    = MakeGeo.getLon();
                String speed  = MakeSpeed.getSpeed();
                String address = MakeGeo.getProvince();
                String str = imei + "," + taskId + "," + time + "," + lat + "," + lon + "," + speed+","+address;
                fileWriter.write(str);
                if (i == num - 1) {
                    break;
                }
                fileWriter.write("\r\n");

            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 同一辆车车辆，顺序任务id，不同时间，（随机地理位置和速度）
     */
    public static void makeData2() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("data/etl/input/sameCarDifferentTime.log");
            boolean flag = true;
            String  imei = MakeUserId.getMac();
            int     num  = 300;
            for (int i = 0; i < num; i++) {
                String taskId = MakeTaskId.getTaskId();
                String time   = MakeTime.getTime();
                String lat    = MakeGeo.getlat();
                String lon    = MakeGeo.getLon();
                String speed  = MakeSpeed.getSpeed();
                String province = MakeGeo.getProvince();
                String str = imei + "," + taskId + "," + time + "," + lat + "," + lon + "," + speed;
                fileWriter.write(str);
                if (i == num - 1) {
                    break;
                }
                fileWriter.write("\r\n");

            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 不同车辆，顺序任务id，不同时间，       （随机地理位置和速度）
     */
    public static void makeData1() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("data/etl/input/differentCarDifferentTime.log");
            for (int i = 0; i < 300; i++) {
                String imei   = MakeUserId.getMac();
                String taskId = MakeTaskId.getTaskId();
                String time   = MakeTime.getTime();
                String lat    = MakeGeo.getlat();
                String lon    = MakeGeo.getLon();
                String speed  = MakeSpeed.getSpeed();
                String str = imei + "," + taskId + "," + time + "," + lat + "," + lon + "," + speed;
                fileWriter.write(str);
                if (i == num - 1) {
                    break;
                }
                fileWriter.write("\r\n");


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
