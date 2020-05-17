package team.triplog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MainMoreFragment extends Fragment {
    private View rootView;
    private TextView textVersion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_more, container, false);

        init();
        setUi();

        return rootView;
    }

    private void init() {
        textVersion = rootView.findViewById(R.id.text_version);
    }

    private void setUi() {
        textVersion.setText(getString(R.string.main_more_version, BuildConfig.VERSION_NAME));
    }
}
