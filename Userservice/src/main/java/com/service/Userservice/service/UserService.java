package com.service.Userservice.service;

import com.service.Userservice.entity.User;
import com.service.Userservice.exception.ResourceNotFoundException;
import com.service.Userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found !!"));
    }
}
