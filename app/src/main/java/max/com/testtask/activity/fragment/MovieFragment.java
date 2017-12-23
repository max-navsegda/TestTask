package max.com.testtask.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import max.com.testtask.R;

/**
 * Created by Maxim on 12/3/2017.
 */

public class MovieFragment extends android.support.v4.app.Fragment {

    public static final String TAG = "movie";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }
}
