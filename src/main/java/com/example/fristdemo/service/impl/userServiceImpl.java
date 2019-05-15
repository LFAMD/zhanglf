package com.example.fristdemo.service.impl;

import com.example.fristdemo.entity.user;
import com.example.fristdemo.mapper.userMapper;
import com.example.fristdemo.service.userService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper mapper;

    @Override
    public user findUserById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public user login(String name, String password) {
        return mapper.selectByNameAndPassword(name, password);
    }


    @Override
    public void insert(user u) {
        mapper.insert(u);
    }

    @Override
    public List<user> findAll() {
        return mapper.findAll();
    }


    @Override
    public Page<user> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return mapper.findByPage();
    }
}
