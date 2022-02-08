package edu.cascadia.mobas.campusguidebook.data.repository.liveimage;

import android.media.Image;

import androidx.lifecycle.LiveData;

import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;

public class LiveImageRepository implements ILiveImageRepository {

    private static LiveImageRepository mLiveImageRepository;
    private AppDatabase mAppDatabase;
    private AppExecutors mAppExecutors;

    // private default constructor to enforce singleton
    private LiveImageRepository() {}

    // private standard constructor takes AppDatabase and AppExecutors to initialize singleton
    private LiveImageRepository(AppDatabase database, AppExecutors executors) {
        if (mLiveImageRepository != null) { return; }
        mAppDatabase = database;
        mAppExecutors = executors;
        mLiveImageRepository = this;
    }

    // returns the singleton instance of this repository, creating it if not exists
    @Override
    public LiveImageRepository getInstance(AppDatabase database, AppExecutors executors) {
        if (mLiveImageRepository == null) {
            mLiveImageRepository = new LiveImageRepository(database, executors);
        }
        return mLiveImageRepository;
    }

    public LiveData<Image> getLiveImage(String uri) {
        return null;
    }



}


