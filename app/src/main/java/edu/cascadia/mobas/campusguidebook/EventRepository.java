package edu.cascadia.mobas.campusguidebook;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class EventRepository {
    // below line is the create a variable
    // for dao and list for all Event.
    private Dao dao;
    private LiveData<List<EventModal>> allEvent;

    // creating a constructor for our variables
    // and passing the variables to it.
    public EventRepository(Application application) {
        EventDatabase database = EventDatabase.getInstance(application);
        dao = database.Dao();

    }

    // creating a method to insert the data to our database.
    public void insert(EventModal model) {
        new InsertEventAsyncTask(dao).execute(model);
    }

    // creating a method to update data in database.
    public void update(EventModal model) {
        new UpdateEventAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(EventModal model) {
        new DeleteEventAsyncTask(dao).execute(model);
    }





    // we are creating a async task method to insert new Event.
    private static class InsertEventAsyncTask extends AsyncTask<EventModal, Void, Void> {
        private Dao dao;

        private InsertEventAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventModal... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update our Event.
    private static class UpdateEventAsyncTask extends AsyncTask<EventModal, Void, Void> {
        private Dao dao;

        private UpdateEventAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventModal... models) {
            // below line is use to update
            // our modal in dao.
            dao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Event.
    private static class DeleteEventAsyncTask extends AsyncTask<EventModal, Void, Void> {
        private Dao dao;

        private DeleteEventAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventModal... models) {
            // below line is use to delete
            // our Event modal in dao.
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
