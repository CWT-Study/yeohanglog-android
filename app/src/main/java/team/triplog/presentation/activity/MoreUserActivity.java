package team.triplog.presentation.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import team.triplog.R;
import team.triplog.data.local.User;

public class MoreUserActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView textUserName;
    private TextView textUserCode;
    private TextView textUserAccount;
    private ImageView viewUserProfile;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_user);

        init();
        setData();
        setUi();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        textUserName = findViewById(R.id.text_user_name);
        textUserCode = findViewById(R.id.text_user_code);
        textUserAccount = findViewById(R.id.text_user_account);
        viewUserProfile = findViewById(R.id.view_user_profile);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void setData() {
        user = realm.where(User.class).findFirst();
    }

    private void setUi() {
        textUserName.setText(user.getName());

        Glide.with(this)
                .load(user.getImage())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(16)))
                .thumbnail(0.1f)
                .into(viewUserProfile);
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
