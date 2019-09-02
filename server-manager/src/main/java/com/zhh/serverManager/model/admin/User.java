package com.zhh.serverManager.model.admin;

import javax.persistence.*;

/**
 * @Author:zhh
 * @Date:Created in 17:35 2019/6/18 0018
 */
@Entity
@Table(name = "t_sys_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String userName;
    @Column
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}