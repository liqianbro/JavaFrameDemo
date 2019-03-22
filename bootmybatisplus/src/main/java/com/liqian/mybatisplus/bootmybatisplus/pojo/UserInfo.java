package com.liqian.mybatisplus.bootmybatisplus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private Long id;
    private String userName;
    private String name;
    private Integer age;
    private BigDecimal balane;

}
