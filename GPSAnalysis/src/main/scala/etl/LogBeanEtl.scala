package etl

import bean.{Gps, LogBean}
import org.apache.spark.sql.{SaveMode, SparkSession}

/**
  * 作者  :      fireworkor  3159553637@qq.com
  * 日期  :        2018/05/16  22:58  星期三
  * 描述  :   
  *
  */
object LogBeanEtl extends Etl {


  override def string2Parquet(session: SparkSession): Unit = {
    val dataInputPath = "data/etl/input/differentCarSameTimeAddress.log"
    val dataOutputPath = "data/report/index3"

    //    用户标识，任务id，时间，经纬度，速度
    //    "mac","taskid","time","lat","lon","speed"
    val data = session.sparkContext.textFile(dataInputPath).map(_.split(",", -1))
    import session.implicits._
    val dataFrame = data.map(LogBean(_)).toDF
    dataFrameShow(dataFrame)

    dataFrame.write.mode(SaveMode.Overwrite) parquet dataOutputPath
  }

  override def cvs2Parquet(session: SparkSession): Unit = {}
}
