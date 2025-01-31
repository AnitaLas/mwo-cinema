import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movie {

    //private HashMap<String, HashMap<String, String>> movieData;
    private HashMap<String, String> movieDetails;
   // protected String movieTitle;
    //protected String movieKind;

    Movie(){
        this.movieDetails = new HashMap<>();
    }

    protected HashMap<String, String> getMovieData(){
        return this.movieDetails;
    }

    // assumtion - first we set movie title
    protected void setMovieTitle(String movieTitle){
        //this.movieTitle = movieTitle;
        this.movieDetails.put("movieTitle", movieTitle);
        //this.movieData = new HashMap<>();
        //this.movieDetails = new HashMap<>(); // method - name
    }

    protected String getMovieTitle(){
       return this.movieDetails.get("movieTitle");
    }


    protected void setMovieKind(String movieKind){
       // this.movieKind = movieKind;
        this.movieDetails.put("movieKind", movieKind);
       //this.movieData.replace(this.movieTitle,  this.movieDetails);
    }

    protected void setMovieTime(String movieTime){
        this.movieDetails.put("movieTime", movieTime);
        //this.movieData.replace(this.movieTitle,  this.movieDetails);
    }

    protected void setMovieLanguage(String movieLanguage){
        this.movieDetails.put("movieLanguage", movieLanguage);
       // this.movieData.replace(this.movieTitle,  this.movieDetails);
    }

    protected void printMovieData(){

        System.out.println("* MOVIE *" );
        System.out.println("  "  + this.movieDetails.get("movieTitle"));
        System.out.println("  "  + this.movieDetails.get("movieKind") + ", " + this.movieDetails.get("movieLanguage"));


    }









}
