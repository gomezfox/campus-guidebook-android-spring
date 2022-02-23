package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;


@RequiresApi(api = Build.VERSION_CODES.O)
public class EventListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private final LiveData<List<Event>> mLiveEventsList;

    public EventListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        // Adds repository source for textual live data
        mLiveEventsList = mAppRepository.getAllEvents();

    }

    public LiveData<List<Event>> getAllEvents() { return mLiveEventsList; }

    // Gets a single event
    public LiveData<Event> getEvent(int eventId) { return mAppRepository.getEvent( eventId );}
}
