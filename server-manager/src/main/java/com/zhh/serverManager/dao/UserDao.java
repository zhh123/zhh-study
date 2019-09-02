package com.zhh.serverManager.dao;

import com.zhh.serverManager.model.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author:zhh
 * @Date:Created in 17:41 2019/6/18 0018
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByUserName(String userName);
}