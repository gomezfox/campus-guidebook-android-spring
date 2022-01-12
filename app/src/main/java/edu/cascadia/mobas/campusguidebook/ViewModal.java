package edu.cascadia.mobas.campusguidebook;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewModal extends AndroidViewModel {

    // creating a new variable for Events repository.
    private EventsRepository repository;

    // below line is to create a variable for live
    // data where all the Events are present.
    private LiveData<List<EventsModal>> allEvents;

    // constructor for our view modal.
    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new EventsRepository(application);
        //allEvents = repository.getAllEvents();
    }

    // below method is use to insert the data to our repository.
    public void insert(EventsModal model) {
        repository.insert(model);
    }

    // below line is to update data in our repository.
    public void update(EventsModal model) {
        repository.update(model);
    }

    // below line is to delete the data in our repository.
    public void delete(EventsModal model) {
        repository.delete(model);
    }

    // below method is to delete all the Events in our list.
    //public void deleteAllEvents() {
    //    repository.deleteAllEvents();
    //}

    // below method is to get all the Events in our list.
    //public LiveData<List<EventsModal>> Events() {
    //    return allEvents;
    //}
}
