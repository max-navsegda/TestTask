package max.com.testtask.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

import max.com.testtask.R;
import max.com.testtask.activity.adapters.RecyclerAdapter1;
import max.com.testtask.activity.comparator.SortedByDate;
import max.com.testtask.activity.helper.JsonHelper;
import max.com.testtask.activity.model.Movie;
import max.com.testtask.activity.model.MyModel;
import max.com.testtask.activity.model.Year;

/**
 * Created by Maxim on 12/2/2017.
 */

public class ListActivity extends FragmentActivity {
    public static ArrayList<Object> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter1 recyclerAdapter;
    public static final String HEADER = "HEADER";
    public static final String NAME1 = "NAME1";
    public static final String YEAR1 = "YEAR1";
    public static final String RATE1 = "RATE1";
    public static final String DESCRIPTION1 = "DESCRIPTION1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.rv);
        recyclerAdapter = new RecyclerAdapter1(this, list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
        String myJson = JsonHelper.inputStreamToString(getResources().openRawResource(R.raw.movies));
        MyModel myModel = new Gson().fromJson(myJson, MyModel.class);

        String s = "";
        for (MyModel.MyObject o : myModel.list) {
            Year year = new Year(o.getYear());
            Movie movie = new Movie();
            movie.setLocalized_name(o.getLocalized_name());
            movie.setName(o.getName());
            movie.setYear(o.getYear());
            movie.setRating(o.getRating());
            movie.setImage_url(o.getImage_url());
            movie.setDescription(o.getDescription());
            if (!s.equals(year.getYear())) {
                s = year.getYear();
                list.add(year);
            }
            list.add(movie);
        }

        Collections.sort(list, new SortedByDate());
    }

    public void onCLick(View view) {
        list.add(new Year("1999"));
        list.add(new Movie("Birds"));
        recyclerAdapter.notifyDataSetChanged();
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(HEADER, "Bird");
        intent.putExtra(NAME1, "Bird");
        intent.putExtra(YEAR1, "1999");
        intent.putExtra(RATE1, "9999");
        intent.putExtra(DESCRIPTION1, "Профессиональный убийца Леон, не знающий пощады и жалости, знакомится со своей очаровательной соседкой Матильдой, семью которой расстреливают полицейские, замешанные в торговле наркотика");
        startActivity(intent);
    }
}
