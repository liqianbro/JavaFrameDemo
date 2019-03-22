package com.springcloud.consumer.springcloudconsumermovie.controller;

import com.springcloud.consumer.springcloudconsumermovie.dao.UserFeignClient;
import com.springcloud.consumer.springcloudconsumermovie.pojo.UserInfo;
import com.springcloud.consumer.springcloudconsumermovie.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {


    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    UserInfoService userInfoService;


    @GetMapping("/user/{id}")
    public UserInfo findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://springcloud-user/" + id, UserInfo.class);
        return userInfoService.findById(id);
    }

    @GetMapping("user-instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("springcloud-user");
    }

}
