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

public class TripPlanAdapter extends RecyclerView.Adapter<TripPlanAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> plans;

    public TripPlanAdapter(Context context, ArrayList<String> plans) {
        this.context = context;
        this.plans = plans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_trip_plan, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO : entity 필드와 연결시키기

        String item = plans.get(position);
        holder.textLocation.setText(item);
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public void setItems(ArrayList<String> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View viewTop, viewBottom;
        TextView textLocation, textAddress;

        ViewHolder(View view) {
            super(view);

            textLocation = view.findViewById(R.id.text_location);
            textAddress = view.findViewById(R.id.text_address);
            viewTop = view.findViewById(R.id.view_top);
            viewBottom = view.findViewById(R.id.view_bottom);
        }
    }
}
