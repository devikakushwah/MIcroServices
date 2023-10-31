package com.service.HotelService.service;

import com.service.HotelService.controller.HotelController;
import com.service.HotelService.entity.Hotel;
import com.service.HotelService.payload.HotelResponsePayload;

import java.util.List;

public interface IHotelService {

    public Hotel createHotel(Hotel hotel);

    public HotelResponsePayload getHotel(String id);

    public List<Hotel> getAllHotel();
}
