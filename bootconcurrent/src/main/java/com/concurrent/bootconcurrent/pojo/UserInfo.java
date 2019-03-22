package com.concurrent.bootconcurrent.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String userName;
    private String name;
    private Integer age;
    private BigDecimal balane;


}
