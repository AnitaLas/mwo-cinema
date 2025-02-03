import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieScreenig {

    private HashMap<String, Object> screenigData;
    private Movie movieData;
    private LocalDate date;
    private LocalTime time;
    private  CinemaRoom cinemaRoom;;

    MovieScreenig(Movie movieData, String date,  String time, CinemaRoom cinemaRoom){
        this.movieData = movieData;
        this.date= LocalDate.parse(date);
        this.time= LocalTime.parse(time);
        this.cinemaRoom = cinemaRoom;
    }

    protected HashMap<String, Object>  getMovieScreeningData(){
        this.screenigData = new HashMap<>();
        this.screenigData.put("movieData", movieData);
        this.screenigData.put("cinemaRoom", cinemaRoom);
        return screenigData;
    }

    protected HashMap<String, Object> getScreenigData(){
        return this.screenigData;
    }

    protected Movie getMovieData() {
        return this.movieData;
    }

    protected LocalDate getDate(){
        return this.date;
    }

    protected LocalTime getTime(){
        return this.time;
    }

    protected String getMovieScreenigHour() {
        return (String)this.screenigData.get("movieScreenigHour");
    }

    protected CinemaRoom getCinemaRoom() {
        return this.cinemaRoom;
    }

    protected void printDateAndHourMovieScreening(){
        String movieStartMinute = (this.time.getMinute() < 10) ? ("0" + this.time.getMinute()) : Integer.toString(this.time.getMinute());

        System.out.println("  "  + this.date.getDayOfWeek() + ", " + this.date.getDayOfMonth() + " " + this.date.getMonth()
                + ", "  + this.time.getHour()+ ":" + movieStartMinute);
    }

    protected void printMovieScreeningData(){

        System.out.println(" ");
        System.out.println("------------------------------------------------------");
        // print movie data
        this.movieData.printMovieData();

        // print date and hour
        printDateAndHourMovieScreening();

        // print room with reservation
        cinemaRoom.printCinemaRoomData();
        System.out.println("------------------------------------------------------");
    }


}