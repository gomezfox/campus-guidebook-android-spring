package edu.cascadia.mobas.campusguidebook.data.repository.liveimage;

import android.media.Image;

import androidx.lifecycle.LiveData;

import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;

public interface ILiveImageRepository {

    public abstract ILiveImageRepository getInstance(AppDatabase database, AppExecutors executors);

    public abstract LiveData<Image> getLiveImage(String uri);


}
