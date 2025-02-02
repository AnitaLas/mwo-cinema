import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {

    protected String name;
    protected String address;
    private HashMap<String, Cinema> cinemas; //= new HashMap<>();
    private HashMap<String, Movie> movies; //= new HashMap<>();
    private HashMap<String, Client> clients; // = new ArrayList<>();
    private HashMap<String, List<Reservation>> clientReservations;
    private HashMap<String, List<PurchaseDocument>> clientPurchaseDocuments;
    private List<Reservation> reservations;

    Company(){
        this.cinemas = new HashMap<>();
        this.movies = new HashMap<>();
        this.clients = new HashMap<>();
        this.clientReservations = new HashMap<>();
    }

    protected void addCinema(Cinema cinema){
        this.cinemas.put(cinema.getCinemaName(), cinema);
    }

    protected void addMovieToCollection(Movie movie){
        this.movies.put(movie.getMovieTitle(), movie);
    }

    protected Movie getMovieData(String movieTitle){
        return this.movies.get(movieTitle);
    }

    protected void addClientToCollection(Client client){
        this.clients.put(client.getClientEmail(), client);
        this.reservations = new ArrayList<>();
        this.clientReservations.put(client.getClientEmail(), reservations);
    }

   protected void addReservationToCollection(Reservation reservation){
       this.reservations =  this.clientReservations.get(reservation.getClient().getClientEmail());
       this.reservations.add(reservation);
       this.clientReservations.put(reservation.getClient().getClientEmail(), this.reservations);
    }


    protected void printAllClientReservations(Client client){
        List<Reservation> reservations = this.clientReservations.get(client.getClientEmail());
        for(Reservation res : reservations){
            res.printDocumentDetails();
        }

    }





}
