package edu.cascadia.mobas.campusguidebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.widget.ProgressBar;

import edu.cascadia.mobas.campusguidebook.login.LoginActivity;
import edu.cascadia.mobas.campusguidebook.ui.home.HomeFragment;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}