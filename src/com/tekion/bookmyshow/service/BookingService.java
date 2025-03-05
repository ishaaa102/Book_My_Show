package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Booking;
import com.tekion.bookmyshow.model.BookingStatus;
import com.tekion.bookmyshow.model.PaymentStatus;
import com.tekion.bookmyshow.repo.BookingRepo;

import java.util.List;

public class BookingService {
    public static BookingService INSTANCE = new BookingService();

    BookingRepo bookingRepo;
    ShowService showService;

    private BookingService() {
        this.bookingRepo = BookingRepo.INSTANCE;
        this.showService = ShowService.INSTANCE;
    }

    public Booking createBooking(int payId, int showId, PaymentStatus paymentStatus) throws Exception {
        if (showService.getShowById(showId) == null) {
            throw new Exception("invalid show id");
        }
        Booking booking = new Booking(payId, showId, paymentStatus);
        bookingRepo.saveBooking(booking);

        return booking;
    }

    public Booking getBookingByBookingId(int bookingId){
        return bookingRepo.getBookingByBookingId(bookingId);
    }

    public List<Booking> getBookingByShowId(int showId){
        return bookingRepo.getBookingByShowId(showId);
    }


}
