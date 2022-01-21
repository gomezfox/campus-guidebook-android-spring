package edu.cascadia.mobas.campusguidebook.data.model;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.Dao;
import edu.cascadia.mobas.campusguidebook.EventModel;

public class EventRepository {
    // below line is the create a variable
    // for dao and list for all Event.
    private Dao dao;
    private LiveData<List<EventModel>> allEvent;

    // creating a constructor for our variables
    // and passing the variables to it.
    public EventRepository(Application application) {
        EventDatabase database = EventDatabase.getInstance(application);
        dao = database.Dao();

    }

    // creating a method to insert the data to our database.
    public void insert(EventModel model) {
        new InsertEventAsyncTask(dao).execute(model);
    }

    // creating a method to update data in database.
    public void update(EventModel model) {
        new UpdateEventAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(EventModel model) {
        new DeleteEventAsyncTask(dao).execute(model);
    }





    // we are creating a async task method to insert new Event.
    private static class InsertEventAsyncTask extends AsyncTask<EventModel, Void, Void> {
        private Dao dao;

        private InsertEventAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventModel... model) {
            // below line is use to insert our model in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update our Event.
    private static class UpdateEventAsyncTask extends AsyncTask<EventModel, Void, Void> {
        private Dao dao;

        private UpdateEventAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventModel... models) {
            // below line is use to update
            // our model in dao.
            dao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Event.
    private static class DeleteEventAsyncTask extends AsyncTask<EventModel, Void, Void> {
        private Dao dao;

        private DeleteEventAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventModel... models) {
            // below line is use to delete
            // our Event model in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete all Event.
    private static class DeleteAllEventAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllEventAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
