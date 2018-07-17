package com.repository;

import com.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 作者  :      fireworkor  3159553637@qq.com
 * 日期  :        2018/05/16  9:03  星期三
 * 描述  :
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
