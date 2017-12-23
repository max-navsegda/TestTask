package max.com.testtask.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import max.com.testtask.R;

/**
 * Created by Maxim on 12/10/2017.
 */

public class MovieActivity extends AppCompatActivity {

    TextView header1;
    TextView name1;
    TextView year1;
    TextView rate1;
    TextView description1;
    ImageView imageView;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie);
        header1 = (TextView) findViewById(R.id.header);
        name1 = (TextView) findViewById(R.id.name1);
        year1 = (TextView) findViewById(R.id.year1);
        rate1 = (TextView) findViewById(R.id.rate1);
        description1 = (TextView) findViewById(R.id.description1);
        imageView = (ImageView) findViewById(R.id.imageView1);

        Picasso.with(this).load("https://st.kp.yandex.net/images/film_iphone/iphone360_389.jpg").into(imageView);

        Intent bundle = getIntent();
        String header = bundle.getStringExtra(ListActivity.HEADER);
        String name = bundle.getStringExtra(ListActivity.NAME1);
        String year = bundle.getStringExtra(ListActivity.YEAR1);
        String rate = bundle.getStringExtra(ListActivity.RATE1);
        String description = bundle.getStringExtra(ListActivity.DESCRIPTION1);
        header1.setText(header);
        name1.setText(name);
        year1.setText(year);
        rate1.setText(rate);
        description1.setText(description);
        Bundle bundle1 = new Bundle();
        bundle1.clear();
    }
}
