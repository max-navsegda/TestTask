package max.com.testtask.activity.model;

import android.support.annotation.NonNull;

/**
 * Created by Maxim on 12/6/2017.
 */

public class Year implements Comparable<Object>{
    private String year;

    public Year() {
    }

    public Year(String year) {

        this.year = year;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Year year = (Year)o;
        return year.getYear().compareTo(((Year) o).getYear());
    }
}
