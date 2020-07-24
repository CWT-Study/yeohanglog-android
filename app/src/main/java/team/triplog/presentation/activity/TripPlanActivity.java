package team.triplog.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.presentation.adapter.TripPlanDayAdapter;

public class TripPlanActivity extends BaseActivity {
    private Toolbar toolbar;
    private ConstraintLayout buttonAccount;
    private ConstraintLayout buttonCheck;
    private ConstraintLayout buttonMember;
    private ConstraintLayout buttonPhoto;
    private TextView textTitle;
    private TextView textTripName;
    private TextView textTripPeriod;
    private RecyclerView recyclerTripPlan;
    private TripPlanDayAdapter planDayAdapter;
    private ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_plan);

        init();
        setData();
        setUi();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        textTitle = findViewById(R.id.text_title);
        textTripName = findViewById(R.id.text_trip_name);
        textTripPeriod = findViewById(R.id.text_trip_period);
        buttonAccount = findViewById(R.id.button_account);
        buttonCheck = findViewById(R.id.button_check);
        buttonMember = findViewById(R.id.button_member);
        buttonPhoto = findViewById(R.id.button_photo);
        recyclerTripPlan = findViewById(R.id.recycler_trip_plan);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        planDayAdapter = new TripPlanDayAdapter(this, items);
        recyclerTripPlan.setLayoutManager(layoutManager);
        recyclerTripPlan.setAdapter(planDayAdapter);
        recyclerTripPlan.setNestedScrollingEnabled(false);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        buttonAccount.setOnClickListener(onClickListener);
        buttonCheck.setOnClickListener(onClickListener);
        buttonMember.setOnClickListener(onClickListener);
        buttonPhoto.setOnClickListener(onClickListener);
    }

    private void setData() {
        //더미데이터ㅎㅎ
        items.add("TEST_DAY1");
        items.add("TEST_DAY2");
        items.add("TEST_DAY3");
        items.add("TEST_DAY4");
        items.add("TEST_DAY5");

        planDayAdapter.setItems(items);
    }

    private void setUi() {
        // TODO : String 형식이 아닌 Trip 객체를 받아서 처리 필요.
        Intent intent = getIntent();
        textTitle.setText(intent.getStringExtra("EXTRA_TRIP_NAME"));
        textTripName.setText(intent.getStringExtra("EXTRA_TRIP_NAME"));
        textTripPeriod.setText(intent.getStringExtra("EXTRA_TRIP_PERIOD"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            supportFinishAfterTransition();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onClickListener = view -> {
        switch (view.getId()) {
            case R.id.button_account:
                Intent intent = new Intent(this, TripAccountActivity.class);
                startActivity(intent);
                break;

            case R.id.button_check:
                intent = new Intent(this, TripCheckActivity.class);
                startActivity(intent);
                break;

            case R.id.button_member:
                intent = new Intent(this, TripMemberActivity.class);
                startActivity(intent);
                break;

            case R.id.button_photo:
                intent = new Intent(this, TripAlbumActivity.class);
                startActivity(intent);
                break;
        }
    };
}
