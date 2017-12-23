package max.com.testtask.activity.model;

import android.support.annotation.NonNull;

/**
 * Created by Maxim on 12/5/2017.
 */

public class Movie implements Comparable<Object> {

    private String localized_name;
    private String name;
    private String year;
    private String rating;
    private String image_url;
    private String description;

    public Movie() {
    }

    public Movie(String year) {
        this.year = year;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie(String localized_name, String name, String year, String rating, String image_url, String description) {

        this.localized_name = localized_name;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.image_url = image_url;
        this.description = description;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Movie movie1 = (Movie) o;
        return  movie1.getYear().compareTo(((Movie) o).getYear());
    }
}
