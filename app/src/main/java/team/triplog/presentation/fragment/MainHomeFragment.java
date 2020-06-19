package team.triplog.presentation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.presentation.adapter.MainHomeAdapter;
import team.triplog.entity.TripLog;

public class MainHomeFragment extends Fragment {
    private View rootView;
    private Group groupNoContents;
    private TextView textUserName;
    private TextView textTripTitle;
    private TextView textTripContent;
    private TextView textTripDate;
    private RecyclerView recyclerLookBack;
    private NestedScrollView scrollView;
    private MainHomeAdapter homeAdapter;
    private ArrayList<TripLog> tripLookBacks = new ArrayList<>();

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
        textTripTitle = rootView.findViewById(R.id.text_trip_title);
        textTripContent = rootView.findViewById(R.id.txt_trip_content);
        textTripDate = rootView.findViewById(R.id.txt_trip_date);
        recyclerLookBack = rootView.findViewById(R.id.recycler_look_back);
        scrollView = rootView.findViewById(R.id.scroll_view);
    }

    private void setData() {
        TripLog tripLog = new TripLog();
        tripLog.title = "테스트";
        tripLog.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog2 = new TripLog();
        tripLog2.title = "테스트2";
        tripLog2.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog3 = new TripLog();
        tripLog3.title = "테스트3";
        tripLog3.drawbleId = R.drawable.ic_launcher_background;

//        tripLookBacks.add(tripLog);
//        tripLookBacks.add(tripLog2);
//        tripLookBacks.add(tripLog3);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        homeAdapter = new MainHomeAdapter(getContext(), tripLookBacks, onClickListener);
        recyclerLookBack.setLayoutManager(layoutManager);
        recyclerLookBack.setAdapter(homeAdapter);
        recyclerLookBack.setNestedScrollingEnabled(false);

        scrollView.post(() -> scrollView.scrollTo(0, 0));
    }

    private void setUi() {
        // TODO : User 이름으로 대체 필요.
        String userName = "냉수마찰";
        textUserName.setText(userName);

        if (tripLookBacks.isEmpty()) {
            groupNoContents.setVisibility(View.VISIBLE);
        } else {
            groupNoContents.setVisibility(View.INVISIBLE);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.layout_item:
                    TripLog trip = (TripLog) view.getTag();
                    Toast.makeText(rootView.getContext(), trip.title + " 화면으로 이동", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
