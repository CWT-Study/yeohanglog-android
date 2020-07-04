package team.triplog.presentation.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import team.triplog.R;
import team.triplog.presentation.util.TextCountAnimation;

public class TripAccountActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_account);

        init();
        setData();
        setUi();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        textTotal = findViewById(R.id.text_total);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void setData() {
    }

    private void setUi() {
        // TODO : 임시로 1,000 을 주도록 설정
        // TODO : 이후 실제 데이터로 변경 필요.

        textTotal.startAnimation(new TextCountAnimation(textTotal, 1000));
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
