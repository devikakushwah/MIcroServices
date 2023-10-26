package com.service.RatingService.repository;

import com.service.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRatingRepository extends JpaRepository<Rating, Long> {

    @Query(value = "select * from rating where user_id = ?1", nativeQuery = true)
    public List<Rating> findByUserId(Long userId);

    @Query(value = "select * from rating where hotel_id = ?1", nativeQuery = true)
    public List<Rating> findByHotelId(String hotelId);
}
