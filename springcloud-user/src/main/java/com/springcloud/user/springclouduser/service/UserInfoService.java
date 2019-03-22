package com.springcloud.user.springclouduser.service;

import com.springcloud.user.springclouduser.Pojo.UserInfo;
import com.springcloud.user.springclouduser.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoService {

    @Autowired
    UserRepository userRepository;


    public UserInfo getUserInfoOne(Long id) {
        return userRepository.getUserInfoOne(id);
    }

}
