package com.service.HotelService.service;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.external.StaffService;
import com.service.HotelService.payload.HotelResponsePayload;
import com.service.HotelService.payload.StaffResponsePayload;
import com.service.HotelService.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HotelService implements IHotelService{

    @Autowired
    IHotelRepository hotelRepository;

    @Autowired
    StaffService staffService;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public HotelResponsePayload getHotel(String id) {

        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new RuntimeException("Hotel not found !!"));
        HotelResponsePayload hotelResponsePayload = new HotelResponsePayload(hotel);
        StaffResponsePayload[] staffResponsePayload  = staffService.getStaff(hotel.getId());
        List<StaffResponsePayload> staffResponsePayloadList = Arrays.stream(staffResponsePayload).toList();
        hotelResponsePayload.setStaffResponsePayload(staffResponsePayloadList);
        return  hotelResponsePayload;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }
}
