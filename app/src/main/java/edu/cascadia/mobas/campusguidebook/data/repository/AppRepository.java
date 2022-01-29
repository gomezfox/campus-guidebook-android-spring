package edu.cascadia.mobas.campusguidebook.data.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

import edu.cascadia.mobas.campusguidebook.ClubDao;
import edu.cascadia.mobas.campusguidebook.EventDao;
import edu.cascadia.mobas.campusguidebook.SustainabilityDao;
import edu.cascadia.mobas.campusguidebook.UserDao;
import edu.cascadia.mobas.campusguidebook.data.database.AppDatabase;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.model.User;

public class AppRepository {

    // instance variables for singleton
    private static AppRepository mAppRepository = null;
    private Application mApplication = null;
    private AppDatabase mAppDatabase= null;


    // private constructor to enforce singleton pattern
    private AppRepository() {}

    private AppRepository(Application app) {
        if (mAppRepository != null) return;
        mApplication = app;
        mAppDatabase = AppDatabase.getInstance(app);
        mAppRepository = this;
    }

    // returns the AppRepository instance, creating if necessary
    public static AppRepository getInstance(Application app) {
        if (mAppRepository == null) {
            mAppRepository = new AppRepository(app);
        }
        return mAppRepository;
    }

    // returns the AppRepository instance if it exists, otherwise null
    public static AppRepository getInstance() {
        return mAppRepository;
    }

    // METHODS TO RETURN LIVEDATA FROM APPDATABASE
    // returns a list of all events
    public LiveData<List<Event>> getAllEvents() {
        return mAppDatabase.EventDao().getAllEvents();
    };


    // returns a list of all users
    public LiveData<List<User>> getAllUsers() {
        return mAppDatabase.UserDao().getAllUsers();
    }


    // returns a list of all clubs
    public LiveData<List<Club>> getAllClubs() {
        return mAppDatabase.ClubDao().getAllClubs();
    };


    // returns a list of all sustainability
    public LiveData<List<Sustainability>> getAllSustainability() {
        return mAppDatabase.SustainabilityDao().getAllSustainability();
    };





    // creating a method to insert the data to our database.
    public void insert(Event model) {
        new InsertEventAsyncTask(mAppDatabase.EventDao()).execute(model);
    }

    // creating a method to update data in database.
    public void update(Event model) {
        new UpdateEventAsyncTask(mAppDatabase.EventDao()).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(Event model) {
        new DeleteEventAsyncTask(mAppDatabase.EventDao()).execute(model);
    }

    // we are creating a async task method to insert new Event.
    private static class InsertEventAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao Eventdao;

        private InsertEventAsyncTask(EventDao dao) {
            this.Eventdao = Eventdao;
        }

        @Override
        protected Void doInBackground(Event... events) {
            // below line is use to insert our model in dao.
            for (Event event : events) {
                Eventdao.insert(event);
            }
            return null;
        }
    }

    // we are creating a async task method to update our Event.
    private static class UpdateEventAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao Eventdao;

        private UpdateEventAsyncTask(EventDao Eventdao) {
            this.Eventdao = Eventdao;
        }

