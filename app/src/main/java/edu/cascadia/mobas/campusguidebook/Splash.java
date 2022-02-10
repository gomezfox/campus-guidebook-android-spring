package edu.cascadia.mobas.campusguidebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.ui.login.LoginActivity;

public class Splash extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        (new Handler).postDelayed( () -> {
            // prepare to navigate directly to main activity
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        },1500);

        // Initialize the database and repositories while splash displays
        final AppRepository repo = ((CampusGuidebookApp) getApplication()).getAppRepository();
        Log.d("Splash", "Repository creation " + (repo==null ? "FAILED" : "SUCCESS"));
        final AppDatabase db = ((CampusGuidebookApp) getApplication()).getAppDatabase();
        Log.d("Splash", "Database creation " + (repo==null ? "FAILED" : "SUCCESS"));
        final AppExecutors executors = ((CampusGuidebookApp) getApplication()).getAppExecutors();
        executors.diskIO().execute( () -> {
            Integer count = db.ClubDao().getClubCount();
            Log.d("Splash", "Club count is " + count.toString());
        });
    }
}

