package edu.cascadia.mobas.campusguidebook.data.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.data.model.AppRepository;

public class EventViewModel extends AndroidViewModel {

    // creating a new variable for Event repository.
    private AppRepository repository = null;

    // below line is to create a variable for live
    // data where all the Event are present.
    private LiveData<List<Event>> allEvents;

    // constructor for our view model.
    public EventViewModel(@NonNull Application application) {
        super(application);

        this.repository = AppRepository.getInstance();
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
