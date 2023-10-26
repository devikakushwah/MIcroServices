package com.service.HotelService.service;

import com.service.HotelService.controller.HotelController;
import com.service.HotelService.entity.Hotel;

public interface IHotelService {

    public Hotel createHotel(Hotel hotel);

    public Hotel getHotel(Long id);
}
