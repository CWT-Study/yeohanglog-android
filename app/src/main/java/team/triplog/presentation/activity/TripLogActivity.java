package team.triplog.presentation.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.entity.TripLog;
import team.triplog.presentation.adapter.TripLogAdapter;
import team.triplog.presentation.adapter.TripLogContentAdapter;

public class TripLogActivity extends AppCompatActivity {

    TextView text_save;
    RecyclerView recyclerView_title;
    RecyclerView recyclerView_content;
    private Toolbar toolbar;
    private RecyclerView.LayoutManager layoutManager;
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
        text_save = findViewById(R.id.text_save);
        recyclerView_title = findViewById(R.id.recyclerView_title);
        recyclerView_content = findViewById(R.id.recyclerView_content);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_title.setLayoutManager(layoutManager);

        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView_content.setLayoutManager(layoutManager);

    }

    private void setData() {
        TripLog tripLog = new TripLog();//TODO First Item 무조건 하나 집어넣는다
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

        tripLogAdapter = new TripLogAdapter(getApplicationContext(), tripLogs);
        tripLogContentAdapter = new TripLogContentAdapter(getApplicationContext(), tripLogs);

        recyclerView_title.setAdapter(tripLogAdapter);
        recyclerView_content.setAdapter(tripLogContentAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
