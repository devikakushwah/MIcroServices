package com.service.HotelService.repository;

import com.service.HotelService.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IHotelRepository extends MongoRepository<Hotel, String> {
}
