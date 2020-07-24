package team.triplog.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.domain.model.TripLogInfo;

public class TripLogInfoViewPagerAdapter extends RecyclerView.Adapter<TripLogInfoViewPagerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<TripLogInfo> tripLogInfos;

    public TripLogInfoViewPagerAdapter(Context context, ArrayList<TripLogInfo> tripLogInfos) {
        this.context = context;
        this.tripLogInfos = tripLogInfos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_trip_log_info_viewpager, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TripLogInfo tripLog = tripLogInfos.get(position);

    }

    @Override
    public int getItemCount() {
        return tripLogInfos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.view);
        }
    }

}
