package com.service.Userservice.service;


import com.service.Userservice.entity.User;
import com.service.Userservice.payload.UserResponsePayload;

import java.util.List;

public interface IUserService {

    public User saveUser(User user);

    public UserResponsePayload getUser(Long id);

    public List<User> getAll();
}
