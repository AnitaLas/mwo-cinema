import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Cinema {

    private String cinemaName;
    private String cinemaAddress;
    //protected LocalDateTime open =  LocalDateTime.parse("2018-01-11T10:00:00");
    //protected LocalDateTime close =  LocalDateTime.parse("2018-01-11T23:30:00");
    private HashMap<String, CinemaRoom> cinemaRooms;
    //protected HashMap<Integer, MovieScreenig> moovieCalendar;
    protected List<MovieScreenig> moovieCalendar;



    Cinema(){
        this.cinemaRooms = new HashMap<>();
        this.moovieCalendar = new ArrayList<>();
    }

    protected void setCinemaName(String cinemaName){
        this.cinemaName = cinemaName;
    }

    protected String getCinemaName(){
        return this.cinemaName;
    }

    protected void setCinemaAddress(String cinemaName){
        this.cinemaAddress = cinemaAddress;
    }

    protected String getCinemaAddress(String cinemaName){
        return cinemaAddress;
    }

    protected void addCinemaRoom(CinemaRoom cienamaRoom){
        this.cinemaRooms.put(cienamaRoom.getRoomName(),cienamaRoom);
    }

    protected CinemaRoom getCinemaRoom(String cinemaRoomName){
        return this.cinemaRooms.get(cinemaRoomName);
    }

    protected void addMovieScreenigToCalendar(MovieScreenig movieScreenigData){
        moovieCalendar.add(movieScreenigData);
    }

    protected List<MovieScreenig> getMoovieCalendar(){

        List<MovieScreenig> currentCalendar = new ArrayList<>();

        // sort by date
        for(MovieScreenig ms : moovieCalendar){
            // return only ms with today's date and h=currentH +1
            // + 7 day from current date
            // older remove from list?
        }


        return moovieCalendar;
        //return currentCalendar;
    }

    protected void printMovieScreeningData(MovieScreenig movieScreenig){

        System.out.println(" ");
        // print movie data
        //movieScreenig.movieData.printMovieData();


        // print date and hour
       // movieScreenig.printDateAndHourMovieScreening();


        // print room with reservation
        movieScreenig.cinemaRoom.printCinemaRoomData();

        //System.out.println(" ");

    }
}
