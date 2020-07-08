package team.triplog.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import team.triplog.R;

public class TripInfoActivity extends BaseActivity {
    private Group groupInputName;
    private Group groupSelectPeriod;
    private Toolbar toolbar;
    private EditText editName;
    private TextView textName;
    private ConstraintLayout layoutParent;
    private FloatingActionButton buttonNext;
    private FloatingActionButton buttonPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_info);

        init();
        setData();
        setUi();
    }

    private void init() {
        layoutParent = findViewById(R.id.layout_parent);
        groupInputName = findViewById(R.id.group_input_name);
        groupSelectPeriod = findViewById(R.id.group_select_date);
        editName = findViewById(R.id.edit_trip_name);
        textName = findViewById(R.id.text_trip_name);
        buttonNext = findViewById(R.id.button_next);
        buttonPrev = findViewById(R.id.button_previous);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        layoutParent.setOnClickListener(onClickListener);
        buttonNext.setOnClickListener(onClickListener);
        buttonPrev.setOnClickListener(onClickListener);
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
                case R.id.layout_parent: {
                    if (getCurrentFocus() != null) {
                        getCurrentFocus().clearFocus();
                    }
                    hideKeyboard(view);
                    break;
                }
                case R.id.button_next:
                    // TODO : 이름 및 기간 설정 완료시 다음화면으로 넘어가도록 설정
//                    groupInputName.setVisibility(View.GONE);
//                    groupSelectPeriod.setVisibility(View.VISIBLE);

                    // TODO : 임시 화면 연동
                    Intent intent = new Intent(getApplicationContext(), TripPlanActivity.class);
                    startActivity(intent);
                    break;

                case R.id.button_previous:
                    groupInputName.setVisibility(View.VISIBLE);
                    groupSelectPeriod.setVisibility(View.GONE);
                    break;
            }
        }
    };
}
