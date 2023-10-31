package com.service.HotelService.external;

import com.service.HotelService.payload.StaffResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STAFF-SERVICE")
public interface StaffService {

    @GetMapping("/staff/hotel/{hotelId}")
    StaffResponsePayload[] getStaff(@PathVariable String hotelId);

}
