package com.tekion.bookmyshow.model;

import java.util.Random;

public class Payment {
    private int id; // pk
    private PaymentMethod payMethod;
    private int amount;
    private String time;
    private PaymentStatus status;

    public Payment(PaymentMethod payMethod, int amount, String time) {
        this.payMethod = payMethod;
        this.amount = amount;
        this.time = time;
        this.status = generateRandomStatus();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    private PaymentStatus generateRandomStatus() {
        Random random = new Random();
        return random.nextInt(100) < 60 ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
    }
}
