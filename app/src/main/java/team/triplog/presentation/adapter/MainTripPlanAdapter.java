package team.triplog.presentation.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import team.triplog.R;
import team.triplog.domain.model.Trip;

@SuppressLint("SimpleDateFormat")
public class MainTripPlanAdapter extends RecyclerView.Adapter<MainTripPlanAdapter.ViewHolder> {
    private ArrayList<Trip> trips;
    private OnItemClickListener onItemClickListener;
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private SimpleDateFormat monthFormat = new SimpleDateFormat("MMM", Locale.US);
    private SimpleDateFormat dayFormat = new SimpleDateFormat("d");

    public MainTripPlanAdapter(
            ArrayList<Trip> trips,
            OnItemClickListener onItemClickListener
    ) {
        this.trips = trips;
        this.onItemClickListener = onItemClickListener;
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
                        .inflate(R.layout.item_main_trip_plan, parent, false),
                onItemClickListener
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
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textStartYear;
        TextView textStartMonth;
        TextView textStartDay;
        TextView textEndYear;
        TextView textEndMonth;
        TextView textEndDay;
        TextView textTripName;
        View viewTrip;
        OnItemClickListener onItemClickListener;

        ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);

            this.onItemClickListener = onItemClickListener;
            textStartYear = view.findViewById(R.id.text_trip_start_year);
            textStartMonth = view.findViewById(R.id.text_trip_start_month);
            textStartDay = view.findViewById(R.id.text_trip_start_day);
            textEndYear = view.findViewById(R.id.text_trip_end_year);
            textEndMonth = view.findViewById(R.id.text_trip_end_month);
            textEndDay = view.findViewById(R.id.text_trip_end_day);
            textTripName = view.findViewById(R.id.text_trip_name);
            viewTrip = view.findViewById(R.id.view_trip);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}