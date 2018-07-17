package utils

import redis.clients.jedis.{ JedisPool, JedisPoolConfig}

/**
  * 作者  :      fireworkor  3159553637@qq.com
  * 日期  :        2018/01/30  14:38  星期二
  * 描述  :   
  *
  */
object RedisPool {
  val config = new JedisPoolConfig()
  //最大连接数,
  config.setMaxTotal(2000)
  //最大空闲连接数,
  config.setMaxIdle(10)
  //当调用borrow Object方法时，是否进行有效性检查 -->
  config.setTestOnBorrow(true)
  //10000代表超时时间（10秒）
 private lazy val  pool = new JedisPool(config, "127.0.0.1", 6379, 10000, "123456")

  def getJedis() = {
    pool.getResource
  }
}
