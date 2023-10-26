package com.service.HotelService.controller;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.OK).body(hotel1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotels(@PathVariable Long id){
       Hotel hotel = hotelService.getHotel(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }
}