        @Override
        protected Void doInBackground(Event... models) {
            // below line is use to update
            // our model in dao.
            Eventdao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Event.
    private static class DeleteEventAsyncTask extends AsyncTask<Event, Void, Void> {
        private EventDao Eventdao;

        private DeleteEventAsyncTask(EventDao Eventdao) {
            this.Eventdao = Eventdao;
        }

        @Override
        protected Void doInBackground(Event... models) {
            // below line is use to delete
            // our Event model in dao.
            Eventdao.delete(models[0]);
            return null;
        }
    }

    // creating a method to insert the data to our database.
    public void insert(Club model) {
        new InsertClubAsyncTask(mAppDatabase.ClubDao()).execute(model);
    }

    // creating a method to update data in database.
    public void update(Club model) {
        new UpdateClubAsyncTask(mAppDatabase.ClubDao()).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(Club model) {
        new DeleteClubAsyncTask(mAppDatabase.ClubDao()).execute(model);
    }

    // we are creating a async task method to insert new Event.
    private static class InsertClubAsyncTask extends AsyncTask<Club, Void, Void> {
        private ClubDao Clubdao;

        private InsertClubAsyncTask(ClubDao Clubdao) {
            this.Clubdao = Clubdao;
        }

        @Override
        protected Void doInBackground(Club... model) {
            // below line is use to insert our model in dao.
            Clubdao.insert(model[0]);
            return null;
        }
    }
    // we are creating a async task method to update our Event.
    private static class UpdateClubAsyncTask extends AsyncTask<Club, Void, Void> {
        private ClubDao Clubdao;

        private UpdateClubAsyncTask(ClubDao Clubdao) {
            this.Clubdao = Clubdao;
        }

        @Override
        protected Void doInBackground(Club... models) {
            // below line is use to update
            // our model in dao.
            Clubdao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Event.
    private static class DeleteClubAsyncTask extends AsyncTask<Club, Void, Void> {
        private ClubDao Clubdao;

        private DeleteClubAsyncTask(ClubDao dao) {
            this.Clubdao = Clubdao;
        }

        @Override
        protected Void doInBackground(Club... models) {
            // below line is use to delete
            // our Event model in dao.
            Clubdao.delete(models[0]);
            return null;
        }
    }




    // creating a method to insert the data to our database.
    public void insert(User model) {
        new InsertUserAsyncTask(mAppDatabase.UserDao()).execute(model);
    }

    // creating a method to update data in database.
    public void update(User model) {
        new UpdateUserAsyncTask(mAppDatabase.UserDao()).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(User model) {
        new DeleteUserAsyncTask(mAppDatabase.UserDao()).execute(model);
    }

    // we are creating a async task method to insert new User.
    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao Userdao;

        private InsertUserAsyncTask(UserDao dao) {
            this.Userdao = Userdao;
        }

        @Override
        protected Void doInBackground(User... model) {
            // below line is use to insert our model in dao.
            Userdao.insert(model[0]);
            return null;
        }
    }
    // we are creating a async task method to update our User.
    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao Userdao;

        private UpdateUserAsyncTask(UserDao Userdao) {
            this.Userdao = Userdao;
        }

        @Override
        protected Void doInBackground(User... models) {
            // below line is use to update
            // our model in dao.
            Userdao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete User.
    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao Userdao;

        private DeleteUserAsyncTask(UserDao Userdao) {
            this.Userdao = Userdao;
        }

        @Override
        protected Void doInBackground(User... models) {
            // below line is use to delete
            // our User model in dao.
            Userdao.delete(models[0]);
            return null;
        }
    }


    // creating a method to insert the data to our database.
    public void insert(Sustainability model) {
        new InsertSustainabilityAsyncTask(mAppDatabase.SustainabilityDao()).execute(model);
    }

    // creating a method to update data in database.
    public void update(Sustainability model) {
        new UpdateSustainabilityAsyncTask(mAppDatabase.SustainabilityDao()).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(Sustainability model) {
        new DeleteSustainabilityAsyncTask(mAppDatabase.SustainabilityDao()).execute(model);
    }

    // we are creating a async task method to insert new Event.
    private static class InsertSustainabilityAsyncTask extends AsyncTask<Sustainability, Void, Void> {
        private SustainabilityDao Sustainabilitydao;

        private InsertSustainabilityAsyncTask(SustainabilityDao dao) {
            this.Sustainabilitydao = Sustainabilitydao;
        }

        @Override
        protected Void doInBackground(Sustainability... model) {
            // below line is use to insert our model in dao.
            Sustainabilitydao.insert(model[0]);
            return null;
        }
    }
    // we are creating a async task method to update our Event.
    private static class UpdateSustainabilityAsyncTask extends AsyncTask<Sustainability, Void, Void> {
        private SustainabilityDao Sustainabilitydao;

        private UpdateSustainabilityAsyncTask(SustainabilityDao Sustainabilitydao) {
            this.Sustainabilitydao = Sustainabilitydao;
        }

        @Override
        protected Void doInBackground(Sustainability... models) {
            // below line is use to update
            // our model in dao.
            Sustainabilitydao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Event.
    private static class DeleteSustainabilityAsyncTask extends AsyncTask<Sustainability, Void, Void> {
        private SustainabilityDao Sustainabilitydao;

        private DeleteSustainabilityAsyncTask(SustainabilityDao Sustainabilitydao) {
            this.Sustainabilitydao = Sustainabilitydao;
        }

        @Override
        protected Void doInBackground(Sustainability... models) {
            // below line is use to delete
            // our Event model in dao.
            Sustainabilitydao.delete(models[0]);
            return null;
        }
    }


}
