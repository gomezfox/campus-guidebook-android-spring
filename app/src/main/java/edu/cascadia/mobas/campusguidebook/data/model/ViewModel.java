package edu.cascadia.mobas.campusguidebook.data.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewModel extends AndroidViewModel {

    // creating a new variable for Event repository.
    private AppRepository repository;

    // below line is to create a variable for live
    // data where all the Event are present.
    private LiveData<List<EventModel>> allEvent;

    // constructor for our view model.
    public ViewModel(@NonNull Application application) {
        super(application);

        //allEvent = repository.getAllEvent();
    }

    // below method is use to insert the data to our repository.
    public void insert(EventModel model) {
        repository.insert(model);
    }

    // below line is to update data in our repository.
    public void update(EventModel model) {
        repository.update(model);
    }

    // below line is to delete the data in our repository.
    public void delete(EventModel model) {
        repository.delete(model);
    }

    // below method is to delete all the Event in our list.
    //public void deleteAllEvent() {
    //    repository.deleteAllEvent();
    //}

    // below method is to get all the Event in our list.
    //public LiveData<List<EventModel>> Event() {
    //    return allEvent;
    //}
}
