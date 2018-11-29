package com.sessionlibexample.sessionmanagerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sessionlib.sessionmanager.PreferenceManager;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView txvSessionUpdateLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvSessionUpdateLbl = findViewById(R.id.txv_session_update);
        PreferenceManager.getInstance().initialize(this);
    }

    public void saveSession(View view) {
        PreferenceManager.getInstance().put("auth", "Auth");
        PreferenceManager.getInstance().put("number", 1);
    }

    public void readSession(View view) {
        String auth = PreferenceManager.getInstance().getString("auth");
        int number = PreferenceManager.getInstance().getInt("number");
        if (auth != null)
            txvSessionUpdateLbl.setText(String.format(Locale.getDefault(), "%s : %d", auth, number));
        else
            txvSessionUpdateLbl.setText("");
    }

    public void destroySession(View view) {
        PreferenceManager.getInstance().destroySession();
    }
}
