package edu.cascadia.mobas.campusguidebook;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // No need to load the start destination, handled automatically by the Navigation component
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result =super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        if (result) { getMenuInflater().inflate(R.menu.main, menu); }
        return true;
    }
}
