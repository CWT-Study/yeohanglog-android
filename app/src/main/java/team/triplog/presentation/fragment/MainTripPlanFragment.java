package team.triplog.presentation.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.Group;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

import team.triplog.R;
import team.triplog.presentation.activity.TripPlanActivity;
import team.triplog.presentation.adapter.MainTripPlanAdapter;
import team.triplog.domain.entity.Trip;

@SuppressLint("SimpleDateFormat")
public class MainTripPlanFragment extends Fragment implements MainTripPlanAdapter.OnItemClickListener {
    private SimpleDateFormat periodFormat = new SimpleDateFormat("yyyy.MM.dd");
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

        // TODO : Test code
        trips.add(new Trip());
        trips.add(new Trip());
        trips.add(new Trip());

        mainTripPlanAdapter = new MainTripPlanAdapter(trips, this);
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

    @Override
    public void onItemClick(View view, int position) {
        Trip trip = trips.get(position);

        Intent intent = new Intent(getContext(), TripPlanActivity.class);

        // TODO : 임시로 String 형식으로 넘김.
        intent.putExtra("EXTRA_TRIP_NAME", trip.name);
        intent.putExtra("EXTRA_TRIP_PERIOD", String.format(
                "%s - %s",
                periodFormat.format(trip.startDate),
                periodFormat.format(trip.startDate)
        ));

        View layoutTrip = view.findViewById(R.id.layout_item);

        Pair<View, String> pairItem = Pair.create(layoutTrip, layoutTrip.getTransitionName());

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                Objects.requireNonNull(getActivity()),
                pairItem
        );

        startActivity(intent, optionsCompat.toBundle());
    }
}
