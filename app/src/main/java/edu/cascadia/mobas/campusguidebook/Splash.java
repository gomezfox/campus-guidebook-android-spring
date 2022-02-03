package edu.cascadia.mobas.campusguidebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;

import edu.cascadia.mobas.campusguidebook.data.SampleData;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.model.User;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.ui.login.LoginActivity;

public class Splash extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the database and repositories
        AppRepository _dummy_ = ((CampusGuidebookApp)getApplication()).getAppRepository();
        if (_dummy_.equals(null)) { Log.d("Splash", "AppRepository not created"); };
        AppExecutors appExecutors = ((CampusGuidebookApp)getApplication()).getAppExecutors();
        AppDatabase appDatabase = ((CampusGuidebookApp)getApplication()).getAppDatabase();
        appExecutors.diskIO().execute(() -> {
            // use a transaction to insert
            // all the sample data in one pass
            appDatabase.clearAllTables();
            appDatabase.runInTransaction(() -> {

                for (Event event : SampleData.events) {
                    AppRepository.insert(event);
                }
                for (Club club : SampleData.clubs) {
                    AppRepository.insert(club);
                }
                for (Sustainability sustainability : SampleData.sustainabilities) {
                    AppRepository.insert(sustainability);
                }
                for (User user : SampleData.users)
                    AppRepository.insert(user);
            });
        });


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
