package edu.cascadia.mobas.campusguidebook;

import android.os.Bundle;
import android.view.Menu;



import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.appcompat.app.AppCompatActivity;

import edu.cascadia.mobas.campusguidebook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Get the NavController

    private NavController navController;
    // No need to load the start destination, handled automatically by the Navigation component
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //@Override
    //public boolean onSupportNavigateUp() {
    //
    //    return NavigationUI.navigateUp(navController, new AppBarConfiguration.Builder())
    //            || super.onSupportNavigateUp();
    // }
}
