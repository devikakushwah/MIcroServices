package com.service.Userservice.controller;

import com.service.Userservice.entity.User;
import com.service.Userservice.payload.UserResponsePayload;
import com.service.Userservice.service.IUserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public IUserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 =  userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @GetMapping("/{userId}")

    public ResponseEntity<UserResponsePayload> getUser(@PathVariable Long userId){
      UserResponsePayload userResponsePayload = userService.getUser(userId);
      return ResponseEntity.status(HttpStatus.OK).body(userResponsePayload);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user=  userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }



    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome msg");
    }
}
