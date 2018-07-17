package dictionary


import org.apache.spark.sql.{Dataset, SparkSession}
import tools.DicUdf

/**
  * 作者  :      fireworkor  3159553637@qq.com
  * 日期  :        2018/05/16  22:58  星期三
  * 描述  :
  *   位置的字典库
  *   目的:将位置的geohash和address存入redis中
  */
object PrositionDictionary extends Dictionary {
  /**
    * 重写字典库接口的实现方法,生成字典文件
    * @param session
    */
  override def makeRepository(session: SparkSession): Unit = {
    val data = session.read.parquet("data\\report/samecar")
    data.createTempView("data")
  //TODO  sparksql中调用自定义的UDF方法
    session.udf.register("makedic", DicUdf.makeDic _)
    session.sql("select makedic(lat,lon) from data ").show(99)

    // .show(999999)


  }
}
