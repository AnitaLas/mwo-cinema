import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Company {

    private String name;
    private String address;
    private HashMap<String, Cinema> cinemas;
    private List<Movie> movies;
    private List<Movie> moviesByTitle;
    private List<Movie> moviesByKind;
    private HashMap<String, Client> clients;
    private HashMap<String, List<Reservation>> clientReservations;
    private List<Reservation> reservations;
    private HashMap<String, List<PurchaseDocument>> clientPurchaseDocuments;
    private List<PurchaseDocument> purchaseDocuments;

    Company() {
        this.cinemas = new HashMap<>();
        this.movies = new ArrayList<>();
        this.clients = new HashMap<>();
        this.clientReservations = new HashMap<>();
        this.clientPurchaseDocuments = new HashMap<>();
    }

    protected void addCinema(Cinema cinema) {
        this.cinemas.put(cinema.getCinemaName(), cinema);
    }

    protected void addMovieToCollection(Movie movie) {
        this.movies.add(movie);
    }

    protected void addClientToCollection(Client client) {
        this.clients.put(client.getClientEmail(), client);
        this.reservations = new ArrayList<>();
        this.clientReservations.put(client.getClientEmail(), reservations);
        this.purchaseDocuments = new ArrayList<>();
        this.clientPurchaseDocuments.put(client.getClientEmail(), purchaseDocuments);
    }

    protected void addReservationToCollection(Reservation reservation) {

        if (this.clientReservations.get(reservation.getClient().getClientEmail()) == null) {
            this.reservations = new ArrayList<>();
            this.clientReservations.put(reservation.getClient().getClientEmail(), reservations);
        }
        this.reservations = this.clientReservations.get(reservation.getClient().getClientEmail());
        this.reservations.add(reservation);
        this.clientReservations.put(reservation.getClient().getClientEmail(), this.reservations);
    }

    protected void addPurchaseDocumentsToCollection(PurchaseDocument purchaseDocument) {
        if (this.clientPurchaseDocuments.get(purchaseDocument.getClient().getClientEmail()) == null) {
            this.purchaseDocuments = new ArrayList<>();
            this.clientPurchaseDocuments.put(purchaseDocument.getClient().getClientEmail(), purchaseDocuments);
        }
        this.purchaseDocuments = this.clientPurchaseDocuments.get(purchaseDocument.getClient().getClientEmail());
        this.purchaseDocuments.add(purchaseDocument);
        this.clientPurchaseDocuments.put(purchaseDocument.getClient().getClientEmail(), this.purchaseDocuments);
    }

    protected List<Reservation> getAllClientReservations(Client client) {
        return this.clientReservations.get(client.getClientEmail());
    }

    protected void printAllClientReservations(Client client) {
        for (Reservation res : getAllClientReservations(client)) {
            res.printReservationDetails();
        }
    }

    protected List<PurchaseDocument> getAllClientPurchaseDocuments(Client client) {
        return this.clientPurchaseDocuments.get(client.getClientEmail());
    }

    protected void printAllClientPurchaseDocuments(Client client) {
        for (PurchaseDocument pd : getAllClientPurchaseDocuments(client)) {
            pd.printReservationDetails();
        }
    }

    protected Movie getMovieData(String movieTitle) {
        this.moviesByKind = getMovies(movieTitle);
        return this.moviesByKind.getFirst();
    }

    protected Movie getMovieData(String movieTitle, String movieKind) {
        this.moviesByKind = getMovies(movieTitle, movieKind);
        return this.moviesByKind.get(0);
    }

    protected List<Movie> getMovies(String movieTitle) {
        this.moviesByTitle = new LinkedList<>();
        for (Movie movie : this.movies) {
            if (movieTitle.equals(movie.getMovieTitle()))
                this.moviesByTitle.add(movie);
        }
        return this.moviesByTitle;
    }

    protected List<Movie> getMovies(String movieTitle, String movieKind) {
        this.moviesByKind = new LinkedList<>();
        for (Movie movie : this.movies) {
            if (movieTitle.equals(movie.getMovieTitle())) {
                if (movie.getMovieKind().equals(movieKind))
                    this.moviesByKind.add(movie);
            }
        }
        return this.moviesByKind;
    }
}
