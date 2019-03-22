package com.springcloud.consumer.springcloudconsumermovie.service;

import com.springcloud.consumer.springcloudconsumermovie.dao.UserFeignClient;
import com.springcloud.consumer.springcloudconsumermovie.pojo.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserInfoService {

    @Autowired
    UserFeignClient userFeignClient;

    public UserInfo findById(Long id) {
        return userFeignClient.findById(id);
    }


}
