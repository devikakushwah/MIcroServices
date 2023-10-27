package com.service.HotelService.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStaffList(){
       return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList("FirstPerson", "SecondPerson","ThirdPersoj"));
    }
}
