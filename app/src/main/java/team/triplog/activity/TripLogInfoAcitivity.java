package team.triplog.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import team.triplog.R;
import team.triplog.adapter.TripLogInfoChatAdapter;
import team.triplog.adapter.TripLogInfoNumAdapter;
import team.triplog.adapter.TripLogInfoViewPagerAdapter;
import team.triplog.entity.TripLogInfo;
import team.triplog.entity.TripLogInfoChat;

public class TripLogInfoAcitivity extends AppCompatActivity {

    TextView textTitle;
    TextView textTripLogInfoDay;
    RecyclerView recyclerViewNum;
    ViewPager2 viewPager2;
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
        setasdas();
    }

    private void init() {
        textTitle = findViewById(R.id.text_title);
        textTripLogInfoDay = findViewById(R.id.text_trip_log_info_day);
        recyclerViewNum = findViewById(R.id.recyclerView_num);
        viewPager2 = findViewById(R.id.viewpager);
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


        tripLogInfos.add(new TripLogInfo()) ;
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


        viewPager2.setAdapter(tripLogInfoViewPagerAdapter);
        recyclerViewNum.setAdapter(tripLogInfoNumAdapter);




        recyclerViewChat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewChat.setAdapter(tripLogInfoChatAdapter);




    }

    private void setUi(){
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setOffscreenPageLimit(3);
        final float pageMargin = 180;
        final float pageOffset = 180;

        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myoffset = position * -(2 * pageOffset+pageMargin);
                if (position< -1){
                    page.setTranslationX(-myoffset);
                }else if (position <=1){
                    float scaleFactor = Math.max(0.7F, (float)1 - Math.abs(position - 0.14285715F));
                    page.setTranslationX(myoffset);
                    page.setScaleY(scaleFactor);
                    page.setAlpha(scaleFactor);
                }else{
                    page.setAlpha(0f);
                    page.setTranslationX(myoffset);
                }
            }
        });
    }


    private void setListener(){
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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

    private void setasdas(){

    }
}
