package com.service.Userservice.controller;

import com.service.Userservice.entity.User;
import com.service.Userservice.payload.UserResponsePayload;
import com.service.Userservice.service.IUserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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

    int retryCount = 1;

    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingFallBackMethod")
//    @Retry(name = "ratingHotelService" , fallbackMethod = "ratingFallBackMethod")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingFallBackMethod")
    public ResponseEntity<UserResponsePayload> getUser(@PathVariable Long userId){
      UserResponsePayload userResponsePayload = userService.getUser(userId);
//        logger.info("retry:{} count", retryCount);
      return ResponseEntity.status(HttpStatus.OK).body(userResponsePayload);
    }

//    creating fallback method for circuit breaker if circuit breaker failed called fallback method and return type always same of method
    public ResponseEntity<UserResponsePayload> ratingFallBackMethod(Long userId, Exception exception){
//        logger.info("fallback method is exceuted beacause server is down:{}", exception);
      UserResponsePayload userResponsePayload  =  UserResponsePayload.builder().email("dummy@gmail.com").userName("dummy").roles("dummy").build();
      return new ResponseEntity<>(userResponsePayload,HttpStatus.OK);
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
