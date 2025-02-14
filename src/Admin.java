
import java.util.*;

public class Admin {
    Map<String, List<Movie>> LocationToMovieMap = new HashMap<>();
    List<User>userList;
    Admin( Map<String, List<Movie>> LocationToMovieMap, List<User> userList){
        this.LocationToMovieMap=LocationToMovieMap;
        this.userList=userList;
    }
    void manage(){
        while(true){
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter  Your Choice as Admin");

            System.out.println("1.Add Movie for a particular Location");
            System.out.println("2.Show All Locations and Movies");
            System.out.println("3.Remove any show ");
            System.out.println("4. Show all bookings made");
            int userChoice= sc.nextInt();
            sc.nextLine();

            if(userChoice==1){

                System.out.println("Enter Location where u want to add Movie");
                String location=sc.nextLine();
                System.out.println("Enter Movie name");
                String movie=sc.nextLine();
                System.out.println("Enter the showtime for the movie you want to add ");
                String time= sc.nextLine();
                if(LocationToMovieMap.containsKey(location)){
                    List<Movie>movies=LocationToMovieMap.get(location);
                    int idx=-1;
                    int i=0;
                    for(Movie mov:movies){
                        if(mov.name.equals(movie)){
                            idx=i;
                            break;
                        }i++;

                    }if(idx!=-1) {// if movie exists
                        Movie movieToEdit = movies.get(idx);
                        List<Show> showToEdit = movieToEdit.shows;
                        showToEdit.add(new Show(time));
                        movies.add(new Movie(movie, 250, new ArrayList<>(showToEdit)));
                    }else{// if movie does not exist
                        List<Show>showToEdit= new ArrayList<>();
                        showToEdit.add(new Show(time));
                        movies.add(new Movie(movie,300,new ArrayList<>(showToEdit)));
                    }
                    System.out.println("New Show Added Succesfully !!");

                }else{// new location addition
                    List<Movie>movies=new ArrayList<>();
                    List<Show>showToEdit= new ArrayList<>();
                    showToEdit.add(new Show(time));
                    movies.add(new Movie(movie,300,new ArrayList<>(showToEdit)));
                    LocationToMovieMap.put(location,movies);
                    System.out.println("New Show Added Succesfully !!");
                }


            }else if(userChoice==2) {
                for (String city : LocationToMovieMap.keySet()) {
                    System.out.println("\n " + city);
                    List<Movie> movies = LocationToMovieMap.get(city);
                    int i = 1;
                    for (Movie movie : movies) {
                        System.out.print(i + ". ");
                        movie.display();
                        i++;
                    }
                }
            }else if(userChoice==3){
                System.out.println("Enter Location where u want to delete show  of a Movie");
                String location=sc.nextLine();
                System.out.println("Enter Movie name");
                String movie=sc.nextLine();
                System.out.println("Enter Shows for the movie which needs to be deleted ");
                String time= sc.nextLine();
                List<Movie>movies=LocationToMovieMap.get(location);
                Movie movieToDelete= new Movie();
                int idx=-1;
                int i=0;
                for(Movie mov:movies){
                    if(mov.name.equals(movie)){
                        idx=i;
                        movieToDelete= mov;
                        break;
                    }i++;

                }if(idx!=-1) {
                    Movie movieToEdit = movies.get(idx);
                    List<Show> showToEdit = movieToEdit.shows;
                    int idxx=0;
                    for(Show show:showToEdit){
                        if(show.startTime.equals(time)){
                            showToEdit.remove(idxx);
                            if(showToEdit.size()==0){
                                movies.remove(movieToDelete);
                            }
                            System.out.println("The Show is Deleted Successfully");
                            break;
                        }idxx++;
                    }

                } else {
                    System.out.println("Movie not found at this location");
                }
            }
            else{

                System.out.println("Here is the list of bookings made !!");
                for (User currUser : userList) {
                    System.out.println(currUser.name + " : ");
                    currUser.showBooking();

                }

            }

        }
    }
}
