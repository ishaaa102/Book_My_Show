import java.util.*;

public class BookMyShow {

    public static final String ADMIN_USER_NAME="isha";
    public static final String ADMIN_PASSWORD ="123";


    Map<String, List<Movie>> LocationToMovieMap = new HashMap<>();
    List<User> userList = new ArrayList<>();

    Credentials credentials = new Credentials();

    BookMyShow() {
        List<Movie> kolkataMovies = new ArrayList<>(Arrays.asList(
                new Movie("Hera Pheri", 156, new ArrayList<>(Arrays.asList(new Show("10:00 AM"), new Show("6:00 PM")))),
                new Movie("Krrish 3", 200, new ArrayList<>(Arrays.asList(new Show("12:00 AM"), new Show("6:00 PM"))))
        ));
        LocationToMovieMap.put("kolkata", kolkataMovies);

        List<Movie> bangaloreMovies = new ArrayList<>(Arrays.asList(
                new Movie("Singham ", 156, new ArrayList<>(Arrays.asList(new Show("10:00 AM"), new Show("6:00 PM")))),
                new Movie("Piku", 200, new ArrayList<>(Arrays.asList(new Show("12:00 AM"), new Show("8:00 PM"))))
        ));
        LocationToMovieMap.put("bangalore", bangaloreMovies);
    }

    public void book() {
        System.out.println();
        System.out.println("Welcome to BookMyShow");
        System.out.println();
        while (true) {

            System.out.println("Enter your choice !!!");
            System.out.println("1.Sign Up");
            System.out.println("2.Sign In as Customer");
            System.out.println("3.Sign In as Admin");
            System.out.println("4.Exit ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            User user = null;
            sc.nextLine();

            if (choice == 1) {
                signUp(sc);

            } else if (choice == 2) {
                signInAsCustomer(sc);

            } else if (choice == 3) {
                signInAsAdmin(sc);
            } else {
                exit();
            }
        }
    }

    private void signUp(Scanner sc){
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        User user = new User(name, password);
        userList.add(user);
        credentials.addUser(name, password);
        System.out.println("Sign up is successfulll!!!! Now Sign In With ur Credentials");
        System.out.println();
    }

    private void signInAsAdmin(Scanner sc) {
        System.out.println(" ");
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        if (name.equals(ADMIN_USER_NAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println(" Weclome Admin : " + name);
            Admin admin = new Admin(LocationToMovieMap, userList);
            admin.manage();
        }
    }

    private void signInAsCustomer(Scanner sc){
        System.out.println(" ");
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();


        if (credentials.isValidUser(name, password) == true) {
            System.out.println("Sign in Successfull!!!");
            System.out.println();
            User user = new User(name, password);
            userList.add(user);
            Dashboard dashboard = new Dashboard(name, user, LocationToMovieMap);
            dashboard.show();
            while (true) {
                System.out.println("Enter Your Choice !!!");
                System.out.println("1. Show Your Bookings");
                System.out.println("2. Book another Ticket");
                System.out.println("3. Exit");
                int userchoice = sc.nextInt();
                if (userchoice == 3) {
                    System.out.println("Thanks for using BooKMyShow  ");
                    break;
                } else if (userchoice == 2) {
                    dashboard.show();
                } else {
                    user.showBooking();
                }

            }

        } else {
            System.out.println("Invalid username or password !!");
            System.out.println();
        }
    }

    private void exit(){
        System.out.println(" Byee!!! Thanks for Using BookMyShow \n");
    }
}
