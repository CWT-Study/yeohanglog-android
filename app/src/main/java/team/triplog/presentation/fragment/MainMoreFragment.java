package team.triplog.presentation.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import io.realm.Realm;
import team.triplog.BuildConfig;
import team.triplog.R;
import team.triplog.data.local.User;
import team.triplog.presentation.activity.MoreUserActivity;
import team.triplog.presentation.activity.SignInActivity;

public class MainMoreFragment extends Fragment {
    private View rootView;
    private TextView textUserName;
    private TextView textUserCode;
    private TextView textVersion;
    private ImageView viewUserProfile;
    private Switch switchSettingAppPush;
    private Switch switchSettingAdvertising;
    private ConstraintLayout buttonProfile;
    private ConstraintLayout buttonSettingAppPush;
    private ConstraintLayout buttonSettingAdvertising;
    private ConstraintLayout buttonSignOut;
    private Realm realm;
    private User user;

    public MainMoreFragment(Realm realm, User user) {
        this.realm = realm;
        this.user = user;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_more, container, false);

        init();
        setUi();

        return rootView;
    }

    private void init() {
        textUserName = rootView.findViewById(R.id.text_user_name);
        textUserCode = rootView.findViewById(R.id.text_user_code);
        textVersion = rootView.findViewById(R.id.text_version);
        viewUserProfile = rootView.findViewById(R.id.view_user_profile);
        buttonProfile = rootView.findViewById(R.id.button_profile_setting);
        buttonSettingAppPush = rootView.findViewById(R.id.layout_notice_app_push);
        buttonSettingAdvertising = rootView.findViewById(R.id.layout_notice_advertising);
        buttonSignOut = rootView.findViewById(R.id.layout_sign_out);
        switchSettingAppPush = rootView.findViewById(R.id.switch_notice_app_push);
        switchSettingAdvertising = rootView.findViewById(R.id.switch_notice_advertising);

        // TODO : Switch on/off 상태 초기화 해주기 (User 의 값에 따른 처리)

        buttonProfile.setOnClickListener(onClickListener);
        buttonSettingAppPush.setOnClickListener(onClickListener);
        buttonSettingAdvertising.setOnClickListener(onClickListener);
        buttonSignOut.setOnClickListener(onClickListener);
    }

    private void setUi() {
        textVersion.setText(getString(R.string.main_more_version, BuildConfig.VERSION_NAME));
        textUserName.setText(user.getName());

        Glide.with(this)
                .load(user.getImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(16)))
                .thumbnail(0.1f)
                .into(viewUserProfile);
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

                case R.id.layout_sign_out:
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(getString(R.string.pop_up_sign_out_title));
                    builder.setMessage(getString(R.string.pop_up_sign_out_message));
                    builder.setPositiveButton(getString(R.string.button_ok),
                            (dialog, which) -> {
                                realm.executeTransactionAsync(
                                        realm -> realm.delete(User.class),
                                        () -> Log.i(":::::", "success !"),
                                        error -> Log.e(":::::", error.toString()));

                                UserManagement.getInstance()
                                        .requestLogout(new LogoutResponseCallback() {
                                            @Override
                                            public void onCompleteLogout() {
                                                Intent intent1 = new Intent(getContext(), SignInActivity.class);
                                                startActivity(intent1);
                                                getActivity().finish();
                                            }
                                        });
                            });
                    builder.setNegativeButton(getString(R.string.button_cancel), null);
                    builder.show();
                    break;
            }
        }
    };
}
