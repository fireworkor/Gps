package tools;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import utils.LBSUtil;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 作者  :   fireworkor  3159553637@qq.com
 * 时间  :   2018/5/20/0020  13:23
 * 描述  :
 */
public class Geo {

    public static void main(String[] args) throws Exception {
        String lat = "47.008052";
        String lon = "130.723014";
        getProvice(lat, lon);
    }


    public static String getProvice(String lat, String lon) throws Exception {
        HttpClient httpClient = new HttpClient();
        // 计算 sn 跟参数对出现顺序有关， get 请求请使用LinkedHashMap 保存 <key,value> ，该方法根据 key 的插入顺序排序；
        // post 请使用 TreeMap 保存 <key,value> ，该方法会自动将 key按照字母 a-z 顺序排序。学大数据 上小牛学堂 老羊答疑:64341393
        // 所以 get 请求可自定义参数顺序（ sn 参数必须在最后）发送请求，但是 post 请求必须按照字母 a-z 顺序填充 body （ sn 参数必须在最后）。
        // 以 get 请求为例：
        // http://api.map.baidu.com/geocoder/v2/?address= 百度大厦 &output=json&ak=yourak ， paramsMap 中先放入 address ，再放output ，然后放 ak ，放入顺序必须跟 get 请求中对应参数的出现顺序保持一致。
        Map paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("callback", "renderReverse");
        paramsMap.put("location", lat + "," + lon); //纬度 , 经度 47.008052,130.723014
        paramsMap.put("output", "json");
        paramsMap.put("pois", "1"); // 是否显示指定位置周边的poi ， 0 为不显示， 1 为显示。当值为 1 时，默认显示周边 1000 米内的 poi 。
        // paramsMap.put("radius", "500"); // poi 召回半径，允许设置区间为 0-1000 米，超过 1000 米按 1000 米召回。
        paramsMap.put("ak", "XaXM6DZf6RyWdy3b7ju8wIPGC9y5Rn9t");
        String    paramsStr = LBSUtil.toQueryString(paramsMap);
        String    finalURL  = "http://api.map.baidu.com/geocoder/v2/?" + paramsStr + "&sn=" + LBSUtil.sn(paramsStr);
        GetMethod method    = new GetMethod(finalURL);
        int       i         = httpClient.executeMethod(method);
        if (i == 200) {
            String bodyAsString = method.getResponseBodyAsString();
            method.releaseConnection();
            if (!bodyAsString.startsWith("{")) {
                bodyAsString =
                        bodyAsString.replace("renderReverse&&renderReverse(", "");
                bodyAsString = bodyAsString.substring(0,
                        bodyAsString.length() - 1);
            }
            System.out.println("bodyAsString = " + bodyAsString);
            // json 解析结果数据 , 解析出来 bussiness
            String result            = LBSUtil.fromJsonStringGetString(bodyAsString, "result");
            String formatted_address = LBSUtil.fromJsonStringGetString(result, "formatted_address");


            System.out.println(formatted_address);
            String addressComponent = LBSUtil.fromJsonStringGetString(result, "addressComponent");
            String province         = LBSUtil.fromJsonStringGetString(addressComponent, "province");
            System.out.println(province);

            return province;

        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return "error";
        }
    }
    public static String getAddress(String lat, String lon) throws Exception {
        HttpClient httpClient = new HttpClient();
        // 计算 sn 跟参数对出现顺序有关， get 请求请使用LinkedHashMap 保存 <key,value> ，该方法根据 key 的插入顺序排序；
        // post 请使用 TreeMap 保存 <key,value> ，该方法会自动将 key按照字母 a-z 顺序排序。学大数据 上小牛学堂 老羊答疑:64341393
        // 所以 get 请求可自定义参数顺序（ sn 参数必须在最后）发送请求，但是 post 请求必须按照字母 a-z 顺序填充 body （ sn 参数必须在最后）。
        // 以 get 请求为例：
        // http://api.map.baidu.com/geocoder/v2/?address= 百度大厦 &output=json&ak=yourak ， paramsMap 中先放入 address ，再放output ，然后放 ak ，放入顺序必须跟 get 请求中对应参数的出现顺序保持一致。
        Map paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("callback", "renderReverse");
        paramsMap.put("location", lat + "," + lon); //纬度 , 经度 47.008052,130.723014
        paramsMap.put("output", "json");
        paramsMap.put("pois", "1"); // 是否显示指定位置周边的poi ， 0 为不显示， 1 为显示。当值为 1 时，默认显示周边 1000 米内的 poi 。
        // paramsMap.put("radius", "500"); // poi 召回半径，允许设置区间为 0-1000 米，超过 1000 米按 1000 米召回。
        paramsMap.put("ak", "XaXM6DZf6RyWdy3b7ju8wIPGC9y5Rn9t");
        String    paramsStr = LBSUtil.toQueryString(paramsMap);
        String    finalURL  = "http://api.map.baidu.com/geocoder/v2/?" + paramsStr + "&sn=" + LBSUtil.sn(paramsStr);
        GetMethod method    = new GetMethod(finalURL);
        int       i         = httpClient.executeMethod(method);
        if (i == 200) {
            String bodyAsString = method.getResponseBodyAsString();
            method.releaseConnection();
            if (!bodyAsString.startsWith("{")) {
                bodyAsString =
                        bodyAsString.replace("renderReverse&&renderReverse(", "");
                bodyAsString = bodyAsString.substring(0,
                        bodyAsString.length() - 1);
            }
            System.out.println("bodyAsString = " + bodyAsString);
            // json 解析结果数据 , 解析出来 bussiness
            String result            = LBSUtil.fromJsonStringGetString(bodyAsString, "result");
            String formatted_address = LBSUtil.fromJsonStringGetString(result, "formatted_address");


            System.out.println(formatted_address);
            String addressComponent = LBSUtil.fromJsonStringGetString(result, "addressComponent");
            String province         = LBSUtil.fromJsonStringGetString(addressComponent, "province");
            System.out.println(province);

            return province;

        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            return "error";
        }
    }

}
