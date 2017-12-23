package max.com.testtask.activity.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import max.com.testtask.R;

/**
 * Created by Maxim on 12/6/2017.
 */

public class SimpleHolder extends RecyclerView.ViewHolder {

    private TextView label1;


    public SimpleHolder(View v) {
        super(v);
        label1 = (TextView) v.findViewById(R.id.year);
    }

    public TextView getLabel() {
        return label1;
    }

    public void setLabel1(TextView label1) {
        this.label1 = label1;
    }


}
