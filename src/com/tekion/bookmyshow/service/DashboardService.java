package com.tekion.bookmyshow.service;

import com.tekion.bookmyshow.model.UserType;

import static com.tekion.bookmyshow.service.utils.ScannerUtils.scanner;

public class DashboardService {
    private UserService userService;

    AdminService adminService;
    CustomerService customerService;

    public DashboardService() {
        userService = UserService.INSTANCE;
        adminService=AdminService.INSTANCE;
        customerService=CustomerService.INSTANCE;
    }

    public void startBookMyShow() {
        while (true) {
            try {
               UserType userType= signIn();
               switch (userType){
                   case ADMIN :
                       showAdmin();
                       break;
                   case CUSTOMER:
                        showCustomer();
                        break;
               }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public UserType signIn() throws Exception {
        System.out.println("1. sign in as Admin : ");
        System.out.println("2. sign in as customer : ");
        int option = scanner().nextInt();
        scanner().nextLine();

        System.out.println("Enter user name: ");
        String userName = scanner().nextLine();
        System.out.println("Enter password: ");
        String password = scanner().nextLine();

        switch (option) {
            case 1:
                userService.validateUser(userName, password, UserType.ADMIN);
                return UserType.ADMIN;
            case 2:
                userService.validateUser(userName, password, UserType.CUSTOMER);
                return UserType.CUSTOMER;
            default:
                throw new Exception("Invalid choice provided.");
        }
    }

    private void showAdmin(){
        while(true) {
            try {
                System.out.println("1. Create theatre");
                System.out.println("2. Remove theatre");
                System.out.println("3. Create screen");
                System.out.println("4. Remove screen");
                System.out.println("5. Create show");
                System.out.println("6. Remove show");
                System.out.println("7. Create seat");
                System.out.println("8. Remove seat");
                System.out.println("9. Create movie");
                System.out.println("10. Remove movie");
                System.out.println("11. Create seat category");
                System.out.println("12. Exit");

                int option = scanner().nextInt();
                scanner().nextLine();

                switch (option) {
                    case 1:
                        adminService.createTheatre();
                        break;
                    case 2:
                        adminService.removeTheater();
                        break;
                    case 3:
                        adminService.createScreen();
                        break;
                    case 4:
                        adminService.removeScreen();
                        break;
                    case 5:
                        adminService.createShow();
                        break;
                    case 6:
                        adminService.removeShow();
                        break;
                    case 7:
                        adminService.createSeats();
                        break;
                    case 8:
                        adminService.removeSeat();
                        break;
                    case 9:
                        adminService.createMovie();
                        break;
                    case 10:
                        adminService.removeMovie();
                        break;
                    case 11:
                        adminService.createSeatCategory();
                        break;
                    case 12:
                        return;
                    default:
                        throw new Exception("Invalid choice of options");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showCustomer(){
        while(true){
            try {
                System.out.println("1. View theatres");
                System.out.println("2. View shows");
                System.out.println("3.View seats");
                System.out.println("4. Book seats");
                System.out.println("5. Exit");

                int option= scanner().nextInt();
                scanner().nextLine();

                switch (option){
                    case 1:
                        customerService.viewTheatres();
                        break;
                    case 2:
                        customerService.viewShows();
                        break;
                    case 3:
                        customerService.viewSeats();
                        break;
                    case 4:
                        customerService.bookSeat();
                        break;
                    case 5:
                        return;
                    default:
                        throw new Exception("Invalid choice of options");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
