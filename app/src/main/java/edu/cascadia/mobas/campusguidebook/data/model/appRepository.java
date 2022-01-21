package edu.cascadia.mobas.campusguidebook.data.model;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.ClubDao;
import edu.cascadia.mobas.campusguidebook.EventDao;

public class appRepository {
    // below line is the create a variable
    // for dao and list for all Event.
    private EventDao Eventdao;
    private LiveData<List<EventModel>> allEvent;


    // below line is the create a variable
    // for dao and list for all Club.
    private ClubDao Clubdao;
    private LiveData<List<ClubModel>> allClub;



    // creating a constructor for our variables
    // and passing the variables to it.
    public appRepository(Application application) {
        appDatabase database = appDatabase.getInstance(application);
        Eventdao = database.EventDao();

    }

    // creating a method to insert the data to our database.
    public void insert(EventModel model) {
        new InsertEventAsyncTask(Eventdao).execute(model);
    }

    // creating a method to update data in database.
    public void update(EventModel model) {
        new UpdateEventAsyncTask(Eventdao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(EventModel model) {
        new DeleteEventAsyncTask(Eventdao).execute(model);
    }

    // we are creating a async task method to insert new Event.
    private static class InsertEventAsyncTask extends AsyncTask<EventModel, Void, Void> {
        private EventDao Eventdao;

        private InsertEventAsyncTask(EventDao dao) {
            this.Eventdao = Eventdao;
        }

        @Override
        protected Void doInBackground(EventModel... model) {
            // below line is use to insert our model in dao.
            Eventdao.insert(model[0]);
            return null;
        }
    }
    // we are creating a async task method to update our Event.
    private static class UpdateEventAsyncTask extends AsyncTask<EventModel, Void, Void> {
        private EventDao Eventdao;

        private UpdateEventAsyncTask(EventDao Eventdao) {
            this.Eventdao = Eventdao;
        }

        @Override
        protected Void doInBackground(EventModel... models) {
            // below line is use to update
            // our model in dao.
            Eventdao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Event.
    private static class DeleteEventAsyncTask extends AsyncTask<EventModel, Void, Void> {
        private EventDao Eventdao;

        private DeleteEventAsyncTask(EventDao Eventdao) {
            this.Eventdao = Eventdao;
        }

        @Override
        protected Void doInBackground(EventModel... models) {
            // below line is use to delete
            // our Event model in dao.
            Eventdao.delete(models[0]);
            return null;
        }
    }

    // creating a method to insert the data to our database.
    public void insert(ClubModel model) {
        new InsertClubAsyncTask(Clubdao).execute(model);
    }

    // creating a method to update data in database.
    public void update(ClubModel model) {
        new UpdateClubAsyncTask(Clubdao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(ClubModel model) {
        new DeleteClubAsyncTask(Clubdao).execute(model);
    }

    // we are creating a async task method to insert new Event.
    private static class InsertClubAsyncTask extends AsyncTask<ClubModel, Void, Void> {
        private ClubDao Clubdao;

        private InsertClubAsyncTask(ClubDao Clubdao) {
            this.Clubdao = Clubdao;
        }

        @Override
        protected Void doInBackground(ClubModel... model) {
            // below line is use to insert our model in dao.
            Clubdao.insert(model[0]);
            return null;
        }
    }
    // we are creating a async task method to update our Event.
    private static class UpdateClubAsyncTask extends AsyncTask<ClubModel, Void, Void> {
        private ClubDao Clubdao;

        private UpdateClubAsyncTask(ClubDao Clubdao) {
            this.Clubdao = Clubdao;
        }

        @Override
        protected Void doInBackground(ClubModel... models) {
            // below line is use to update
            // our model in dao.
            Clubdao.update(models[0]);
            return null;
        }
    }
    // we are creating a async task method to delete Event.
    private static class DeleteClubAsyncTask extends AsyncTask<ClubModel, Void, Void> {
        private ClubDao Clubdao;

        private DeleteClubAsyncTask(EventDao dao) {
            this.Clubdao = Clubdao;
        }

        @Override
        protected Void doInBackground(ClubModel... models) {
            // below line is use to delete
            // our Event model in dao.
            Clubdao.delete(models[0]);
            return null;
        }
    }


}
