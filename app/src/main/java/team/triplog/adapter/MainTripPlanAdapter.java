package team.triplog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import team.triplog.R;
import team.triplog.entity.Trip;

@SuppressLint("SimpleDateFormat")
public class MainTripPlanAdapter extends RecyclerView.Adapter<MainTripPlanAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Trip> trips;
    private View.OnClickListener onClickListener;
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private SimpleDateFormat monthFormat = new SimpleDateFormat("MMM", Locale.US);
    private SimpleDateFormat dayFormat = new SimpleDateFormat("d");

    public MainTripPlanAdapter(
            Context context,
            ArrayList<Trip> trips,
            View.OnClickListener onClickListener
    ) {
        this.context = context;
        this.trips = trips;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_main_trip_plan, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trip trip = trips.get(position);

        holder.textStartYear.setText(yearFormat.format(trip.startDate));
        holder.textStartMonth.setText(monthFormat.format(trip.startDate).toUpperCase());
        holder.textStartDay.setText(dayFormat.format(trip.startDate));

        holder.textEndYear.setText(yearFormat.format(trip.endDate));
        holder.textEndMonth.setText(monthFormat.format(trip.endDate).toUpperCase());
        holder.textEndDay.setText(dayFormat.format(trip.endDate));

        holder.textTripName.setText(trip.name);
//        holder.viewTrip.setBackgroundResource(trip.image);

        holder.layoutItem.setTag(trip);
        holder.layoutItem.setOnClickListener(onClickListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout layoutItem;
        TextView textStartYear;
        TextView textStartMonth;
        TextView textStartDay;
        TextView textEndYear;
        TextView textEndMonth;
        TextView textEndDay;
        TextView textTripName;
        View viewTrip;

        ViewHolder(View view) {
            super(view);

            layoutItem = view.findViewById(R.id.layout_item);
            textStartYear = view.findViewById(R.id.text_trip_start_year);
            textStartMonth = view.findViewById(R.id.text_trip_start_month);
            textStartDay = view.findViewById(R.id.text_trip_start_day);
            textEndYear = view.findViewById(R.id.text_trip_end_year);
            textEndMonth = view.findViewById(R.id.text_trip_end_month);
            textEndDay = view.findViewById(R.id.text_trip_end_day);
            textTripName = view.findViewById(R.id.text_trip_name);
            viewTrip = view.findViewById(R.id.view_trip);
        }
    }
}