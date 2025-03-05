package com.tekion.bookmyshow.repo;

import com.tekion.bookmyshow.model.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepo {
    public static PaymentRepo INSTANCE = new PaymentRepo();
    private int id = 0;
    private Map<Integer, Payment> paymentMap = new HashMap<>();

    private PaymentRepo() {
    }

    public Payment savePayment(Payment payment) {
        id++;
        payment.setId(id);
        paymentMap.put(id, payment);
        return payment;
    }

//    public Payment getPayment(int paymentId){
//        return paymentMap.get(paymentId);
//    }
}
