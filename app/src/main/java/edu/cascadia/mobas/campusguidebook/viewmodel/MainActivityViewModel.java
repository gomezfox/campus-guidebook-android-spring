package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.time.ZonedDateTime;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.AppExecutors;
import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private final AppRepository mAppRepository;
    private final ImageRepository mImageRepository;
    private final AppExecutors mAppExecutors;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        CampusGuidebookApp app = (CampusGuidebookApp) application;
        mAppRepository = app.getAppRepository();
        mImageRepository = app.getImageRepository();
        mAppExecutors = app.getAppExecutors();
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

    public boolean addNewEvent(String eventName, String eventDescription, String eventLocation, ZonedDateTime eventDateTime) {
        return mAppRepository.addNewEvent(eventName, eventDescription, eventLocation, eventDateTime);
    }
}
