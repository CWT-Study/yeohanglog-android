package team.triplog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import team.triplog.activity.MoreUserActivity;

public class MainMoreFragment extends Fragment {
    private View rootView;
    private TextView textVersion;
    private Switch switchSettingAppPush;
    private Switch switchSettingAdvertising;
    private ConstraintLayout buttonProfile;
    private ConstraintLayout buttonSettingAppPush;
    private ConstraintLayout buttonSettingAdvertising;
    private ConstraintLayout buttonWithdrawal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_more, container, false);

        init();
        setUi();

        return rootView;
    }

    private void init() {
        textVersion = rootView.findViewById(R.id.text_version);
        buttonProfile = rootView.findViewById(R.id.button_profile_setting);
        buttonSettingAppPush = rootView.findViewById(R.id.layout_notice_app_push);
        buttonSettingAdvertising = rootView.findViewById(R.id.layout_notice_advertising);
        buttonWithdrawal = rootView.findViewById(R.id.layout_withdrawal);
        switchSettingAppPush = rootView.findViewById(R.id.switch_notice_app_push);
        switchSettingAdvertising = rootView.findViewById(R.id.switch_notice_advertising);

        // TODO : Switch on/off 상태 초기화 해주기 (User 의 값에 따른 처리)

        buttonProfile.setOnClickListener(onClickListener);
        buttonSettingAppPush.setOnClickListener(onClickListener);
        buttonSettingAdvertising.setOnClickListener(onClickListener);
        buttonWithdrawal.setOnClickListener(onClickListener);
    }

    private void setUi() {
        textVersion.setText(getString(R.string.main_more_version, BuildConfig.VERSION_NAME));
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_profile_setting:
                    Intent intent = new Intent(getContext(), MoreUserActivity.class);
                    startActivity(intent);
                    break;

                case R.id.layout_notice_app_push:
                    switchSettingAppPush.setChecked(!switchSettingAppPush.isChecked());
                    break;

                case R.id.layout_notice_advertising:
                    switchSettingAdvertising.setChecked(!switchSettingAdvertising.isChecked());
                    break;

                case R.id.layout_withdrawal:
                    // TODO : 회원 탈퇴 기능 추가
                    break;
            }
        }
    };
}
