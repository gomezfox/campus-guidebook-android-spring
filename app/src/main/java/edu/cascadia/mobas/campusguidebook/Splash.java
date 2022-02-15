package edu.cascadia.mobas.campusguidebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;

import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;
import edu.cascadia.mobas.campusguidebook.ui.login.LoginActivity;

public class Splash extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed( () -> {
            Intent intent = new Intent(Splash.this, LoginActivity.class);
            startActivity(intent);
            finish();

        },2500);

        // Initialize the database and repositories while splash displays
        AppRepository appRepository = ((CampusGuidebookApp) getApplication()).getAppRepository();
        ImageRepository imageRepository = ((CampusGuidebookApp) getApplication()).getImageRepository();
    }
}


