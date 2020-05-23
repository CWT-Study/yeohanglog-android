package team.triplog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.adapter.MainTripPlanAdapter;
import team.triplog.entity.Trip;

public class MainTripPlanFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerTripPlan;
    private MainTripPlanAdapter mainTripPlanAdapter;
    private ArrayList<Trip> trips = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_trip_plan, container, false);

        init();
        setUi();

        return rootView;
    }

    private void init() {
        recyclerTripPlan = rootView.findViewById(R.id.recycler_trip_plan);

        mainTripPlanAdapter = new MainTripPlanAdapter(getContext(), trips);
        recyclerTripPlan.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerTripPlan.setAdapter(mainTripPlanAdapter);
    }

    private void setUi() {
        if (isAdded()) {
        }
    }
}
