package com.example.fristdemo.controller;

import com.example.fristdemo.entity.PageInfo;
import com.example.fristdemo.entity.user;
import com.example.fristdemo.service.userService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/user"})
public class userController {
    @Autowired
    private userService service;

    @RequestMapping(value = {"/hello"})
    @ResponseBody
    public PageInfo<user> findPage() {
        Page<user> users = service.findByPage(1,2);
        String name1=users.get(0).getUsername();
        System.out.println(name1);
        PageInfo<user> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @RequestMapping(value = {"/selectUser"})
    public user selectUser() {
        //user u = service.findUserById(123456);
        return u;
    }

    @RequestMapping(value = "/")
    public String login() {
        return "login.html";
    }

    @RequestMapping(value = "/loginPage")
    public String login(HttpServletRequest request, HttpSession session) {
        String tno = request.getParameter("tno");
        String password = request.getParameter("password");
        user u = service.login(tno, password);
        if (u == null) {
            return "redirect:/";
        } else {
            session.setAttribute("user", u.getUsername());
            return "redirect:/user/index";
        }
    }

    @RequestMapping(value = "/index")
    public String loginIndex() {
        return "hello.html";
    }


}

