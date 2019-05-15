package com.example.fristdemo.service;

import com.example.fristdemo.entity.user;
import com.github.pagehelper.Page;

import java.util.List;

public interface userService {
    user findUserById(Integer id);

    user login(String name,String password);

    void insert(user u);

    List<user> findAll();

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<user> findByPage(int pageNo, int pageSize);


}
