package max.com.testtask.activity.comparator;

import java.util.Comparator;

import max.com.testtask.activity.model.Movie;
import max.com.testtask.activity.model.Year;

/**
 * Created by Maxim on 12/8/2017.
 */

public class SortedByDate implements Comparator<Object> {

    public int compare(Object obj1, Object obj2) {

        String str1 = "";
        String str2 = "";
        Movie movie;
        Year year;
        if (obj1 instanceof Movie) str1 = ((Movie) obj1).getYear();
        if (obj1 instanceof Year) str1 = ((Year) obj1).getYear();
        if (obj2 instanceof Movie) str2 = ((Movie) obj2).getYear();
        if (obj2 instanceof  Year) str2 = ((Year) obj2).getYear();

        return str1.compareTo(str2);
    }
}
