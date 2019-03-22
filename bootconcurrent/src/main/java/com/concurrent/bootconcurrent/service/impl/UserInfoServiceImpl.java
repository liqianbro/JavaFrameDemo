package com.concurrent.bootconcurrent.service.impl;

import com.concurrent.bootconcurrent.dao.UserInfoMapper;
import com.concurrent.bootconcurrent.pojo.UserInfo;
import com.concurrent.bootconcurrent.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Async("asyncServiceExecutor")
    @Override
    public void insertUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        log.info("异步完成");
    }
}
