package team.triplog.adapter;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.entity.TripLog;

public class TripLogAdapter extends RecyclerView.Adapter<TripLogAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TripLog> tripLogs;

    public TripLogAdapter(Context context, ArrayList<TripLog> tripLogs) {
        this.tripLogs = tripLogs;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return tripLogs.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_trip_log, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TripLog tripLog = tripLogs.get(position);

        if (position == 0) {
            holder.view_trip_log_image.setBackgroundResource(R.drawable.button_plus);
            holder.view_trip_log_delee.setVisibility(View.GONE);
            return;
        }

        holder.textView.setText(tripLog.title);
        holder.view_trip_log_image.setBackgroundResource(tripLog.drawbleId);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View view_trip_log_image;
        View view_trip_log_delee;

        ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.text);
            view_trip_log_image = view.findViewById(R.id.view_trip_log_image);
            view_trip_log_delee = view.findViewById(R.id.view_trip_log_delee);
        }
    }
}