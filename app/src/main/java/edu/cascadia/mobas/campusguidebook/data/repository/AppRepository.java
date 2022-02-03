package edu.cascadia.mobas.campusguidebook.data.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
import edu.cascadia.mobas.campusguidebook.data.dao.*;
import edu.cascadia.mobas.campusguidebook.data.model.*;


public class AppRepository {

    // instance variable for singleton
    private static AppRepository sAppRepository = null;

    private static AppDatabase mAppDatabase = null;
    private static AppExecutors mAppExecutors = null;


    // private constructor to enforce singleton pattern
    private AppRepository() {}

    private AppRepository(AppDatabase db, AppExecutors executors) {
        if (sAppRepository != null) return;
        mAppDatabase = db;
        mAppExecutors = executors;
    }

    // returns the AppRepository instance, creating if necessary
    public static AppRepository getInstance(AppDatabase db, AppExecutors executors) {
        if (sAppRepository == null) {
            sAppRepository = new AppRepository(db, executors);
        }
        return sAppRepository;
    }

    // METHODS TO RETURN LIVEDATA FROM APPDATABASE
    // returns a list of all events
    public LiveData<List<Event>> getAllEvents() {
        return mAppDatabase.EventDao().getAllEvents();
    }

    // returns a list of all users
    public LiveData<List<User>> getAllUsers() {
        return mAppDatabase.UserDao().getAllUsers();
    }

    // returns a list of all clubs
    public LiveData<List<Club>> getAllClubs() {
        return mAppDatabase.ClubDao().getAllClubs();
    }

    // returns a list of all sustainability
    public LiveData<List<Sustainability>> getAllSustainability() {
        return mAppDatabase.SustainabilityDao().getAllSustainability();
    }


    // Additional Event CRUD operations
    public static void insert(Event... events) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Event event:events) {
                    mAppDatabase.EventDao().insert(event);
                }
            });
        });
    }
    public static void update(Event... events) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Event event:events) {
                    mAppDatabase.EventDao().update(event);
                }
            });
        });
    }

    public static void delete(Event... events) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Event event : events) {
                    mAppDatabase.EventDao().delete(event);
                }
            });
        });
    }

    // Additional Club CRUD operations
    public static void insert(Club... clubs) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Club club : clubs) {
                    mAppDatabase.ClubDao().insert(club);
                }
            });
        });
    }

    public static void update(Club... clubs) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Club club : clubs) {
                    mAppDatabase.ClubDao().update(club);
                }
            });
        });
    }

    public static void delete(Club... clubs) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Club club : clubs) {
                    mAppDatabase.ClubDao().delete(club);
                }
            });
        });
    }

    // Additional Sustainability CRUD operations
    public static void insert(Sustainability... sustainabilities) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Sustainability sustainability : sustainabilities) {
                    mAppDatabase.SustainabilityDao().insert(sustainability);
                }
            });
        });
    }

    public static void update(Sustainability... sustainabilities) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Sustainability sustainability : sustainabilities) {
                    mAppDatabase.SustainabilityDao().update(sustainability);
                }
            });
        });
    }

    public static void delete(Sustainability... sustainabilities) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (Sustainability sustainability : sustainabilities) {
                    mAppDatabase.SustainabilityDao().delete(sustainability);
                }
            });
        });
    }

    // Additional User CRUD operations
    public static void insert(User... users) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (User user : users) {
                    mAppDatabase.UserDao().insert(user);
                }
            });
        });
    }

    public static void update(User... users) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (User user : users) {
                    mAppDatabase.UserDao().update(user);
                }
            });
        });
    }

    public static void delete(User... users) {
        mAppExecutors.diskIO().execute( () -> {
            mAppDatabase.runInTransaction( () -> {
                for (User user : users) {
                    mAppDatabase.UserDao().delete(user);
                }
            });
        });
    }
}