import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Company headquarter = new Company();

        Movie film1 = new Movie();
        film1.setMovieTitle("Moana");
        film1.setMovieTime("128");
        film1.setMovieGenre("Comedy");
        film1.setMovieKind("2D");
        film1.setMovieLanguage("ENG");

        Movie film13D = new Movie();
        film13D.setMovieTitle("Moana");
        film13D.setMovieTime("128");
        film13D.setMovieGenre("Comedy");
        film13D.setMovieKind("3D");
        film13D.setMovieLanguage("ENG");

        Movie film2 = new Movie();
        film2.setMovieTitle("Bolek i Lolek");
        film2.setMovieTime("20");
        film2.setMovieGenre("Comedy");
        film2.setMovieKind("3D");
        film2.setMovieLanguage("PL");

        headquarter.addMovieToCollection(film1);
        headquarter.addMovieToCollection(film13D);
        headquarter.addMovieToCollection(film2);

        Cinema cinema1 = new Cinema();
        cinema1.setCinemaName("Kino Kraków");
        cinema1.setCinemaAddress("ul. nieIstnieje, 30-666 Kraków");

        headquarter.addCinema(cinema1);

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
                "2025-02-10","14:15:00", cinema1.getCinemaRoom("room 1"));

        MovieScreenig ms2 = new MovieScreenig(headquarter.getMovieData("Moana"),
                "2025-02-04", "09:00:00", cinema1.getCinemaRoom("room 1"));

       MovieScreenig ms3 = new MovieScreenig(headquarter.getMovieData("Bolek i Lolek"),
                "2025-02-10","14:00:00", cinema1.getCinemaRoom("room 1"));

        MovieScreenig ms4 = new MovieScreenig(headquarter.getMovieData("Moana", "2D"),
                "2025-02-04", "10:20:00", cinema1.getCinemaRoom("room 2"));

        MovieScreenig ms5 = new MovieScreenig(headquarter.getMovieData("Moana", "3D"),
                "2025-02-10", "21:10:00", cinema1.getCinemaRoom("room 2"));

        cinema1.addMovieScreenigToCalendar(ms1);
        cinema1.addMovieScreenigToCalendar(ms2);
        cinema1.addMovieScreenigToCalendar(ms3);
        cinema1.addMovieScreenigToCalendar(ms4);
        cinema1.addMovieScreenigToCalendar(ms5);


        //cinema1.printMovieScreeningData();
        //cinema1.printMovieScreeningData("Bolek i Lolek");
        //cinema1.printMovieScreeningData("Moana", "2D");
        //cinema1.printMovieScreeningData("Moana", "3D");
        //cinema1.printMovieScreeningData("Moana");
        //cinema1.printMovieScreeningData("Moana", "2025-02-04", "09:30:00");



        Client c1 = new Client();
        c1.setClientEmail("bolek1@gmail.com");
        c1.setClientName("Bolek II");
        headquarter.addClientToCollection(c1);

        Client c2 = new Client();
        c2.setClientEmail("lolek2@gmail.com");
        c2.setClientName("Lolek III");
        headquarter.addClientToCollection(c2);

        Reservation res1 = new Reservation(ms1);
        res1.chooseSeatsPerRow("2", "1,");
        res1.chooseSeatsPerRow("4", "2, 3");
        //res1.setClient("gosc@gmail.com");
        res1.setClient(c1);
        res1.confirmReservation();
        headquarter.addReservationToCollection(res1);
        //res1.printReservationDetails();

        Reservation res2 = new Reservation(ms1);
        res2.chooseSeatsPerRow("5", "1");
        res2.setClient("gosc@gmail.com");
        res2.confirmReservation();
        headquarter.addReservationToCollection(res2);
        //res2.printReservationDetails();

        Reservation res3 = new Reservation(ms2);
        res3.chooseSeatsPerRow("2", "2,");
        res3.chooseSeatsPerRow("5", "4,5");
        res3.setClient(c1);
        res3.confirmReservation();
        headquarter.addReservationToCollection(res3);
        //res3.printReservationDetails();

        //headquarter.printAllClientReservations(c1);

        PurchaseDocument pd1 = new PurchaseDocument(res1);
        pd1.payForReservation(true, true);
        headquarter.addPurchaseDocumentsToCollection(pd1);

        PurchaseDocument pd2 = new PurchaseDocument(res3);
        pd2.payForReservation(true, true);
        headquarter.addPurchaseDocumentsToCollection(pd2);

        //pd1.cancelReservation();

        //headquarter.printAllClientReservations(c1);
        headquarter.printAllClientPurchaseDocuments(c1);






        //-------
        // to do - remove - test






    }
}