package edu.cascadia.mobas.campusguidebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;

import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.ui.login.LoginActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the database and repositories
        AppRepository _dummy_ = ((CampusGuidebookApp)getApplication()).getAppRepository();
        if (_dummy_.equals(null)) { Log.d("Splash", "AppRepository not created"); };

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
