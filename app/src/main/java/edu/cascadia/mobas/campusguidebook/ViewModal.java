package edu.cascadia.mobas.campusguidebook;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewModal extends AndroidViewModel {

    // creating a new variable for Event repository.
    private EventRepository repository;

    // below line is to create a variable for live
    // data where all the Event are present.
    private LiveData<List<EventModal>> allEvent;

    // constructor for our view modal.
    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new EventRepository(application);
        //allEvent = repository.getAllEvent();
    }

    // below method is use to insert the data to our repository.
    public void insert(EventModal model) {
        repository.insert(model);
    }

    // below line is to update data in our repository.
    public void update(EventModal model) {
        repository.update(model);
    }

    // below line is to delete the data in our repository.
    public void delete(EventModal model) {
        repository.delete(model);
    }

    // below method is to delete all the Event in our list.
    //public void deleteAllEvent() {
    //    repository.deleteAllEvent();
    //}

    // below method is to get all the Event in our list.
    //public LiveData<List<EventModal>> Event() {
    //    return allEvent;
    //}
}
