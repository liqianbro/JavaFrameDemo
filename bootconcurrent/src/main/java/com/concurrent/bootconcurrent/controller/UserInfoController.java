package com.concurrent.bootconcurrent.controller;

import com.concurrent.bootconcurrent.pojo.UserInfo;
import com.concurrent.bootconcurrent.service.impl.UserInfoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserInfoController {


    @Autowired
    UserInfoServiceImpl userInfoService;


    @PostMapping("/insertUser")
    public String insertUser(HttpServletRequest request, HttpServletResponse response) {
        long start = System.currentTimeMillis();


        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("lq");
        userInfo.setAge(22);
        userInfo.setName("Lee");
        userInfoService.insertUser(userInfo);


        long end = System.currentTimeMillis();
        log.info("完成任务，耗时：" + (end - start) + "毫秒");
        return "ok";
    }



}
