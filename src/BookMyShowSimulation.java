
public class BookMyShowSimulation {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.book();
    }
}

/**
 *
 * function limit - 15 lines
 *
 * when to use static and non-static function
 *
 * function name - reflect what u r doing inside the function
 *
 *  Movie -> name, duration, other metadata related to movie, imdb rating, languages, genres, release date
 *
 *  Show -> startTime, duration, screenNo, movieId, Seating Arrangement
 *
 *  show123 -> 12 pm, 2 hour, 3, movie123 (Piku) , [0 - u1,1 - u1,2,3,4,5 ... 10], type - 2d, 3d, imax
 *
 *  show456 -> 2 pm, 2 hour, 3, movie123 (Piku) , [0 - u2, 1 - u2,2,3,4,5 ... 10]
 *
 *  Theater -> name, location, List<Show>
 *
 *
 *  BookMyShow Customer
 *      1 - take location/city from user
 *      2 - print all theates in selected city
 *      3 - select theatre
 *      4 - print all shows available in that theatre [movie name and timings]
 *      5 - select one show - movie 9pm
 *      6 - select number of seats - 3
 *      7 - you have to pay - 300 for 3 seats , which payment method u want to use? upi, card
 *      8 - select payment method
 *      9 - enter upi id
 *      10 - u will receive payment link, please pay.
 *      11 - success or failed
 *      12 - success
 *      13 - booked , thanks
 */