package max.com.testtask.activity.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import max.com.testtask.R;
import max.com.testtask.activity.ListActivity;
import max.com.testtask.activity.MovieActivity;
import max.com.testtask.activity.holder.SimpleHolder;
import max.com.testtask.activity.model.Movie;
import max.com.testtask.activity.model.Year;

/**
 * Created by Maxim on 12/5/2017.
 */

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private List<java.lang.Object> list;
    String header = "";
    String name = "";
    String year = "";
    String rate = "";
    String description = "";

    private final int MOVIE = 0, YEAR = 1;

    public RecyclerAdapter1(Context context, ArrayList<Object> list) {
        this.context = context;
        this.list = list;
    }

    private void configureDefaultViewHolder(SimpleHolder vh, int position) {
        vh.getLabel().setText((CharSequence) list.get(position));
    }

    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        Movie movie = (Movie) list.get(position);
        if (movie != null) {
            vh1.getName().setText(movie.getName());
            vh1.getRate().setText("9,999");
            vh1.getLocalizedName().setText(movie.getLocalized_name());
        }
    }

    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        Year year = (Year) list.get(position);
        if (year != null) {
            vh2.getLabel2().setText(year.getYear());
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case MOVIE:
                View v1 = inflater.inflate(R.layout.fragment_item, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case YEAR:
                View v2 = inflater.inflate(R.layout.fragment_year, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                viewHolder = new SimpleHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()) {
            case MOVIE:
                ViewHolder1 vh1 = (ViewHolder1) holder;
                if (list.get(position) instanceof Movie){
                    header = ((Movie) list.get(position)).getLocalized_name();
                    name = ((Movie) list.get(position)).getName();
                    year = ((Movie) list.get(position)).getYear();
                    rate = ((Movie) list.get(position)).getRating();
                    description = ((Movie) list.get(position)).getDescription();
                }

                vh1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, header, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, MovieActivity.class);
                        intent.putExtra(ListActivity.HEADER, header);
                        intent.putExtra(ListActivity.NAME1, name);
                        intent.putExtra(ListActivity.YEAR1, year);
                        intent.putExtra(ListActivity.RATE1, rate);
                        intent.putExtra(ListActivity.DESCRIPTION1, description);
                        context.startActivity(intent);
                    }
                });
                configureViewHolder1(vh1, position);
                break;
            case YEAR:
                ViewHolder2 vh2 = (ViewHolder2) holder;
                configureViewHolder2(vh2, position);
                break;
            default:
                SimpleHolder vh = (SimpleHolder) holder;
                configureDefaultViewHolder(vh, position);
                break;
        }
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView rate;
        private TextView localizedName;

        public ViewHolder1(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            rate = (TextView) v.findViewById(R.id.rate);
            localizedName = (TextView) v.findViewById(R.id.localized_name);
        }

        public TextView getLocalizedName() {
            return localizedName;
        }

        public void setLocalizedName(TextView localizedName) {
            this.localizedName = localizedName;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getRate() {
            return rate;
        }

        public void setRate(TextView rate) {
            this.rate = rate;
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private TextView label2;

        public ViewHolder2(View v) {
            super(v);
            label2 = (TextView) v.findViewById(R.id.year2);
        }

        public TextView getLabel2() {
            return label2;
        }

        public void setLabel2(TextView label2) {
            this.label2 = label2;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof Movie) {
            return MOVIE;
        } else if (list.get(position) instanceof Year) {
            return YEAR;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
