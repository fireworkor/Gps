package com;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  10:55  星期三
 * 描述  :
 * 经纬度处理
 * 中国经纬度范围
 * 全球经纬度的取值范围为：纬度-90~90，经度-180~180
 * 中国的经纬度范围大约为：纬度3.86~53.55，经度73.66~135.05
 * 北京行政中心的纬度为39.92，经度为116.46
 * 越北面的地方纬度数值越大，越东面的地方经度数值越大
 * 度分转换： 将度分单位数据转换为度单位数据，公式：度=度+分/60
 * 例如： 经度 = 116°20.12'，纬度 = 39°12.34'
 * 经度 = 116 + 20.12 / 60 = 116.33533°
 * 纬度 = 39 + 12.34 / 60 = 39.20567°
 * 分秒转换： 将度分秒单位数据转换为度单位数据，公式：度 = 度 + 分 / 60 + 秒 / 60 / 60
 * 例如： 经度 = 116°20'43"，纬度 = 39°12'37"
 * 经度 = 116 + 20 / 60 + 43 / 60 / 60 = 116.34528°
 * 纬度 = 39 + 12 / 60 + 37 / 60 / 60 = 39.21028°
 * 分类: 定位
 */
public class MakeGeo {
    public static String getLon() {
        //中国的经纬度范围大约为：纬度3.86~53.55，经度73.66~135.05
        return getLocation(3.86, 53.55);
    }

    public static String getlat() {
        //中国的经纬度范围大约为：纬度3.86~53.55，经度73.66~135.05
        return getLocation(73.66, 135.05);

    }

    public static String getLocation(double min, double max) {
        Random random = new Random();
        double lon    = random.nextDouble() * (max - min) + min;
        //中国的经纬度范围大约为：纬度3.86~53.55，经度73.66~135.05
        return lon + "";
    }


    public static String getProvince() {
        String[] provinces = {
                "北京",
                "天津",
                "上海",
                "重庆",
                "河北",
                "山西",
                "辽宁",
                "吉林",
                "黑龙江",
                "江苏",
                "浙江",
                "安徽",
                "福建",
                "江西",
                "山东",
                "河南",
                "湖北",
                "湖南",
                "广东",
                "海南",
                "四川",
                "贵州",
                "云南",
                "陕西",
                "甘肃",
                "青海",
                "台湾",
                "内蒙古",
                "广西",
                "西藏"
        };
        Random random = new Random();
        int    i      = random.nextInt(provinces.length );
        return provinces[i];

    }

    public static void main(String[] args) {
        System.out.println(getProvince());
        System.out.println(getProvince());
        System.out.println(getProvince());
        System.out.println(getProvince());
        System.out.println(getProvince());
    }


    /**
     * @param MinLon：最新经度 MaxLon： 最大经度   MinLat：最新纬度   MaxLat：最大纬度    type：设置返回经度还是纬度
     * @return
     * @throws
     * @Title: randomLonLat
     * @Description: 在矩形内随机生成经纬度
     */

    public static String randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat, String type) {
        Random     random = new Random();
        BigDecimal db     = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String     lon    = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        if (type.equals("Lon")) {
            return lon;
        } else {
            return lat;
        }
    }


//    public static void main(String[] args) {
//        System.out.println("经度,纬度============= \n" + getLon() + "," + getlat());
//    }

}
