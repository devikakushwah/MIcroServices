package com.service.HotelService.payload;

import com.service.HotelService.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HotelResponsePayload {
    private String id;

    private String name;

    private String location;

    private String about;

    private List<StaffResponsePayload> staffResponsePayload;
    public HotelResponsePayload(Hotel hotel){
        this.id = hotel.getId();
        this.about  = hotel.getAbout();
        this.name = hotel.getName();
        this.location = hotel.getLocation();
    }
}
