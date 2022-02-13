package edu.cascadia.mobas.campusguidebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.ui.login.LoginActivity;

public class Splash extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the database and repositories
        AppRepository _dummy_ = ((CampusGuidebookApp) getApplication()).getAppRepository();
        Log.d("Splash", "Repository creation " + (_dummy_==null ? "FAILED" : "SUCCESS"));

        Handler handler = new Handler();

        handler.postDelayed( () -> {
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();

        },1500);
    }
}

