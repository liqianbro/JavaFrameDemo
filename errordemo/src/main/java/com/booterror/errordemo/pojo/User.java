package com.booterror.errordemo.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {

    @NotNull
    String username;
    
    @NotNull
    String password;


}
