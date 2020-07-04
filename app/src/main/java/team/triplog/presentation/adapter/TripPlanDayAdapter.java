package team.triplog.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;


public class TripPlanDayAdapter extends RecyclerView.Adapter<TripPlanDayAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> items;
    private TripPlanAdapter planAdapter;

    public TripPlanDayAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_trip_plan_day, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO : entity 필드와 연결시키기

        String item = items.get(position);
        holder.textDay.setText(item);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        planAdapter = new TripPlanAdapter(context, items);
        holder.recyclerTripPlanDay.setLayoutManager(layoutManager);
        holder.recyclerTripPlanDay.setAdapter(planAdapter);
        holder.recyclerTripPlanDay.setNestedScrollingEnabled(false);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    private void setData() {
        //더미데이터ㅎㅎ
        items.add("TEST_LOCATION1");
        items.add("TEST_LOCATION2");
        items.add("TEST_LOCATION3");
        items.add("TEST_LOCATION4");
        items.add("TEST_LOCATION5");

        planAdapter.setItems(items);
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textDay;
        RecyclerView recyclerTripPlanDay;

        ViewHolder(View view) {
            super(view);

            textDay = view.findViewById(R.id.text_day);
            recyclerTripPlanDay = view.findViewById(R.id.recycler_trip_plan_day);
        }
    }
}