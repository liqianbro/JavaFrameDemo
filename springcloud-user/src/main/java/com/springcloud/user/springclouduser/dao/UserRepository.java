package com.springcloud.user.springclouduser.dao;

import com.springcloud.user.springclouduser.Pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserInfo, Long> {


    @Query(value = "select * from user_info where id=?1", nativeQuery = true)
    public UserInfo getUserInfoOne(Long id);

}
