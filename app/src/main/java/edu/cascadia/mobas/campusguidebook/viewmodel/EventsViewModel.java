package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;

public class EventsViewModel extends AndroidViewModel {

    // creating a new variable for Event repository.
    private AppRepository repository = null;

    // below line is to create a variable for live
    // data where all the Event are present.
    private LiveData<List<Event>> allEvents;

    // constructor for our view model.
    public EventsViewModel(@NonNull Application application) {
        super(application);

        // retrieve the appropriate repository from the app
        this.repository = ((CampusGuidebookApp)application).getAppRepository();

        // get a reference to the LiveData from the repository
        allEvents = this.repository.getAllEvents();
    }

    // below method is use to insert the data to our repository.
    public void insert(Event event) {
        repository.insert(event);
    }

    // below line is to update data in our repository.
    public void update(Event event) {
        repository.update(event);
    }

    // below line is to delete the data in our repository.
    public void delete(Event event) {
        repository.delete(event);
    }

}
