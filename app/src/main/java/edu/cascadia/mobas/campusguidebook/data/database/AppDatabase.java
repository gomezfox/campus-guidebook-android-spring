package edu.cascadia.mobas.campusguidebook.data.database;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Database;
import androidx.room.TypeConverters;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import edu.cascadia.mobas.campusguidebook.data.SampleData;
import edu.cascadia.mobas.campusguidebook.data.dao.*;
import edu.cascadia.mobas.campusguidebook.data.model.*;
import edu.cascadia.mobas.campusguidebook.data.typeconverter.*;
import edu.cascadia.mobas.campusguidebook.AppExecutors;


// adding annotation for our database entities and db version.
@Database(entities = {
        Event.class,
        Club.class,
        Sustainability.class,
        User.class}, version = 1)
@TypeConverters(OffsetDateTimeConverter.class)
@RequiresApi(api = Build.VERSION_CODES.O)
public abstract class AppDatabase extends RoomDatabase {

    // below line is to create instance
    // for our singleton database class.
    private static AppDatabase instance;

    // below line is to save the executor pool
    // to create database and supply repositories

    // below line is to create
    // abstract variable for dao.
    public abstract EventDao EventDao();

    public abstract ClubDao ClubDao();

    public abstract SustainabilityDao SustainabilityDao();

    public abstract UserDao UserDao();


    public static AppDatabase getInstance(final Context application, final AppExecutors appExecutors) {
        // return existing singleton instance
        // unless the instance is null
        if (instance == null) {
            synchronized (AppDatabase.class) {
                instance = databaseBuilder(application.getApplicationContext(), appExecutors);
            }
        }
        return instance;
    }

    // returns an instance without creating if null
    // used locally
    private static AppDatabase getInstance() {
        return instance;
    }

    // implements builder pattern to create the database
    // a callback is then used to populate it
    private static AppDatabase databaseBuilder(final Context context, final AppExecutors appExecutors) {
        // build the database
        AppDatabase appDatabase =
                // for creating a instance for our database
                // we are creating a database builder and passing
                // our database class with our database name.
                Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "appDatabase")
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                    AppDatabase database = AppDatabase.getInstance(context, appExecutors);
                                    database.runInTransaction(() -> {
                                        for (Event event : SampleData.events) {
                                            instance.EventDao().insert(event);
                                        }
                                        for (Club club : SampleData.clubs) {
                                            instance.ClubDao().insert(club);
                                        }
                                        for (Sustainability sustainability : SampleData.sustainabilities) {
                                            instance.SustainabilityDao().insert(sustainability);
                                        }
                                        for (User user : SampleData.users)
                                            instance.UserDao().insert(user);
                                    });
                            }
                        })
                        .allowMainThreadQueries()
                        .build();
        appDatabase.UserDao().insert(new User("Bob", "none", "secret"));
/*        for (Event event : SampleData.events) {
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

*/
        // return the newly created singleton instance
        // note: callback may still be populating database upon return
        return appDatabase;
    }
}


/*
    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // this method is called after
            // the database build
            Executors.newSingleThreadExecutor().execute(() -> {
                // use a transaction to insert
                // all the sample data in one pass
                getInstance()
        }
    };

}
*/


