package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.BookingRequest;
import com.Isha.bookMyShow.entity.Booking;
import com.Isha.bookMyShow.entity.BookingStatus;
import com.Isha.bookMyShow.entity.Payment;
import com.Isha.bookMyShow.entity.Show;
import com.Isha.bookMyShow.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final ShowService showService;
    private final PaymentService paymentService;

    @Autowired
    public BookingService(BookingRepo bookingRepo, ShowService showService, PaymentService paymentService) {
        this.bookingRepo = bookingRepo;
        this.showService = showService;
        this.paymentService=paymentService;
    }

    public Booking createBooking(BookingRequest bookingRequest) throws Exception {
        Show show = showService.getShowById(bookingRequest.getShowId());
        if (show==null) {
            throw new Exception("Invalid show ID");
        }

        Payment payment=paymentService.getPaymentById(bookingRequest.getPayId());

        // new Booking(payId, showId, paymentStatus);
        Booking booking = Booking.builder()
                .paymentId(bookingRequest.getPayId())
                .showId(show.getId())
                .paymentStatus(payment.getStatus())
                .build();
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingRepo.findAll();
    }

    public Booking getBookingById(String bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(()-> new RuntimeException("booking not found of id "+ bookingId));
    }

    public List<Booking> getBookingsByShowId(String showId) {
        return bookingRepo.findByShowId(showId);
    }

    public Booking markBookingCompleted(String paymentId){
        Booking booking= bookingRepo.findByPaymentId(paymentId);
        if(booking==null){
            return null;
        }
        booking.setStatus(BookingStatus.CONFIRMED);
        return bookingRepo.save(booking);
    }

    public void deleteBooking(String id){
        bookingRepo.deleteById(id);
    }
}
