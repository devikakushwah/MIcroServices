package com.service.HotelService.service;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService implements IHotelService{

    @Autowired
    IHotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id.toString()).orElseThrow(()-> new RuntimeException("Hotel not found !!"));
    }
}
