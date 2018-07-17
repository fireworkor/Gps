package dictionary

import org.apache.spark.sql.SparkSession
import utils.{DataFrameShow, MySparkUtil}

/**
  * 作者  :      fireworkor  3159553637@qq.com
  * 日期  :        2018/05/16  22:58  星期三
  * 描述  :   
  *   字典库的接口
  */
trait Dictionary extends DataFrameShow {

  /**
    * 字典库的主方法
    * @param args
    */
  def main(args: Array[String]): Unit = {
    MySparkUtil.checkArgs()
    val session = MySparkUtil.prepareSpark()
    makeRepository(session)
  }

  /**
    * 字典库默认调用的方法,子类重写方法,多态体现
    * @param session
    */
  def makeRepository(session: SparkSession);
}
