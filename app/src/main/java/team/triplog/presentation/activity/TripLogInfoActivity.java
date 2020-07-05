package team.triplog.presentation.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.domain.entity.TripLogInfo;
import team.triplog.domain.entity.TripLogInfoChat;
import team.triplog.presentation.adapter.TripLogInfoChatAdapter;
import team.triplog.presentation.adapter.TripLogInfoNumAdapter;
import team.triplog.presentation.adapter.TripLogInfoViewPagerAdapter;

public class TripLogInfoActivity extends BaseActivity {

    TextView textTitle;
    TextView textTripLogInfoDay;
    RecyclerView recyclerViewNum;
    ViewPager2 viewPager;
    RecyclerView recyclerViewChat;
    EditText editTripLogInfo;

    private ArrayList<TripLogInfo> tripLogInfos = new ArrayList<>();
    private ArrayList<TripLogInfoChat> tripLogInfoChats = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;

    private TripLogInfoViewPagerAdapter tripLogInfoViewPagerAdapter;
    private TripLogInfoNumAdapter tripLogInfoNumAdapter;
    private TripLogInfoChatAdapter tripLogInfoChatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_log_info);


        init();
        setData();
        setUi();
        setListener();
    }

    private void init() {
        textTitle = findViewById(R.id.text_title);
        textTripLogInfoDay = findViewById(R.id.text_trip_log_info_day);
        recyclerViewNum = findViewById(R.id.recyclerView_num);
        viewPager = findViewById(R.id.viewpager);
        recyclerViewChat = findViewById(R.id.recyclerView_chat);
        editTripLogInfo = findViewById(R.id.edit_trip_log_info);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewNum.setLayoutManager(layoutManager);
    }

    private void setData() {
        // TODO : Test code
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfos.add(new TripLogInfo());
        tripLogInfoChats.add(new TripLogInfoChat());
        tripLogInfoChats.add(new TripLogInfoChat());

        tripLogInfoViewPagerAdapter = new TripLogInfoViewPagerAdapter(getApplicationContext(), tripLogInfos);
        tripLogInfoNumAdapter = new TripLogInfoNumAdapter(getApplicationContext(), tripLogInfos);
        tripLogInfoChatAdapter = new TripLogInfoChatAdapter(getApplicationContext(), tripLogInfoChats);

        viewPager.setAdapter(tripLogInfoViewPagerAdapter);
        recyclerViewNum.setAdapter(tripLogInfoNumAdapter);


        recyclerViewChat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewChat.setAdapter(tripLogInfoChatAdapter);


    }

    private void setUi() {
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setOffscreenPageLimit(3);
        final float pageMargin = 180;
        final float pageOffset = 180;

        viewPager.setPageTransformer((page, position) -> {
            float myOffset = position * -(2 * pageOffset + pageMargin);
            if (position < -1) {
                page.setTranslationX(-myOffset);
            } else if (position <= 1) {
                float scaleFactor = Math.max(0.7F, (float) 1 - Math.abs(position - 0.14285715F));
                page.setTranslationX(myOffset);
                page.setScaleY(scaleFactor);
                page.setAlpha(scaleFactor);
            } else {
                page.setAlpha(0f);
                page.setTranslationX(myOffset);
            }
        });
    }


    private void setListener() {
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                Log.e("Selected_Page", String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}
