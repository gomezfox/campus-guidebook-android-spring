package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;
@RequiresApi(api = Build.VERSION_CODES.O)
public class ActivityViewModel extends AndroidViewModel {

    private final AppRepository mAppRepository;
    private final ImageRepository mImageRepository;
    private final AppExecutors mAppExecutors;


    public ActivityViewModel(@NonNull Application application) {
        super(application);
        mAppRepository = ((CampusGuidebookApp)application).getAppRepository();
        mImageRepository = ((CampusGuidebookApp)application).getImageRepository();
        mAppExecutors = ((CampusGuidebookApp)application).getAppExecutors();
    }

    public LiveData<List<Event>> getAllEvents() {
        return mAppRepository.getAllEvents();
    }

    public LiveData<List<Club>> getAllClubs() {
        return mAppRepository.getAllClubs();
    }

    public LiveData<List<Sustainability>> getAllSustainability() {
        return mAppRepository.getAllSustainability();
    }

    public LiveData<Drawable> getImageFromUri(String uri) {
        return mImageRepository.getImage(uri);
    }

}
