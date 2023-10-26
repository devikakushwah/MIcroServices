package com.service.Userservice.payload;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Getter
@Setter
public class RatingResponsePayload {
    private Long ratingId;

    private String feedback;

    private int rating;

    private String userId;

    private String hotelId;

    private HotelResponsePayload hotel;
}

