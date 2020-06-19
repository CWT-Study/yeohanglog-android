package team.triplog.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.entity.TripLog;

public class MainTripLogAdapter extends RecyclerView.Adapter<MainTripLogAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TripLog> tripLogs;
    private View.OnClickListener onClickListener;

    public MainTripLogAdapter(Context context, ArrayList<TripLog> tripLogs, View.OnClickListener onClickListener) {
        this.context = context;
        this.tripLogs = tripLogs;
        this.onClickListener = onClickListener;
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
                        .from(parent.getContext())
                        .inflate(R.layout.item_main_trip_log, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TripLog tripLog = tripLogs.get(position);
        boolean isAdd = (position == getItemCount() - 1);
        if (isAdd) {
            holder.viewGroupImage.setBackgroundResource(R.drawable.button_plus);
            holder.textGroupName.setVisibility(View.INVISIBLE);
        } else {
            holder.textGroupName.setText(tripLog.title);
//            holder.viewGroupImage.setClipToOutline(true);
//            holder.viewGroupImage.setBackgroundResource(tripLog.drawbleId);
        }

        holder.layoutMain.setTag(tripLog);
        holder.layoutMain.setOnClickListener(onClickListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textGroupName;
        View viewGroupImage;
        ConstraintLayout layoutMain;

        ViewHolder(View view) {
            super(view);

            textGroupName = view.findViewById(R.id.text_group_name);
            viewGroupImage = view.findViewById(R.id.view_group_image);
            layoutMain = view.findViewById(R.id.layout_main);
        }
    }
}