package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Address")
public class Address {
    private String city;
    private int pincode;
    private String addressLine1;
    private String addressLine2;

    public Address(String city, int pincode, String addressLine1, String addressLine2) {
        this.city = city;
        this.pincode = pincode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public String toString(){
        return "Address{city='"+city+"', pincode="+pincode+" , addressLine1='"+addressLine1+"', addressLine2='"+addressLine2+"'}";
    }
}
