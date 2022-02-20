package edu.cascadia.mobas.campusguidebook;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LruCache;
import androidx.lifecycle.LiveData;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;

import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // TODO: Consider executing behind MainActivity instead of splash per recommended practices
        // Schedule in intent to navigate to main after the given time delay
        ((CampusGuidebookApp) getApplication())
                .getAppExecutors()
                .scheduled()
                .schedule( () -> {
                    // use an intent to navigate directly to main activity
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();  // end this activity
                }, AppConfig.SPLASH_DISPLAY_TIME, TimeUnit.MILLISECONDS);

        // Run all app initialization tasks
        (new AppInit((CampusGuidebookApp)this.getApplication())).initialize();
    }
}