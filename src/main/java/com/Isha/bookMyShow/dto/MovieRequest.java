package com.Isha.bookMyShow.dto;

import com.Isha.bookMyShow.entity.GenreType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class MovieRequest {
    String duration;
    String name;
    String description;
    GenreType genreType;
    String directorName;
}
