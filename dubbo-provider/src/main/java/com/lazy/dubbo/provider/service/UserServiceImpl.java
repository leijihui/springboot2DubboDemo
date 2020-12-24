package com.lazy.dubbo.provider.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.lazy.dubbo.dto.UserDTO;
import com.lazy.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;


@Service(version = "1.0.0")
@Slf4j
public class UserServiceImpl implements UserService {
    static ArrayList<UserDTO> userList = new ArrayList<>();

    static {
        userList.add(new UserDTO(1, "张三", "男"));
        userList.add(new UserDTO(2, "李四", "男"));
        userList.add(new UserDTO(3, "王五", "女"));
        userList.add(new UserDTO(4, "赵六", "女"));
    }

    @Override
    public UserDTO getUser(Integer id) {
        for (UserDTO user : userList) {
            if (id == user.getId()) {
                log.info(user.toString());
                return user;
            }
        }
        return null;
    }
}
