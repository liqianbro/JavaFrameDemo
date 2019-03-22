package com.liqian.mybatisplus.bootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liqian.mybatisplus.bootmybatisplus.dao.UserInfoMapper;
import com.liqian.mybatisplus.bootmybatisplus.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootmybatisplusApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() throws Exception {
        List<UserInfo> userInfoList = userInfoMapper.findAll();

        UserInfo userInfo = userInfoMapper.selectById(1);

        System.out.println(userInfo.toString());

        System.out.println(userInfoList.toString());
    }

}
