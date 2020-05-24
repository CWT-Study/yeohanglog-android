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

        holder.imageView.setBackground(new ShapeDrawable(new OvalShape()));
        holder.imageView.setClipToOutline(true);

        if (position == 0) {
            holder.imageView.setImageResource(R.drawable.button_plus);
            return;
        }

        holder.textView.setText(tripLog.title);
        holder.imageView.setImageResource(tripLog.drawbleId);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        AppCompatImageView imageView;

        ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.text);
            imageView = view.findViewById(R.id.imageview);
        }
    }
}