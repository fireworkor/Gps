package bean


/**
  * 作者  :      fireworkor  3159553637@qq.com
  * 日期  :        2018/05/17  9:25  星期四
  * 描述  :
  *
  */
class Gps(
            val imei: String,
            val taskid: String,
            val time: String,
            val lat: String,
            val lon: String,
            val speed: String
          ) extends Product with Serializable {

  // 元素个属性的映射关系 log = new Log     log.productElement(0)
  //    用户标识，任务id，时间，经纬度，速度
  //    "mac","taskid","time","lat","lon","speed"
  override def productElement(n: Int): Any

  = n match {
    case 0 => imei
    case 1 => taskid
    case 2 => time
    case 3 => lat
    case 4 => lon
    case 5 => speed

  }

  // 类的属性有多少个
  override def productArity: Int

  = 6

  // 看对象是否已同一类型的对象
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Gps]
}

object Gps {

  def apply(arr: Array[String]): Gps = new Gps(
    arr(0),
    arr(1),
    arr(2),
    arr(3),
    arr(4),
    arr(5)
  )
}

