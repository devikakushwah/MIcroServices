package com.service.Userservice.service;

import com.service.Userservice.entity.User;
import com.service.Userservice.exception.ResourceNotFoundException;
import com.service.Userservice.payload.HotelResponsePayload;
import com.service.Userservice.payload.RatingResponsePayload;
import com.service.Userservice.payload.UserResponsePayload;
import com.service.Userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserResponsePayload getUser(Long id) {

       User user =  userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found !!"));

       UserResponsePayload userResponsePayload = new UserResponsePayload(user);
       RatingResponsePayload[] ratings = restTemplate.getForObject("http://localhost:8083/rating/user/"+ user.getId(), RatingResponsePayload[].class);
        List<RatingResponsePayload> ratingList  = Arrays.stream(ratings).toList();
       List<RatingResponsePayload> rating1 = ratingList.stream().map(rating -> {
           HotelResponsePayload hotelResponsePayloads = restTemplate.getForEntity("http://localhost:8082/hotel/"+ rating.getHotelId(), HotelResponsePayload.class).getBody();
           rating.setHotel(hotelResponsePayloads);
           return rating;
       }).collect(Collectors.toList());

       userResponsePayload.setRatingList(ratingList);
       return userResponsePayload;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
