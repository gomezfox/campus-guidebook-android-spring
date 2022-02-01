package edu.cascadia.mobas.campusguidebook.data.database;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.TypeConverters;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
public abstract class AppDatabase extends RoomDatabase {

    // below line is to create instance
    // for our singleton database class.
    private static AppDatabase instance;

    // below line is to save the executor pool
    // to create database and supply repositories
    private AppExecutors appExecutors;

    // below line is to create
    // abstract variable for dao.
    public abstract EventDao EventDao();
    public abstract ClubDao ClubDao();
    public abstract SustainabilityDao SustainabilityDao();
    public abstract UserDao UserDao();

    // on below line we are getting instance for our database.
    public AppDatabase getInstance(Application application, AppExecutors appExecutors) {
        // return existing singleton instance
        // unless the instance is null
        if (instance != null) { return instance; }
        // otherwise block access until database is built
        synchronized (AppDatabase.class) {
            // if the instance is null we
            // are creating a new instance
            this.appExecutors = appExecutors;
            instance =
                // for creating a instance for our database
                // we are creating a database builder and passing
                // our database class with our database name.
                Room.databaseBuilder(application.getApplicationContext(),
                    AppDatabase.class, "appDatabase")
                // below line is use to add fall back to
                // destructive migration to our database.
                    .fallbackToDestructiveMigration()
                    // below line add callback that the builder executes
                    // after build is complete and instance exists
                    .addCallback(new RoomDatabase.Callback() {
                        @Override
                        public void onCreate(SupportSQLiteDatabase sqLiteDatabase) {
                            super.onCreate(sqLiteDatabase);
                            // this method is called after
                            // the database build
                            appExecutors.diskIO().execute(() -> {
                                // use a transaction to insert
                                // all the sample data in one pass
                                getInstance(application, appExecutors).runInTransaction(() -> {
                                    instance.EventDao().insert(SampleData.events());
                                    instance.ClubDao().insert(SampleData.clubs());
                                    instance.SustainabilityDao().insert(SampleData.sustainability());
                                    instance.UserDao().insert(SampleData.users());
                                });
                            });
                        }
                    })
                   .build();  // creates database then executes callback above
            // return the newly created singleton instance
            // note: callback may still be populating database
            return instance;
        } // End of synchronized block
    } // End of getInstance
}



