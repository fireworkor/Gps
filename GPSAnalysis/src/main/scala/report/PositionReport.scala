package report

import org.apache.spark.sql.SparkSession
import utils.MysqlUtil


/**
  * 作者  :   fireworkor  3159553637@qq.com
  * 时间  :   2018/5/4/0004  14:07
  * 描述  :
  * 微博： 同一用户的地理位置 （某个用户的活动范围）
  * 不同用户的地理位置（车辆分布）
  *
  */
object PositionReport extends Report {

  def report(session: SparkSession): Unit = {

//    getTimePosition(session)
    getUserPosition(session)
//    getUserPositionWeight(session)

  }

  /**
    * 同一用户的不同时间的位置
    *
    * @param session
    */
  def getTimePosition(session: SparkSession): Unit = {
    val dataInputPath = "data/report/index4/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    dataFrameShow(data)
    val res = session.sql("select time,address from data order by time desc ")
//session.sql( "select  * from data").show()
    MysqlUtil.insert2Mysql(res, "timeposition")
  }


  /**
    * 同一用户在不同的位置权重（常待的地点）
    *
    * @param session
    */
  def getUserPositionWeight(session: SparkSession): Unit = {
    val dataInputPath = "data/report/index4/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    val res = session.sql("select address ,count(1)  num from data group by address order by num desc ").where("address is not null and address not like '' and num !=0 and num is not null")
    //session.sql( "select  * from data").show()
    MysqlUtil.insert2Mysql(res, "userpositionweight")
  }

  /**
    * 不同用户的地理位置（车辆分布）某个时间内
    *
    * @param session
    */
  def getUserPosition(session: SparkSession): Unit = {
    val dataInputPath = "data/report/index3/"
    val data = session.read.parquet(dataInputPath)
    data.createTempView("data")
    val res = session.sql("select address,count(1) num from data group by address order by num desc")
    MysqlUtil.insert2Mysql(res, "userdistribution")

  }

}