package team.triplog.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.domain.entity.TripLogInfo;

public class TripLogInfoNumAdapter extends RecyclerView.Adapter<TripLogInfoNumAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TripLogInfo> tripLogs;

    public TripLogInfoNumAdapter(Context context, ArrayList<TripLogInfo> tripLogs) {
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
                        .inflate(R.layout.item_trip_log_info_num, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TripLogInfo tripLog = tripLogs.get(position);
        if (position == 0) {
            holder.viewFirst.setVisibility(View.GONE);
        }

        if (position == tripLogs.size() - 1) {
            holder.viewLast.setVisibility(View.GONE);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View viewFirst;
        View viewLast;
        TextView tripLogInfoNum;

        ViewHolder(View view) {
            super(view);
            viewFirst = view.findViewById(R.id.view_first);
            viewLast = view.findViewById(R.id.view_last);
            tripLogInfoNum = view.findViewById(R.id.trip_log_info_num);

        }
    }
}