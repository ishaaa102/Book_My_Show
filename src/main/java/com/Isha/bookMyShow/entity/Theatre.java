package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "theatres")
@Getter
@Setter
@NoArgsConstructor
public class Theatre {

    @Id
    private String id;
    private String name;
    private Address address;

    private Theatre(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }


    public static class Builder {
        private String id;
        private String name;
        private Address address;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Theatre build() {
            return new Theatre(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
