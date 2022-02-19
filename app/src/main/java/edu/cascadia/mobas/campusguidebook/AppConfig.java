package edu.cascadia.mobas.campusguidebook;

import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.ZoneId;
import java.util.TimeZone;

@RequiresApi(api = Build.VERSION_CODES.O)

public class AppConfig {
    // Cascadia College local time zone
    public static final ZoneId TIMEZONE = TimeZone.getTimeZone("America/Los_Angeles").toZoneId();

    // Database
    public static final String DATABASE_FILENAME = "CampusGuidebook.sqlite";

    // Image repository default image
    public static final int DEFAULT_IMAGE = R.drawable.cascadia_banner;

    // Splash screen display time in ms
    public static final int SPLASH_DISPLAY_TIME = 1500;
}
