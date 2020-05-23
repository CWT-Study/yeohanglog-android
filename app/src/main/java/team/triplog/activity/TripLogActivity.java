package team.triplog.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import team.triplog.R;
import team.triplog.adapter.MainTripLogAdapter;
import team.triplog.adapter.TripLogAdapter;
import team.triplog.adapter.TripLogContentAdapter;
import team.triplog.entity.TripLog;

public class TripLogActivity extends AppCompatActivity {

    TextView image_back;
    TextView text_save;
    RecyclerView recyclerView_title;
    RecyclerView recyclerView_content;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    private ArrayList<TripLog> tripLogs = new ArrayList<>();
    private TripLogAdapter tripLogAdapter;

    private TripLogContentAdapter tripLogContentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_log);


        init();
        setData();
    }

    private void init() {
        image_back = findViewById(R.id.image_back);
        text_save = findViewById(R.id.text_save);
        recyclerView_title = findViewById(R.id.recyclerView_title);
        recyclerView_content = findViewById(R.id.recyclerView_content);

        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_title.setLayoutManager(layoutManager);

        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView_content.setLayoutManager(layoutManager);

    }

    private void setData() {
        TripLog tripLog = new TripLog();//TODO First Item무조건 하나 집어넣는다


        TripLog tripLog2 = new TripLog();
        tripLog2.title = "테수트1";
        tripLog2.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog3 = new TripLog();
        tripLog3.title = "테수트2";
        tripLog3.drawbleId = R.drawable.ic_launcher_background;

        TripLog tripLog4 = new TripLog();
        tripLog4.title = "테수트3";
        tripLog4.drawbleId = R.drawable.ic_launcher_background;

        tripLogs.add(tripLog);
        tripLogs.add(tripLog2);
        tripLogs.add(tripLog3);
        tripLogs.add(tripLog4);


        tripLogAdapter = new TripLogAdapter(context,tripLogs);

        recyclerView_title.setAdapter(tripLogAdapter);

        tripLogContentAdapter = new TripLogContentAdapter(context,tripLogs);
        recyclerView_content.setAdapter(tripLogContentAdapter);


    }


}
