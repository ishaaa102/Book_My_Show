package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.*;
import com.tekion.bookmyshow.repo.SeatRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tekion.bookmyshow.service.utils.ScannerUtils.scanner;

public class CustomerService {
    public static CustomerService INSTANCE = new CustomerService();

    private ScreenService screenService;
    private TheatreService theatreService;
    private ShowService showService;
    private MovieService movieService;
    private BookingService bookingService;
    private SeatBookingService seatBookingService;
    private SeatService seatService;
    private SeatCategoryService seatCategoryService;
    private PaymentService paymentService;

    private CustomerService() {
        theatreService = TheatreService.INSTANCE;
        screenService = ScreenService.INSTANCE;
        showService = ShowService.INSTANCE;
        movieService = MovieService.INSTANCE;
        bookingService = BookingService.INSTANCE;
        seatBookingService = SeatBookingService.INSTANCE;
        seatService = SeatService.INSTANCE;
        seatCategoryService = SeatCategoryService.INSTANCE;
        paymentService = PaymentService.INSTANCE;
    }

    public void viewTheatres() {
        List<Theatre> theatres = theatreService.getTheatres();
        for (Theatre theatre : theatres) {
            System.out.println(theatre);
        }
    }

    public void viewShows() {
        System.out.println("Enter theatre id");
        int theatreId = scanner().nextInt();
        scanner().nextLine();
        for (Screen screen : screenService.getScreenByTheatreID(theatreId)) {
            List<Show> showList = showService.getShowsByScreenId(screen.getId());
            for (Show show : showList) {
                System.out.println("Show is : " + show);
                System.out.println("Movie is:" + movieService.getMovieById(show.getMovieId()));
            }
        }
    }

    public void viewSeats() throws Exception {
        System.out.println("Enter show id: ");
        int showId = scanner().nextInt();
        scanner().nextLine();
        Show show = showService.getShowById(showId);
        if (show == null) {
            throw new Exception("Invalid show id");
        }

        List<Booking> bookingList = bookingService.getBookingByShowId(showId);
        Set<Integer> unavailableSeats = new HashSet<>();
        for (Booking booking : bookingList) {
//            System.out.println("Unavailable seats are: ");
            List<SeatBooking> seatBookingList = seatBookingService.getSeatBookingByBookingId(booking.getId());
            for (SeatBooking seatBooking : seatBookingList) {
                Seat seat = seatService.getSeatBySeatId(seatBooking.getSeatId());
                unavailableSeats.add(seat.getSeatNumber());
            }
        }

        List<Seat> seatList= seatService.getSeatsByScreenId(show.getScreenId());
        for(Seat seat: seatList){
            if(unavailableSeats.contains(seat.getSeatNumber())){
                System.out.println("seat no. "+seat.getSeatNumber()+" is not available");
            }else {
                System.out.println("seat no. "+seat.getSeatNumber()+" is available");
            }
        }

    }

    public void bookSeat() throws Exception {
        System.out.println("Enter show id for which you want to book the seats: ");
        int showId = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter no of seats : ");

        int noOfSeats = scanner().nextInt();
        scanner().nextLine();

        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < noOfSeats; i++) {
            System.out.println("Enter seat number: ");
            int seatNumber = scanner().nextInt();
            scanner().nextLine();
            seats.add(seatNumber);
        }

        int totalPrice = getTotalPrice(showId, seats);

        System.out.println("Total cost of tickets: "+totalPrice);

        Payment payment=processPayment(totalPrice);

        Booking booking = bookingService.createBooking(payment.getId(), showId, payment.getStatus());

        if (booking.getStatus() == BookingStatus.CONFIRMED) {

            Show show = showService.getShowById(showId);
            Movie movie= movieService.getMovieById(show.getMovieId());

            System.out.println("Booking confirmed for: ");
            System.out.println("show id: " + showId);
            System.out.println("Movie Name: " + movie.getName());
            System.out.println("no. of seats: "+ noOfSeats);
            System.out.println("seats numbers : "+ seats);

        } else {
            System.out.println("Booking is pending due to payment failure for show id: " + showId);
        }
    }

    private Payment processPayment(int totalPrice) throws Exception {
        while (true) {
            System.out.println("Enter payment method (UPI or CARD): ");
            PaymentMethod paymentMethod = PaymentMethod.valueOf(scanner().nextLine());

            System.out.println("Enter payment time: ");
            String paymentTime = scanner().nextLine();

            Payment payment = paymentService.createPayment(paymentMethod, totalPrice, paymentTime);

            if (payment.getStatus() == PaymentStatus.SUCCESS) {
                return payment;
            } else {
                System.out.println("Payment failed, want to retry? (yes or no)");
                if (!scanner().nextLine().equals("yes")) {
                    return payment;
                }
            }
        }
    }

    private int getTotalPrice(int showId, List<Integer> seats) throws Exception {
        int totalPrice = 0;

        Show show = showService.getShowById(showId);
        if (show == null) {
            throw new Exception("Invalid show id");
        }

        List<Seat> seatList = seatService.getSeatsByScreenId(show.getScreenId());
        for (Seat seat : seatList) {
            if (seats.contains(seat.getSeatNumber())) {
                SeatCategory seatCategory = seatCategoryService.getSeatCategoryById(seat.getCategoryId());
                totalPrice += seatCategory.getPrice();
            }
        }
        return totalPrice;
    }

    private void displaySeatsByScreenId(int screenId){
        seatService.getSeatsByScreenId(screenId);
    }

}
