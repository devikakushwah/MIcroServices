package com.service.HotelService.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaffResponsePayload {

    private String staffId;

    private String staffName;

    private String address;

    private String phoneNumber;

    private String role;

    private String hotelId;
}
