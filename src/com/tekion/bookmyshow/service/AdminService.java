package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.Address;
import com.tekion.bookmyshow.model.GenreType;
import com.tekion.bookmyshow.model.Screen;

import java.util.List;

import static com.tekion.bookmyshow.service.utils.ScannerUtils.scanner;

public class AdminService {
    public static AdminService INSTANCE = new AdminService();
    TheatreService theatreService;
    ScreenService screenService;
    ShowService showService;
    SeatService seatService;
    MovieService movieService;
    SeatCategoryService seatCategoryService;

    private AdminService() {
        this.theatreService = TheatreService.INSTANCE;
        this.screenService = ScreenService.INSTANCE;
        this.showService = ShowService.INSTANCE;
        this.seatService = SeatService.INSTANCE;
        this.movieService=MovieService.INSTANCE;
        this.seatCategoryService=SeatCategoryService.INSTANCE;
    }

    public void createTheatre() {
        System.out.println("Enter theatre name : ");
        String name = scanner().nextLine();
        System.out.println("Enter City: ");
        String city = scanner().nextLine();
        System.out.println("Enter PinCode: ");
        int pinCode = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter address line 1: ");
        String address1 = scanner().nextLine();
        System.out.println("Enter address line 2: ");
        String address2 = scanner().nextLine();

        Address address = new Address(city, pinCode, address1, address2);
        theatreService.createTheatre(name, address);
    }

    public void removeTheater() throws Exception {
        System.out.println("Enter the theatre id to remove the theatre: ");
        int id= scanner().nextInt();
        scanner().nextLine();
        theatreService.removeTheatre(id);
        List<Screen> screenListToRemove= screenService.removeScreenByTheatreId(id);
        for(Screen screen: screenListToRemove){
            seatService.removeSeatsByScreenId(screen.getId());
        }

    }

    public void createScreen() throws Exception {
        System.out.println("Enter theatre id: ");
        int theatreId = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter screen name: ");
        String name = scanner().nextLine();
        System.out.println("Enter total number of seats in theatre id : " + theatreId + " theatre: ");
        int totalSeats = scanner().nextInt();
        scanner().nextLine();

        screenService.createScreen(theatreId, name, totalSeats);
    }

    public void removeScreen(){
        System.out.println("Enter screen id to remove the screen: ");
        int screenId= scanner().nextInt();
        scanner().nextLine();
        screenService.removeScreen(screenId);
        seatService.removeSeatsByScreenId(screenId);
    }

    public void createShow() throws Exception {
        System.out.println("Enter movie id: ");
        int movieId = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter screen id: ");
        int screenId = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter start time: ");
        String startTime = scanner().nextLine();

        showService.createShow(movieId, screenId, startTime);

    }

    public void removeShow(){
        System.out.println("Enter the show id to remove the show: ");
        int showId= scanner().nextInt();
        scanner().nextLine();
        showService.removeShow(showId);
    }

    public void createSeatCategory(){
        System.out.println("Enter seat category price : ");
        int price= scanner().nextInt();
        scanner().nextLine();
        seatCategoryService.createCategory(price);
    }

    public void createSeats() throws Exception {
        System.out.println("Enter screen id: ");
        int screenId = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter the seat category id : ");
        scanner().nextLine();
        int categoryId = scanner().nextInt();
        scanner().nextLine();
        System.out.println("Enter total seats for category id " + categoryId + ": ");
        int seats = scanner().nextInt();
        scanner().nextLine();
        for (int i = 0; i < seats; i++) {
            seatService.createSeat(screenId, categoryId);
        }
    }

    public void removeSeat(){
        System.out.println("Enter seat id to remove: ");
        int id = scanner().nextInt();
        scanner().nextLine();
        seatService.removeSeat(id);
    }

    public void createMovie(){
        System.out.println("Enter movie name: ");
        String name= scanner().nextLine();
        System.out.println("Enter movie duration: ");
        String duration = scanner().nextLine();
        System.out.println("Enter movie description: ");
        String description = scanner().nextLine();
        System.out.println("Enter genre type for movie: ");
        GenreType genreType = GenreType.valueOf(scanner().nextLine());
        System.out.println("Enter movie's director name: ");
        String directorName= scanner().nextLine();

        movieService.createmMovie(duration, name, description,genreType, directorName);
    }

    public void removeMovie(){
        System.out.println("Enter movie id to remove movie: ");
        int id = scanner().nextInt();
        scanner().nextLine();
        movieService.removeMovie(id);
    }
}
