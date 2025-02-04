import java.util.HashMap;

public class Movie {

    private HashMap<String, String> movieDetails;

    Movie(String movieTitle) {
        this.movieDetails = new HashMap<>();
        this.movieDetails.put("movieTitle", movieTitle);
    }

    protected HashMap<String, String> getMovieData() {
        return this.movieDetails;
    }

    protected String getMovieTitle() {
        return this.movieDetails.get("movieTitle");
    }

    protected void setMovieKind(String movieKind) {
        this.movieDetails.put("movieKind", movieKind);
    }

    protected String getMovieKind() {
        return this.movieDetails.get("movieKind");
    }

    protected void setMovieGenre(String movieGenre) {
        this.movieDetails.put("movieGenre", movieGenre);
    }

    protected String getMovieGenre() {
        return this.movieDetails.get("movieGenre");
    }

    protected void setMovieTime(String movieTime) {
        this.movieDetails.put("movieTime", movieTime);
    }

    protected void setMovieLanguage(String movieLanguage) {
        this.movieDetails.put("movieLanguage", movieLanguage);
    }

    protected void printMovieData() {
        System.out.println("* MOVIE *");
        System.out.println("  " + this.movieDetails.get("movieTitle"));
        System.out.println("  " + this.movieDetails.get("movieKind") + ", "
                + this.movieDetails.get("movieLanguage"));
    }
}
