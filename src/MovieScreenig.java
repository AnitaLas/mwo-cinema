import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieScreenig {

    private HashMap<String, Object> screenigData;
    protected Movie movieData;
    private LocalDateTime dateAndTime;
    protected  CinemaRoom cinemaRoom;;

    MovieScreenig(Movie movieData, String dateAndTime, CinemaRoom cinemaRoom){
        this.movieData = movieData;
        this.dateAndTime= LocalDateTime.parse(dateAndTime);
        this.cinemaRoom = cinemaRoom;
    }

    protected HashMap<String, Object>  getMovieScreeningData(){
        this.screenigData = new HashMap<>();
        this.screenigData.put("movieData", movieData);
        this.screenigData.put("dateAndTime", dateAndTime);
        this.screenigData.put("cinemaRoom", cinemaRoom);
        return screenigData;
    }

    protected HashMap<String, Object> getScreenigData(){
        return this.screenigData;
    }

    protected Movie getMovieData() {
        return this.movieData;
    }

    protected LocalDateTime getDateAndTime(){
        return this.dateAndTime;
    }

    protected String getMovieScreenigDate() {
        return (String)this.screenigData.get("movieScreenigDate");
    }

    protected String getMovieScreenigHour() {
        return (String)this.screenigData.get("movieScreenigHour");
    }

    protected CinemaRoom getCinemaRoom() {
        return this.cinemaRoom;
    }

    protected void printDateAndHourMovieScreening(){
        LocalDateTime date = this.dateAndTime;
        //date.getDayOfWeek()
        System.out.println("  "  + date.getDayOfWeek() + " " + date.getDayOfMonth() + " " + date.getMonth()
        + ",  " + dateAndTime.getHour() +  ":" + dateAndTime.getMinute());

    }


}