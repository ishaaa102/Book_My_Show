package com.Isha.bookMyShow.service;

import com.Isha.bookMyShow.dto.BookingRequest;
import com.Isha.bookMyShow.entity.*;
import com.Isha.bookMyShow.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final ShowService showService;
    private final PaymentService paymentService;
    private final SeatBookingService seatBookingService;
    private final SeatService seatService;
    private final SeatCategoryService seatCategoryService;

    @Autowired
    public BookingService(BookingRepo bookingRepo, ShowService showService, PaymentService paymentService, SeatBookingService seatBookingService, SeatService seatService, SeatCategoryService seatCategoryService) {
        this.bookingRepo = bookingRepo;
        this.showService = showService;
        this.paymentService=paymentService;
        this.seatBookingService=seatBookingService;
        this.seatService=seatService;
        this.seatCategoryService = seatCategoryService;
    }

    public Booking createBooking(BookingRequest bookingRequest) throws Exception {
        for(String seatId:bookingRequest.getSeatIds()) {
            if (seatService.getSeatById(seatId) == null) {
                throw new Exception("Invalid seat ID");
            }
        }
        Show show = showService.getShowById(bookingRequest.getShowId());
        if (show==null) {
            throw new Exception("Invalid show ID");
        }

        int totalPrice = getTotalPrice(bookingRequest.getShowId(), new ArrayList<>(bookingRequest.getSeatIds()));
        Payment payment=paymentService.getPaymentById(bookingRequest.getPayId());

        if (payment.getAmount() != totalPrice) {
            throw new Exception("Payment amount does not match the total seat price");
        }

        // new Booking(payId, showId, paymentStatus);
        Booking booking = Booking.builder()
                .paymentId(bookingRequest.getPayId())
                .showId(show.getId())
                .paymentStatus(payment.getStatus())
                .build();
        final Booking savedBooking=bookingRepo.save(booking);
        for(String seatId:bookingRequest.getSeatIds()) {
            seatBookingService.createSeatBooking(savedBooking.getShowId(),seatId);
        }
       return savedBooking;
    }

    private int getTotalPrice(String showId, List<String> seatIds) throws Exception {
        int totalPrice = 0;
        Show show = showService.getShowById(showId);
        if (show == null) {
            throw new Exception("Invalid show ID");
        }

        List<Seat> seatList = seatService.getSeatsByScreenId(show.getScreenId());
        for (Seat seat : seatList) {
            if (seatIds.contains(seat.getId())) {
                SeatCategory seatCategory = seatCategoryService.getSeatCategoryById(seat.getCategoryId());
                totalPrice += seatCategory.getPrice();
            }
        }
        return totalPrice;
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
