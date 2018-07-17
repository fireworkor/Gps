package report

import org.apache.spark.sql.SparkSession
import utils.MysqlUtil



/**
  * 作者  :   fireworkor  3159553637@qq.com
  * 时间  :   2018/5/4/0004  14:07
  * 描述  :
  *用户的最快
  */
object UserReport extends Report {

  def report(session: SparkSession): Unit = {
//    highSpeed(session,1)
//    slowSpeed(session,1)

  }



  def tst(session: SparkSession): Unit = {
    val dataInputPath = "data/report/input1/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    val data1 = session.sql("select imei,unix_timestamp(time, 'yyyy-MM-dd HH:mm:ss') times,lat,lon,speed from data ")
    data1.createTempView("data1")
    val data2 = session.sql("select imei,times,lat,lon,speed,row_number() over(partition by imei order by times ) rn from data1")
    data1.createTempView("data2")
    val res = session.sql("select imei,from_unixtime(times,'yyyy-MM-dd HH:mm:ss') time,lat,lon,speed from data2")
    //val t4 = session.sql("select openid,time1,time2,page1, row_number() over(partition by time2 order by time1 desc) rn from t3").where("rn=1 and openid is not null and openid not like ''")
    MysqlUtil.insert2Mysql(res, "samecar")
  }



}