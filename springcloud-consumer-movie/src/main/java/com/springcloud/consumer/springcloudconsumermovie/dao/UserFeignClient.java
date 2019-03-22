package com.springcloud.consumer.springcloudconsumermovie.dao;


import com.springcloud.consumer.springcloudconsumermovie.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "springcloud-user")
public interface UserFeignClient extends JpaRepository<Long, UserInfo> {

    UserInfo findById(@PathVariable("id") Long id);

}
