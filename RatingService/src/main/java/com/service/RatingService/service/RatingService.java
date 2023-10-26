package com.service.RatingService.service;

import com.service.RatingService.entity.Rating;
import com.service.RatingService.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingService implements IRatingService{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IRatingRepository ratingRepository;

    @Override
    public List<Rating> getAllRatingByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return  ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }
}
