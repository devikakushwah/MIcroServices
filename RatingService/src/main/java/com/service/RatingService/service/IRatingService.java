package com.service.RatingService.service;

import com.service.RatingService.entity.Rating;

import java.util.List;

public interface IRatingService {

    List<Rating> getAllRatingByUserId(Long userId);

    List<Rating> getAllRatingByHotelId(String hotelId);

    Rating createRating(Rating rating);

    List<Rating> getAll();
}
