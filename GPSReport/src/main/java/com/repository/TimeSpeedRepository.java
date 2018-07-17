package com.repository;

import com.bean.TimeSpeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/18  17:33  星期五
 * 描述  :
 */
@Repository
public interface TimeSpeedRepository extends JpaRepository<TimeSpeed,String> {
}
