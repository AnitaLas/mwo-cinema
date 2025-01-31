import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Company headquarter = new Company();

        Movie film1 = new Movie();
        film1.setMovieTitle("Moana");
        film1.setMovieTime("String4 44");
        film1.setMovieKind("Comedy3");
        film1.setMovieLanguage("ENG");

        Movie film2 = new Movie();
        film2.setMovieTitle("Bolek i Lolek");
        film2.setMovieTime("20");
        film2.setMovieKind("Comedy");
        film2.setMovieLanguage("PL");

        headquarter.addMovieToCollection(film1);
        headquarter.addMovieToCollection(film2);

        Cinema cinema1 = new Cinema();
        cinema1.setCinemaName("Kino Kraków");
        cinema1.setCinemaAddress("ul. nieIstnieje, 30-666 Kraków");

        CinemaRoom cinemaRoom1 = new CinemaRoom();
        cinemaRoom1.setRoomName("room 1");
        cinemaRoom1.createSeatsForOneRow(1,1);
        cinemaRoom1.createSeatsForOneRow(2,2);
        cinemaRoom1.createSeatsForOneRow(3,3, "VIP");
        cinemaRoom1.createSeatsForOneRow(4,4);
        cinemaRoom1.createSeatsForOneRow(5,5);
        cinema1.addCinemaRoom(cinemaRoom1);

        CinemaRoom cinemaRoom2 = new CinemaRoom();
        cinemaRoom2.setRoomName("room 2");
        cinemaRoom2.createSeatsForOneRow(1,4);
        cinemaRoom2.createSeatsForOneRow(2,4);
        cinemaRoom2.createSeatsForOneRow(3,2, "VIP");
        cinemaRoom2.createSeatsForOneRow(4,4);
        cinemaRoom2.createSeatsForOneRow(5,2);
        cinema1.addCinemaRoom(cinemaRoom2);


        MovieScreenig ms1 = new MovieScreenig(headquarter.getMovieData("Bolek i Lolek"),
                "2018-01-29T10:00:00", cinema1.getCinemaRoom("room 1"));

        MovieScreenig ms2 = new MovieScreenig(headquarter.getMovieData("Moana"),
                "2018-01-30T12:00:00", cinema1.getCinemaRoom("room 2"));

        MovieScreenig ms3 = new MovieScreenig(headquarter.getMovieData("Bolek i Lolek"),
                "2018-01-31T14:00:00", cinema1.getCinemaRoom("room 1"));


        cinema1.addMovieScreenigToCalendar(ms1);
        cinema1.addMovieScreenigToCalendar(ms2);
        //cinema1.addMovieScreenigToCalendar(ms3);

        //cinema1.printMovieScreeningData(ms1);
        //cinema1.printMovieScreeningData(ms2);

        Reservation res1 = new Reservation();
        res1.chosseMovieScreening(ms1);
        res1.bookSeatsPerRow("2", "2");
        cinema1.printMovieScreeningData(ms1);

        /*res1.chosseMovieScreening(ms2);
        res1.bookSeatsPerRow("3", "2");
        cinema1.printMovieScreeningData(ms2);*/




        //-------

        HashMap<String, Object> finalData = new HashMap<>();

        HashMap<String, Object> sd1 = new HashMap<>();
        sd1.put("isSeatReserved", false);
        sd1.put("seatType", "hmm");
        finalData.put("1", sd1);

        HashMap<String, Object> sd2 = new HashMap<>();
        sd2.put("isSeatReserved", false);
        sd2.put("seatType", "hmm");
        finalData.put("2", sd2);


        for(String key1 : finalData.keySet()){

            //System.out.println("main key " + key1 + " : ");

            HashMap<String, Object > temp = (HashMap<String, Object>) finalData.get(key1);

            for(String key2 : temp.keySet()){

                //System.out.println("> key : " + key2 + " = " + temp.get(key2));

                if(key1.equals("2")){
                    temp.replace("seatType", "yyyy");
                }


            }
            //System.out.println();
        }

        //System.out.println(sd1);
        //System.out.println(sd2);


        /*LocalDateTime dt1 =  LocalDateTime.parse("2018-01-11T10:15:30");
        System.out.println("Loc: " + dt1.plusMinutes(15));
        System.out.println(">2: " + dt1.toLocalDate());
        System.out.println(">3: " + dt1.toLocalTime());
        System.out.println(">4: " + cinema1.open.toLocalTime());
        System.out.println(">5: " + cinema1.close.toLocalTime());*/












    }
}