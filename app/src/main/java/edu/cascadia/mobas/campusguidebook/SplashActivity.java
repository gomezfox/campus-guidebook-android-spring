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

    public static final long SPLASH_DISPLAY_TIME = 1500;
    private AppExecutors executors;

    // List of initialization tasks
    private final Runnable [] initializationTasks = {
            new InitializeRepositories(),
            new PreloadImageCache()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        executors = ((CampusGuidebookApp) getApplication()).getAppExecutors();
        // TODO: Move initialization code to its own module, outside Activity. Apply WorkManager?
        // TODO: Consider executing behind MainActivity instead of splash per recommended practices
        // Schedule automatic navigation from splash animation to main activity after delay
        executors.scheduled().schedule(new NavigateToMain(), 1500, TimeUnit.MILLISECONDS);

        // Use an executor to Iterate through list of initialization tasks and execute
        // for now, tasks are executed on a single background thread, in sequence
        executors.diskIO().execute(() -> {
            for (Runnable task : initializationTasks) {
                task.run();
            }
        });
    }

    // Set of runnable tasks that can be used by initialization
    // Action to navigate away from Splash activity to MainActivity
    private class NavigateToMain implements Runnable {
        public void run() {
            // prepare an intent to navigate directly to main activity
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    // Action to load repositories for the first time to initialize singletons
    private class InitializeRepositories implements Runnable {
        public void run() {
            AppRepository repo = ((CampusGuidebookApp) getApplication()).getAppRepository();
            ImageRepository imageRepository = ((CampusGuidebookApp) getApplication()).getImageRepository();
        }
    }

    // TODO: Implement PreloadImageCache
    // Action to preload image cache
    private class PreloadImageCache implements Runnable {
        public void run() {
            return;
        }
    }
}