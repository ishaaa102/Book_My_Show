package com.Isha.bookMyShow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Getter
@Setter
@Document(collection = "Payment")
public class Payment {

    @Id
    private String id; // pk
    private PaymentMethod payMethod;
    private int amount;
    private String time;
    private PaymentStatus status;

    public Payment() {
    }

    private Payment(Builder builder) {
        this.id= builder.id;
        this.payMethod = builder.payMethod;
        this.amount = builder.amount;
        this.time = builder.time;
        this.status = (builder.status != null) ? builder.status : generateRandomStatus();
    }

    public static class Builder {
        private String id; // pk
        private PaymentMethod payMethod;
        private int amount;
        private String time;
        private PaymentStatus status;

        public Builder id(String id){
            this.id=id;
            return this;
        }

        public Builder payMethod(PaymentMethod payMethod){
            this.payMethod=payMethod;
            return this;
        }

        public Builder amount(int amount){
            this.amount=amount;
            return this;
        }

        public Builder time(String time){
            this.time=time;
            return this;
        }

        public Builder status(PaymentStatus status){
            this.status=status;
            return this;
        }

        public Payment build(){
            return new Payment(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }

    private PaymentStatus generateRandomStatus() {
        Random random = new Random();
        return random.nextInt(100) < 60 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
}
