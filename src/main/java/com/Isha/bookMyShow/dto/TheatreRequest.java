package com.Isha.bookMyShow.dto;

import com.Isha.bookMyShow.entity.Address;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Getter
@Setter
public class TheatreRequest {

    private String name;
    private Address address;
}
