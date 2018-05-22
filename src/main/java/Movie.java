public class Movie {
    private String name;
    private String year;
    private String director;
    private Integer rating;
    private boolean isCheckedOut;

    public Movie(String name, String year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.isCheckedOut = false;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
}
