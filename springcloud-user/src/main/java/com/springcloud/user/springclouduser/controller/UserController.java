package com.springcloud.user.springclouduser.controller;

import com.springcloud.user.springclouduser.Pojo.UserInfo;
import com.springcloud.user.springclouduser.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public UserInfo findById(@PathVariable Long id) {
        UserInfo findOne = userRepository.getUserInfoOne(id);
        return findOne;
    }

}
