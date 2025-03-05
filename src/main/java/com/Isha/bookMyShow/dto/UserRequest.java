package com.Isha.bookMyShow.dto;

import com.Isha.bookMyShow.entity.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String username;
    private String password;
    private UserType type;
}
