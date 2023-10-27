package com.service.Userservice.payload;

import com.service.Userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponsePayload {

    private String userName;

    private String email;

    private String password;

    private String roles;

    private List<RatingResponsePayload> ratingList = new ArrayList<>();

    public UserResponsePayload(User user){
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }
}
