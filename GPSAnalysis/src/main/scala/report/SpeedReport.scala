package report

import org.apache.spark.sql.SparkSession
import utils.MysqlUtil


/**
  * 作者  :   fireworkor  3159553637@qq.com
  * 时间  :   2018/5/4/0004  14:07
  * 描述  :
  * 微博：
  * 同一用户不同时间下的不同速度
  * 不同用户的同一时间下的速度
  *  车速的topn，字符云
  */
object SpeedReport extends Report {

  def report(session: SparkSession): Unit = {
        diffHighSpeed(session)
    //    diffSlowSpeed(session)
//        getTimeSpeed(session)
    //    historyHighSpeed(session)
    //    doNotOrder(session)
//    userNum(session)
  }

  def diffHighSpeed(session: SparkSession, num: Int = 10): Unit = {
    val dataInputPath = "data/report/diffcar/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    val res = session.sql("select imei,speed,time from data order by speed desc").limit(num)
    dataFrameShow(res)
    MysqlUtil.insert2Mysql(res, "diffhighspeed")
  }

  def diffSlowSpeed(session: SparkSession, num: Int = 10): Unit = {
    val dataInputPath = "data/report/diffcar/"
    val data = session.read.parquet(dataInputPath)
    //    data.createTempView("data")
    val res = session.sql("select imei,speed,time from data order by speed").limit(num)
    dataFrameShow(res)
    MysqlUtil.insert2Mysql(res, "diffslowspeed")
  }

  /**
    * 时间维度下某个用户的速度
    */
  def getTimeSpeed(session: SparkSession, num: Int = 10): Unit = {
    val dataInputPath = "data/report/samecar/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    val res = session.sql("select time,speed from data").limit(num)
    MysqlUtil.insert2Mysql(res, "timespeed")
  }

  /**
    * 用户的历史最高速度top10
    *
    * @param session
    * @param num
    */
  def historyHighSpeed(session: SparkSession, num: Int = 10): Unit = {
    val dataInputPath = "data/report/diffcar/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    val res = session.sql("select imei,speed ,row_number() over(partition by imei order by speed desc) rn from data where rn =1").limit(num)
    dataFrameShow(res)
    MysqlUtil.insert2Mysql(res, "historyhighspeed")
  }

  //TODO ==============================================实时=====================================================================
  //TODO ==============================================实时=====================================================================
  /**
    * 超过多少的速度的就是不要命的人
    *
    * @param session
    * @param nolife
    */
  def doNotOrder(session: SparkSession, nolife: String = "90"): Unit = {
    val dataInputPath = "data/report/diffcar/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    //    val res =   session.sql("select  speed  nolife，count(*) from data where speed > " + nolife)
    val res = session.sql("select  count(*) num from data where speed > 90")
    dataFrameShow(res)
    MysqlUtil.insert2Mysql(res, "donotorder")
  }

  def userNum(session: SparkSession): Unit = {
    val dataInputPath = "data/report/diffcar/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    //    val res =   session.sql("select  speed  nolife，count(*) from data where speed > " + nolife)
    val res = session.sql("select  count(imei) num from data ")
    dataFrameShow(res)
    MysqlUtil.insert2Mysql(res, "usernum")
  }
}