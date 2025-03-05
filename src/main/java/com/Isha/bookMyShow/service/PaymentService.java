package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.PaymentRequest;
import com.Isha.bookMyShow.entity.Payment;
import com.Isha.bookMyShow.entity.PaymentMethod;
import com.Isha.bookMyShow.entity.PaymentStatus;
import com.Isha.bookMyShow.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepo paymentRepo;
    private final BookingService bookingService;

    @Autowired
    public PaymentService(PaymentRepo paymentRepo, @Lazy BookingService bookingService) {
        this.paymentRepo = paymentRepo;
        this.bookingService=bookingService;
    }


    public Payment createPayment(PaymentRequest paymentRequest) {

        //new Payment(payMethod, amount, time);
        Payment payment = Payment.builder()
                        .payMethod(paymentRequest.getPayMethod())
                        .amount(paymentRequest.getAmount())
                        .time(paymentRequest.getTime())
                        .build();
        paymentRepo.save(payment);
        return payment;
    }

    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    public Payment getPaymentById(String id){
        return paymentRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("payment not found of id "+id));
    }

    public Payment retryPayment(String id, PaymentRequest paymentRequest) throws Exception {
        Payment payment=getPaymentById(id);
        if(payment.getStatus()== PaymentStatus.SUCCESS){
            throw new Exception("payment already successful, you cannot retry");
        }
        payment.setPayMethod(paymentRequest.getPayMethod());
        payment.setAmount(paymentRequest.getAmount());
        payment.setTime(paymentRequest.getTime());
        payment.setStatus(PaymentStatus.SUCCESS);
        paymentRepo.save(payment);

        bookingService.markBookingCompleted(id);

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
