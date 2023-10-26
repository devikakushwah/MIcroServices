package com.service.Userservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
