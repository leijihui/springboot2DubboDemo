package com.lazy.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lazy.dubbo.dto.UserDTO;
import com.lazy.dubbo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@Slf4j
@Api(value = "/user", tags = "dubbo测试")
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping(value = "/query")
    @ApiOperation(value = "dubbo服务RPC查询用户信息", notes = "dubbo服务RPC查询用户信息", response = String.class)
    public String getUser(@RequestParam(value = "id", defaultValue = "1", required = true) int id) {
        UserDTO user = userService.getUser(id);
        if (user != null) {
            log.info(user.toString());
            return user.toString();
        }
        log.info("user is not exist!");
        return "user is not exist!";
    }
}
