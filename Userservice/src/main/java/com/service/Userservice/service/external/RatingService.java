package com.service.Userservice.service.external;

import com.service.Userservice.payload.RatingResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{userId}")
    RatingResponsePayload[] getRating(@PathVariable Long userId);
}
