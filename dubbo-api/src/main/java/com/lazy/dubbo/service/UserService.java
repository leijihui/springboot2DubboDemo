package com.lazy.dubbo.service;


import com.lazy.dubbo.dto.UserDTO;

public interface UserService {
    UserDTO getUser(Integer id);
}
