package com.booterror.errordemo.controller;


import com.booterror.errordemo.pojo.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
//@Validated
public class ValidController {


    @GetMapping("/get-args-valid")
    public String getArgsValid(@NotNull(message = "用户名不能为空") String username, @NotNull(message = "密码不能为空") String password) {
        return null;
    }


    @PostMapping("/post-args-valid")
    public String postArgsValid(@Valid @RequestBody User user) {
        return null;
    }


}
