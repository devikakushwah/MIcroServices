package com.service.Userservice.service;


import com.service.Userservice.entity.User;

public interface IUserService {

    public User saveUser(User user);

    public User getUser(Long id);
}
