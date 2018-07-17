package com.repository;

import com.bean.DiffHighSpeed;
import com.bean.DiffSlowSpeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/18  18:48  星期五
 * 描述  :
 */
@Repository
public interface DiffSlowSpeedRepository extends JpaRepository<DiffSlowSpeed,String>{
}
