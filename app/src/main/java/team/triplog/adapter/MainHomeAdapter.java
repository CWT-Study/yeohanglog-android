package team.triplog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.entity.TripLog;

public class MainHomeAdapter extends RecyclerView.Adapter<MainHomeAdapter.ViewHolder> {
    private ArrayList<TripLog> tripList;
    private Context context;
    private View.OnClickListener onClickListener;

    public MainHomeAdapter(
            Context mContext,
            ArrayList<TripLog> tripList,
            View.OnClickListener onClickListener
    ) {
        this.context = mContext;
        this.tripList = tripList;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_main_home_trip, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TripLog tripLog = tripList.get(position);

        holder.textTripTitle.setText(tripLog.title);
        holder.textTripTitle.setTag(tripLog.title);
        holder.textTripTitle.setOnClickListener(onClickListener);
        holder.viewTrip.setImageResource(tripLog.drawbleId);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTripTitle;
        ImageView viewTrip;

        ViewHolder(View view) {
            super(view);
            textTripTitle = view.findViewById(R.id.text_trip_title);
            viewTrip = view.findViewById(R.id.view_trip);
        }
    }
}
