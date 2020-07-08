package team.triplog.presentation.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;

public class BaseActivity extends AppCompatActivity {
    protected Realm realm;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }

    public void hideKeyboard(View view) {
        // inputMethodManager 로 키보드를 내리도록 설정
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
