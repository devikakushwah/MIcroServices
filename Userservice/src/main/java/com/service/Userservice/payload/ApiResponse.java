package com.service.Userservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse {

    public String message;

    public Boolean success;

    public HttpStatus status;
}
