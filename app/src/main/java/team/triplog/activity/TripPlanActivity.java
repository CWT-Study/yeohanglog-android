package team.triplog.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_plan);

        init();
        setData();
        setUi();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
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
        }
    };
}
