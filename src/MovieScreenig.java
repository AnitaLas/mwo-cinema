import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieScreenig {

    private List<Object> screenigData;
    protected Movie movieData;
    protected String dateAndHourMovieScreening;
    protected  CinemaRoom cinemaRoom;


    MovieScreenig(Movie movieData, String dateAndHourMovieScreening, CinemaRoom cinemaRoom){
        this.movieData = movieData;
        this.dateAndHourMovieScreening= dateAndHourMovieScreening;
        this.cinemaRoom = cinemaRoom;
    }

    protected  List<Object>  getMovieScreeningData(){
        this.screenigData = new ArrayList<>();
        this.screenigData.add(movieData);
        this.screenigData.add(dateAndHourMovieScreening);
        this.screenigData.add(cinemaRoom);
        return screenigData;
    }

    protected List< Object> getScreenigData(){
        return this.screenigData;
    }

    protected Movie getMovieData() {
        return this.movieData;
    }

    protected String getDateAndHourMovieScreening() {
        return this.dateAndHourMovieScreening;
    }

    protected CinemaRoom getCinemaRoom() {
        return this.cinemaRoom;
    }

    protected void printDateAndHourMovieScreening(){
        LocalDateTime date = LocalDateTime.parse( this.dateAndHourMovieScreening);
        //date.getDayOfWeek()
        System.out.println("  "  + date.getDayOfWeek() + " " + date.getDayOfMonth() + " " + date.getMonth()
        + ",  " + date.getHour() +  ":" + date.getMinute());

    }


}