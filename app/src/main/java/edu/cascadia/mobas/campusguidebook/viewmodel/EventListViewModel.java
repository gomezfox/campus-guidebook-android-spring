package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;
import edu.cascadia.mobas.campusguidebook.ui.events.UIItem;


@RequiresApi(api = Build.VERSION_CODES.O)
public class EventListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private final MediatorLiveData<List<UIItem>> mLiveEventsList = new MediatorLiveData<>();
    private ImageRepository mImageRepository = null;

    public EventListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        mImageRepository = ((CampusGuidebookApp) application).getImageRepository();
        // Adds repository source for textual live data
        mLiveEventsList.addSource(mAppRepository.getAllEvents(), events -> {
            List<UIItem> list = new ArrayList<UIItem>();
            for (Event event : events) {
                list.add(new UIItem(event, mImageRepository.getImage(event.getImageUri())));
            }
            mLiveEventsList.setValue(list);
        });
    }

    public LiveData<List<UIItem>> getAllEvents() { return mLiveEventsList; }

    // Gets a single event
    public LiveData<Event> getEvent(int eventId) { return mAppRepository.getEvent( eventId );}
}
