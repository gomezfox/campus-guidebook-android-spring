package edu.cascadia.mobas.campusguidebook.data;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import java.util.TimeZone;
import java.time.ZoneId;
import java.time.ZonedDateTime;


import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.model.User;


@RequiresApi(api = Build.VERSION_CODES.O)
public class SampleData {

    private static final ZoneId zoneId = TimeZone.getTimeZone("America/Los_Angeles").toZoneId();
    public static final Event[] events = {
            new Event("Math Club - Weekly Meeting", "Meets every other Tuesday at 3:30", "CC1-210", ZonedDateTime.of(2022,3,1,15,30,0,0, zoneId)),
            new Event("Engineering Club - Symposium", "The biggest Engineering event of the year", "CC2-120", ZonedDateTime.of(2022, 10, 7, 11, 0, 0, 0, zoneId)),
    };

    public static final Club[] clubs = {
            new Club("Math Club", "A group for students who love math or who would like to learn more", "Mathy McMathface <mathy@mathface.com", "Almathia Newton <anewton@gmail.com>"),
            new Club("Engineering Club", "A group for students who love to design, fabricate, and build", "Howard Wolowitz <hwolowitz@caltech.edu", "Motor Close <motorclose@badjoke.com>"),
    };

    public static final Sustainability[] sustainabilities = {
            new Sustainability("Wetlands", "Wetlands along North Creek have been restored, benefiting local wildlife and salmon populations"),
    };

    public static final User[] users = new User[]{
            new User("John Q. Public", "Math Club, Engineering Club", "OpenSecret"),
    };

    public static void addAll(AppDatabase appDatabase, AppExecutors appExecutors) {
        // clear existing data from all tables
        // this will trigger the RoomDatabase.Callback to add sample data
        Log.d("AppDatabase", "Clearing all tables BEGIN");
        appExecutors.diskIO().execute(() -> {
            appDatabase.clearAllTables();
            Log.d("AppDatabase", "Clearing all tables FINISHED");
            // use a transaction to insert
            // all the sample data in one pass
            Log.d("AppDatabasse", "Adding sample data BEGIN");
            appDatabase.runInTransaction(() -> {
                for (Event event : SampleData.events) {
                    appDatabase.EventDao().insert(event);
                }
                for (Club club : SampleData.clubs) {
                    appDatabase.ClubDao().insert(club);
                }
                for (Sustainability sustainability : SampleData.sustainabilities) {
                    appDatabase.SustainabilityDao().insert(sustainability);
                }
                for (User user : SampleData.users)
                    appDatabase.UserDao().insert(user);
                Log.d("AppDatabase", "Adding sample data FINISHED");
            });
        });
    }
 }


