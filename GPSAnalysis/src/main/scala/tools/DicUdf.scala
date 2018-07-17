package tools

import utils.{GeoHash, LBSUtil, RedisPool}

/**
  * 作者  :      fireworkor  3159553637@qq.com
  * 日期  :        2018/05/20  15:10  星期日
  * 描述  :   
  *
  */
object DicUdf {
  def makeDic(lat: String, lon: String) = {
    val geohash = GeoHash.getGeoHash(lat.toDouble, lon.toDouble)
//    val adress = LBSUtil.getProvice(lat, lon)
    val adress = Geo.getAddress(lat, lon)
    if("".equals(geohash)&&null!=geohash&&"".equals(adress)&&null!=geohash){
    val jedis = RedisPool.getJedis()
    jedis.select(1)
    jedis.set(geohash.toString, adress)
    }
    adress

  }
}
