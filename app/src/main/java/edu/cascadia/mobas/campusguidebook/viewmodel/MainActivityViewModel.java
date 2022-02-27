package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.time.ZonedDateTime;

import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;

public class MainActivityViewModel extends AndroidViewModel {

    private AppRepository mAppRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
    }

    public boolean addNewEvent(String eventName, String eventDescription, String eventLocation, ZonedDateTime eventDateTime) {
        return mAppRepository.addNewEvent(eventName, eventDescription, eventLocation, eventDateTime);
    }
}
