package team.triplog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import team.triplog.adapter.MainTripLogAdpater;
import team.triplog.entity.TripLog;

public class MainTripLogFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private Context context;
    private MainTripLogAdpater mainTripLogAdpater;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<TripLog> tripLogs = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main_trip_log, container, false);

        init();
        setUi();

        return rootView;
    }

    private void init() {
        recyclerView = rootView.findViewById(R.id.recyclerView);
        context = rootView.getContext();
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);


        TripLog tripLog = new TripLog();
        tripLog.title = "테수트1";
        tripLog.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog2 = new TripLog();
        tripLog2.title = "테수트2";
        tripLog2.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog3 = new TripLog();
        tripLog3.title = "테수트3";
        tripLog3.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog4 = new TripLog();//TODO Last Item무조건 하나 집어넣는다
        tripLog4.title ="LastItem";

        tripLogs.add(tripLog);
        tripLogs.add(tripLog2);
        tripLogs.add(tripLog3);
        tripLogs.add(tripLog4);


        mainTripLogAdpater = new MainTripLogAdpater(context,tripLogs);

        recyclerView.setAdapter(mainTripLogAdpater);

    }

    private void setUi() {
        if (isAdded()) {
        }
    }
}
