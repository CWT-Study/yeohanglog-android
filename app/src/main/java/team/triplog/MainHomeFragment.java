package team.triplog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.adapter.MainHomeAdapter;
import team.triplog.entity.TripLog;

public class MainHomeFragment extends Fragment {
    private View rootView;
    private TextView textNameUser;
    private TextView textTripTitle;
    private TextView textTripContent;
    private TextView textTripDate;
    private RecyclerView recyclerLookBack;
    private MainHomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_home, container, false);

        init();
        setData();

        return rootView;
    }

    private void init() {
        textNameUser = rootView.findViewById(R.id.text_user_name);
        textTripTitle = rootView.findViewById(R.id.text_trip_title);
        textTripContent = rootView.findViewById(R.id.txt_trip_content);
        textTripDate = rootView.findViewById(R.id.txt_trip_date);
        recyclerLookBack = rootView.findViewById(R.id.recycler_look_back);
    }

    private void setData() {
        ArrayList<TripLog> tripLogs = new ArrayList<>();
        TripLog tripLog = new TripLog();
        tripLog.title = "테스트";
        tripLog.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog2 = new TripLog();
        tripLog2.title = "테스트2";
        tripLog2.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog3 = new TripLog();
        tripLog3.title = "테스트3";
        tripLog3.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog4 = new TripLog();
        tripLog4.title = "테스트4";
        tripLog4.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog5 = new TripLog();
        tripLog5.title = "테스트5";
        tripLog5.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog6 = new TripLog();
        tripLog6.title = "테스트6";
        tripLog6.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog7 = new TripLog();
        tripLog7.title = "테스트7";
        tripLog7.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog8 = new TripLog();
        tripLog8.title = "테스트8";
        tripLog8.drawbleId = R.drawable.ic_launcher_background;


        tripLogs.add(tripLog);
        tripLogs.add(tripLog2);
        tripLogs.add(tripLog3);
        tripLogs.add(tripLog4);
        tripLogs.add(tripLog5);
        tripLogs.add(tripLog6);
        tripLogs.add(tripLog7);
        tripLogs.add(tripLog8);


//        MainHomeListDecoration decoration = new MainHomeListDecoration();
//        recyclerView.addItemDecoration(decoration);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        homeAdapter = new MainHomeAdapter(getContext(), tripLogs, onClickListener);
        recyclerLookBack.setLayoutManager(layoutManager);
        recyclerLookBack.setAdapter(homeAdapter);
        recyclerLookBack.setNestedScrollingEnabled(false);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = (String) view.getTag();
            Toast.makeText(rootView.getContext(), str, Toast.LENGTH_SHORT).show();
        }
    };
}
