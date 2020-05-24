package team.triplog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.activity.TripInfoActivity;
import team.triplog.adapter.MainTripPlanAdapter;
import team.triplog.entity.Trip;

public class MainTripPlanFragment extends Fragment {
    private View rootView;
    private Group groupNoContents;
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
        groupNoContents = rootView.findViewById(R.id.group_no_contents);
        recyclerTripPlan = rootView.findViewById(R.id.recycler_trip_plan);

        // TEST 코드
        trips.add(new Trip());
        trips.add(new Trip());
        trips.add(new Trip());
        trips.add(new Trip());
        trips.add(new Trip());

        mainTripPlanAdapter = new MainTripPlanAdapter(getContext(), trips, onClickListener);
        recyclerTripPlan.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerTripPlan.setAdapter(mainTripPlanAdapter);
    }

    private void setUi() {
        if (isAdded()) {
            if (trips.isEmpty()) {
                groupNoContents.setVisibility(View.VISIBLE);
            } else {
                groupNoContents.setVisibility(View.INVISIBLE);
            }
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.layout_item:
                    Intent intent = new Intent(getContext(), TripInfoActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
