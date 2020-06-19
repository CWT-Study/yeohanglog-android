package team.triplog.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.entity.TripLog;
import team.triplog.presentation.activity.TripLogActivity;
import team.triplog.presentation.adapter.MainTripLogAdapter;

public class MainTripLogFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerTripLog;
    private MainTripLogAdapter mainTripLogAdapter;
    private ArrayList<TripLog> tripLogs = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_trip_log, container, false);

        init();
        setUi();

        return rootView;
    }

    private void init() {
        recyclerTripLog = rootView.findViewById(R.id.recycler_trip_log);

        // TODO : Test code
        TripLog tripLog = new TripLog();
        tripLog.title = "테수트1";
        tripLog.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog2 = new TripLog();
        tripLog2.title = "테수트2";
        tripLog2.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog3 = new TripLog();
        tripLog3.title = "테수트3";
        tripLog3.drawbleId = R.drawable.ic_launcher_background;

        tripLogs.add(tripLog);
        tripLogs.add(tripLog2);
        tripLogs.add(tripLog3);
        tripLogs.add(null);

        mainTripLogAdapter = new MainTripLogAdapter(getContext(), tripLogs, onClickListener);
        recyclerTripLog.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerTripLog.setAdapter(mainTripLogAdapter);

    }

    private void setUi() {
        if (isAdded()) {
        }
    }

    private View.OnClickListener onClickListener = view -> {
        switch (view.getId()) {
            case R.id.layout_main:
                if (view.getTag() == null) {
                    Toast.makeText(getContext(), "새로운 아이템 등록", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), TripLogActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "기존 아이템", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    };
}
