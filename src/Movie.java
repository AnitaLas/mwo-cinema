import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movie {

    private HashMap<String, String> movieDetails;

    Movie(){
        this.movieDetails = new HashMap<>();
    }

    protected HashMap<String, String> getMovieData(){
        return this.movieDetails;
    }

    // to do - String movieTitle -> Movie(){}
    // assumtion - first we set movie title
    protected void setMovieTitle(String movieTitle){
        this.movieDetails.put("movieTitle", movieTitle);
    }

    protected String getMovieTitle(){
       return this.movieDetails.get("movieTitle");
    }

    protected void setMovieKind(String movieKind){
        this.movieDetails.put("movieKind", movieKind);
    }

    protected void setmovieGenre(String movieGenre){
        this.movieDetails.put("movieGenre", movieGenre);;
    }

    protected void setMovieTime(String movieTime){
        this.movieDetails.put("movieTime", movieTime);
    }

    protected void setMovieLanguage(String movieLanguage){
        this.movieDetails.put("movieLanguage", movieLanguage);
    }

    protected void printMovieData(){

        System.out.println("* MOVIE *" );
        System.out.println("  "  + this.movieDetails.get("movieTitle"));
        System.out.println("  "  + this.movieDetails.get("movieKind") + ", "
                + this.movieDetails.get("movieLanguage"));
    }


}
