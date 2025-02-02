import java.time.LocalDateTime;
import java.util.*;

public class Cinema {

    //private String cinemaName;
    //private String cinemaAddress;
    protected Company company;
    private HashMap<String, String> cinemaData;
    //protected LocalDateTime open =  LocalDateTime.parse("2018-01-11T10:00:00");
    //protected LocalDateTime close =  LocalDateTime.parse("2018-01-11T23:30:00");
    private HashMap<String, CinemaRoom> cinemaRooms;
    private List<MovieScreenig> moovieCalendar;



    Cinema(){
        this.cinemaRooms = new HashMap<>();
        this.moovieCalendar = new ArrayList<>();
        this.cinemaData = new HashMap<>();
    }

    // to do - String cinemaName -> Cinema(){}
    protected void setCinemaName(String cinemaName){
        this.cinemaData.put("cinemaName", cinemaName);
    }

    protected String getCinemaName(){
        return this.cinemaData.get("cinemaName");
    }

    protected void setCinemaAddress(String cinemaAddress){
        this.cinemaData.put("cinemaAddress", cinemaAddress);
    }

    /*protected String getCinemaAddress(String cinemaAddress){
        return this.cinemaData.put("cinemaAddress", cinemaAddress);
    }*/

    protected void addCinemaRoom(CinemaRoom cinaemaRoom){
        cinaemaRoom.setCinemaData(this.cinemaData);
        this.cinemaRooms.put(cinaemaRoom.getRoomName(),cinaemaRoom);
    }

    protected CinemaRoom getCinemaRoom(String cinemaRoomName){
        return this.cinemaRooms.get(cinemaRoomName);
    }

    protected void addMovieScreenigToCalendar(MovieScreenig movieScreenigData){
        moovieCalendar.add(movieScreenigData);
    }

    private List<MovieScreenig> getMoovieCalendar(){

        List<MovieScreenig> currentCalendar = new LinkedList<>();

        // to do - sort by date
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
        System.out.println("------------------------------------------------------");
        // print movie data
        movieScreenig.movieData.printMovieData();

        // print date and hour
        movieScreenig.printDateAndHourMovieScreening();

        // print room with reservation
        movieScreenig.cinemaRoom.printCinemaRoomData();
        System.out.println("------------------------------------------------------");
    }

    protected void printMovieScreeningData(String movieTitle){
        //List<MovieScreenig> msByTitle = new LinkedList<>();
        for(MovieScreenig ms : moovieCalendar){
            if((ms.getMovieData().getMovieTitle()).equals(movieTitle)){
                printMovieScreeningData(ms);
            }
        }
    }

    protected void printMovieScreeningData(String movieTitle, String date){
        //List<MovieScreenig> msByTitle = new LinkedList<>();
        for(MovieScreenig ms : moovieCalendar){
            if((ms.getMovieData().getMovieTitle()).equals(movieTitle)){
                // to do - read
                //if(ms.getDateAndTime() > LocalDateTime.now()){
                   // printMovieScreeningData(ms);
               // }
            }
        }
    }








}
