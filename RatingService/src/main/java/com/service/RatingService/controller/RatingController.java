package com.service.RatingService.controller;

import com.service.RatingService.entity.Rating;
import com.service.RatingService.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private IRatingService ratingService;

    @PostMapping("/save")
   public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
       Rating rating1 = ratingService.createRating(rating);
       return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
   }

   @GetMapping("/all")
   public ResponseEntity<List<Rating>> getAllRating(){
      List<Rating> ratings =  ratingService.getAll();
      return ResponseEntity.status(HttpStatus.OK).body(ratings);
   }

   @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable Long userId){
       List<Rating> ratings =  ratingService.getAllRatingByUserId(userId);
       return ResponseEntity.status(HttpStatus.OK).body(ratings);
   }

   @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratings =  ratingService.getAllRatingByHotelId(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
}
