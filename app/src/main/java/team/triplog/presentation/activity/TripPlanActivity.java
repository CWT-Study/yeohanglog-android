package team.triplog.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import team.triplog.R;

public class TripPlanActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ConstraintLayout buttonAccount;
    private ConstraintLayout buttonCheck;
    private ConstraintLayout buttonMember;
    private ConstraintLayout buttonPhoto;
    private TextView textTitle;
    private TextView textTripName;
    private TextView textTripPeriod;

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
                break;

            case R.id.button_check:
                break;

            case R.id.button_member:
                break;

            case R.id.button_photo:
                break;
        }
    };
}
