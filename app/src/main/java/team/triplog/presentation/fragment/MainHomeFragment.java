package team.triplog.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.data.local.User;
import team.triplog.domain.model.Trip;
import team.triplog.domain.model.TripLog;
import team.triplog.presentation.activity.TripInfoActivity;
import team.triplog.presentation.activity.TripPlanActivity;
import team.triplog.presentation.adapter.MainHomeAdapter;

public class MainHomeFragment extends Fragment {
    private View rootView;
    private Group groupNoContents;
    private TextView textUserName;
    private TextView textNewTrip;
    private TextView textTripTitle;
    private TextView textTripContent;
    private TextView textTripDate;
    private RecyclerView recyclerLookBack;
    private ConstraintLayout layoutTrip;
    private ConstraintLayout layoutTripInfo;
    private MainHomeAdapter homeAdapter;
    private ArrayList<TripLog> tripLookBacks = new ArrayList<>();
    private User user;
    private Trip currentTrip;

    public MainHomeFragment(User user) {
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_home, container, false);

        init();
        setData();
        setUi();

        return rootView;
    }

    private void init() {
        groupNoContents = rootView.findViewById(R.id.group_no_contents);
        textUserName = rootView.findViewById(R.id.text_user_name);
        textNewTrip = rootView.findViewById(R.id.text_new_trip);
        textTripTitle = rootView.findViewById(R.id.text_trip_title);
        textTripContent = rootView.findViewById(R.id.txt_trip_content);
        textTripDate = rootView.findViewById(R.id.txt_trip_date);
        recyclerLookBack = rootView.findViewById(R.id.recycler_look_back);
        layoutTrip = rootView.findViewById(R.id.layout_trip);
        layoutTripInfo = rootView.findViewById(R.id.layout_trip_info);

        layoutTrip.setOnClickListener(onClickListener);
    }

    private void setData() {

//        tripLookBacks.add(tripLog);
//        tripLookBacks.add(tripLog2);
//        tripLookBacks.add(tripLog3);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        homeAdapter = new MainHomeAdapter(getContext(), tripLookBacks, onClickListener);
        recyclerLookBack.setLayoutManager(layoutManager);
        recyclerLookBack.setAdapter(homeAdapter);
        recyclerLookBack.setNestedScrollingEnabled(false);
    }

    private void setUi() {
        textUserName.setText(user.getName());

        if (tripLookBacks.isEmpty()) {
            groupNoContents.setVisibility(View.VISIBLE);
        } else {
            groupNoContents.setVisibility(View.INVISIBLE);
        }

        if (currentTrip == null) {
            textNewTrip.setVisibility(View.VISIBLE);
            layoutTripInfo.setVisibility(View.INVISIBLE);
        } else {
            textNewTrip.setVisibility(View.INVISIBLE);
            layoutTripInfo.setVisibility(View.VISIBLE);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.layout_trip: {
                    Intent intent = new Intent(getContext(), (currentTrip == null) ? TripInfoActivity.class : TripPlanActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.layout_item: {
                    TripLog trip = (TripLog) view.getTag();
                    Toast.makeText(rootView.getContext(), trip.getTitle() + " 화면으로 이동", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    };
}
