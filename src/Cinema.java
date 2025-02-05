import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Cinema {

    //private String cinemaName;
    private String cinemaAddress;
    //protected LocalDateTime open =  LocalDateTime.parse("2018-01-11T10:00:00");
    //protected LocalDateTime close =  LocalDateTime.parse("2018-01-11T23:30:00");
    private HashMap<String, String> cinemaData;
    private HashMap<String, CinemaRoom> cinemaRooms;


    private List<MovieScreenig> moovieCalendar;
    private List<MovieScreenig> moviesToScreening;


    Cinema(String cinemaName) {
        this.cinemaRooms = new HashMap<>();
        this.moovieCalendar = new ArrayList<>();
        this.cinemaData = new HashMap<>();
        this.cinemaData.put("cinemaName", cinemaName);
    }

    protected  HashMap<String, String> getCinemaData(){
        return this.cinemaData;
    }

    protected String getCinemaName() {
        return this.cinemaData.get("cinemaName");
    }

    protected String gerCinemaAddress() {
        return this.cinemaData.get("cinemaAddress");
    }

    protected void setCinemaAddress(String cinemaAddress) {
        this.cinemaData.put("cinemaAddress", cinemaAddress);
    }

    protected void addCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRooms.put(cinemaRoom.getRoomName(), cinemaRoom);
    }

    protected void setCinemaData(HashMap<String, String> cinemaData) {
        this.cinemaData = cinemaData;
    }

    protected CinemaRoom getCinemaRoom(String cinemaRoomName) {
        return this.cinemaRooms.get(cinemaRoomName);
    }

    protected void addMovieScreenigToCalendar(MovieScreenig movieScreenigData) {
        moovieCalendar.add(movieScreenigData);
    }

    protected List<MovieScreenig> getMovieScreenig() {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        this.moviesToScreening = new ArrayList<>();

        for (MovieScreenig ms : this.moovieCalendar) {
            int dateCurrent = ms.getDate().compareTo(dateNow);
            int dateFuture = ms.getDate().compareTo(dateNow.plusDays(7));

            if (dateCurrent >= 0 && dateFuture <= 0) {
                int timeCurrent = ms.getTime().compareTo(timeNow);
                int timeFuture = ms.getTime().compareTo(LocalTime.parse("23:59:59"));

                if (dateCurrent == 0 && (timeFuture <= 0 && timeCurrent >= 0))
                    this.moviesToScreening.add(ms);

                if (dateCurrent > 0 && (timeFuture <= 0))
                    this.moviesToScreening.add(ms);
            }
        }
        return this.moviesToScreening;
    }

    protected List<MovieScreenig> getMovieScreenig(String movieTitle) {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        this.moviesToScreening = new ArrayList<>();

        for (MovieScreenig ms : this.moovieCalendar) {
            int dateCurrent = ms.getDate().compareTo(dateNow);
            int dateFuture = ms.getDate().compareTo(dateNow.plusDays(7));

            if (dateCurrent >= 0 && dateFuture <= 0) {
                int timeCurrent = ms.getTime().compareTo(timeNow);
                int timeFuture = ms.getTime().compareTo(LocalTime.parse("23:59:59"));

                if (dateCurrent == 0 && (timeFuture <= 0 && timeCurrent >= 0)) {
                    if ((ms.getMovieData().getMovieTitle()).equals(movieTitle))
                        this.moviesToScreening.add(ms);
                }

                if (dateCurrent > 0 && (timeFuture <= 0)) {
                    if ((ms.getMovieData().getMovieTitle()).equals(movieTitle))
                        this.moviesToScreening.add(ms);
                }
            }
        }
        return this.moviesToScreening;
    }

    protected List<MovieScreenig> getMovieScreenig(String movieTitle, String movieKind) {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        this.moviesToScreening = new LinkedList<>();

        for (MovieScreenig ms : this.moovieCalendar) {
            int dateCurrent = ms.getDate().compareTo(dateNow);
            int dateFuture = ms.getDate().compareTo(dateNow.plusDays(7));

            if (dateCurrent >= 0 && dateFuture <= 0) {
                int timeCurrent = ms.getTime().compareTo(timeNow);
                int timeFuture = ms.getTime().compareTo(LocalTime.parse("23:59:59"));

                if (dateCurrent == 0 && (timeFuture <= 0 && timeCurrent >= 0)) {
                    if ((ms.getMovieData().getMovieTitle()).equals(movieTitle)) {
                        if (ms.getMovieData().getMovieKind().equals(movieKind))
                            this.moviesToScreening.add(ms);
                    }
                }

                if (dateCurrent > 0 && (timeFuture <= 0)) {
                    if ((ms.getMovieData().getMovieTitle()).equals(movieTitle)) {
                        if (ms.getMovieData().getMovieKind().equals(movieKind))
                            this.moviesToScreening.add(ms);
                    }
                }
            }
        }
        return this.moviesToScreening;
    }

    protected List<MovieScreenig> getMovieScreenig(String movieTitle, String movieDate, String movieTime) {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        this.moviesToScreening = new LinkedList<>();

        for (MovieScreenig ms : this.moovieCalendar) {
            int dateCurrent = ms.getDate().compareTo(dateNow);
            int dateFuture = ms.getDate().compareTo(dateNow.plusDays(7));

            if (dateCurrent >= 0 && dateFuture <= 0) {
                if(ms.getDate().compareTo(LocalDate.parse(movieDate)) == 0){
                    int timeCurrent = ms.getTime().compareTo(timeNow);
                    int timeFuture = ms.getTime().compareTo(LocalTime.parse("23:59:59"));

                    if (dateCurrent == 0 && (timeFuture <= 0 && timeCurrent >= 0)) {
                        if(ms.getTime().compareTo(LocalTime.parse(movieTime)) >= 0){
                            if ((ms.getMovieData().getMovieTitle()).equals(movieTitle))
                                this.moviesToScreening.add(ms);
                        }
                    }

                    if (dateCurrent > 0 && (timeFuture <= 0)) {
                        if(ms.getTime().compareTo(LocalTime.parse(movieTime)) >= 0){
                            if ((ms.getMovieData().getMovieTitle()).equals(movieTitle))
                                this.moviesToScreening.add(ms);
                        }
                    }
                }
                
            }
        }
        return this.moviesToScreening;
    }

    protected void printMovieScreeningData() {
        getMovieScreenig();
        for (MovieScreenig ms : this.moviesToScreening) {
            ms.printMovieScreeningData();
        }
    }

    protected void printMovieScreeningData(String movieTitle) {
        getMovieScreenig(movieTitle);
        for (MovieScreenig ms : this.moviesToScreening) {
            ms.printMovieScreeningData();
        }
    }

    protected void printMovieScreeningData(String movieTitle, String movieKind) {
        getMovieScreenig(movieTitle, movieKind);
        for (MovieScreenig ms : this.moviesToScreening) {
            ms.printMovieScreeningData();
        }
    }

    protected void printMovieScreeningData(String movieTitle, String movieDate, String movieTime) {
        getMovieScreenig(movieTitle, movieDate, movieTime);
        for (MovieScreenig ms : this.moviesToScreening) {
            ms.printMovieScreeningData();
        }
    }


}
