package com.Isha.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private  String id;
    private String username;
    private String password;
    private UserType type;

    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.type = builder.type;
    }

    public static class Builder{
        private String username;
        private String password;
        private UserType type;

        public Builder username(String username){
            this.username=username;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public Builder type(UserType type){
            this.type=type;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }
}
