package max.com.testtask.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Maxim on 12/8/2017.
 */

public class MyModel {
    @SerializedName("list")
    public ArrayList<MyObject> list;

    static public class MyObject {

        @SerializedName("localized_name")
        private String localized_name;
        @SerializedName("name")
        private String name;
        @SerializedName("year")
        private String year;
        @SerializedName("date")
        private String rating;
        @SerializedName("image_url")
        private String image_url;
        @SerializedName("description")
        private String description;

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
    }
}
