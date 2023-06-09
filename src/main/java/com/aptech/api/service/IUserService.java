package com.aptech.api.service;

import com.aptech.api.dto.UserDto;
import com.aptech.api.entity.Login;
import com.aptech.api.entity.User;

import java.util.List;

public interface IUserService {
    User add(User user);
    List<UserRecord> getAllUsers();
    void delete(String email);
    User getUser(String email);
    User update(User user);
     User updateUser(UserDto userDto);
     User getLoginUser(Login login);
}
