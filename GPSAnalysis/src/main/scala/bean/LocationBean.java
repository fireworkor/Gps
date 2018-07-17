package bean;

/**
 *  作者  :   fireworkor  3159553637@qq.com
 *  时间  :   2018/5/20/0020  9:02
 *  描述  :
 *
 */

public class LocationBean {
    public static final double MINLAT = -90;
    public static final double MAXLAT = 90;
    public static final double MINLNG = -180;
    public static final double MAXLNG = 180;
    private double lat;//纬度[-90,90]  
    private double lng;//经度[-180,180]  

    public LocationBean(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
}  