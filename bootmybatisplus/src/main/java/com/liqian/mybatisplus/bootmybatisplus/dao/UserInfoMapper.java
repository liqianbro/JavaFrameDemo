package com.liqian.mybatisplus.bootmybatisplus.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liqian.mybatisplus.bootmybatisplus.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from user_info")
    List<UserInfo> findAll();

}
