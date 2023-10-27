package com.service.Userservice.service.external;

import com.service.Userservice.payload.HotelResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{hotelId}")
    HotelResponsePayload getHotel(@PathVariable("hotelId") String hotelId);
}
