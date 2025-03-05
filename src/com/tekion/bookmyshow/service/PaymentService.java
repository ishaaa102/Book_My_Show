package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Payment;
import com.tekion.bookmyshow.model.PaymentMethod;
import com.tekion.bookmyshow.repo.PaymentRepo;

public class PaymentService {
    public static PaymentService INSTANCE = new PaymentService();

    PaymentRepo paymentRepo;

    private PaymentService() {
        this.paymentRepo = PaymentRepo.INSTANCE;
    }

    public Payment createPayment(PaymentMethod payMethod, int amount, String time) {
        Payment payment = new Payment(payMethod, amount, time);
        paymentRepo.savePayment(payment);
        return payment;
    }

//    public Payment retryPayment(PaymentMethod method, int amount, String paymentTime) {
//        System.out.println("Retrying payment");
//        return createPayment(method, amount, paymentTime);
//    }

//    public Payment getPaymentById(int paymentId){
//        return paymentRepo.getPayment(paymentId);
//    }
}
