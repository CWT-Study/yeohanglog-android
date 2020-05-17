package team.triplog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import team.triplog.activity.MoreUserActivity;

public class MainMoreFragment extends Fragment {
    private View rootView;
    private TextView textVersion;
    private ConstraintLayout buttonProfile;

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

        buttonProfile.setOnClickListener(onClickListener);
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
            }
        }
    };
}
