import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {

    protected String name;
    protected String address;
    private HashMap<String, Movie> movies = new HashMap<>();
    private List<Client> clients;


    protected void addMovieToCollection(Movie movie){
        this.movies.put(movie.getMovieTitle(), movie);
    }

    protected Movie getMovieData(String movieTitle){
        return this.movies.get(movieTitle);
    }


}
