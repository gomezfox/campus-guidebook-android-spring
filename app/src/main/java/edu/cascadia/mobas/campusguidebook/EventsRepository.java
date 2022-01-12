package edu.cascadia.mobas.campusguidebook;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class EventsRepository {
    // below line is the create a variable
    // for dao and list for all Events.
    private Dao dao;
    private LiveData<List<EventsModal>> allEvents;

    // creating a constructor for our variables
    // and passing the variables to it.
    public EventsRepository(Application application) {
        EventsDatabase database = EventsDatabase.getInstance(application);
        dao = database.Dao();
        //allCourses = dao.getAllEvents();
    }

    // creating a method to insert the data to our database.
    public void insert(EventsModal model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    // creating a method to update data in database.
    public void update(EventsModal model) {
        new UpdateCourseAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(EventsModal model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the courses.
    //public void deleteAllCourses() {
    //    new DeleteAllCoursesAsyncTask(dao).execute();
    //}

    // below method is to read all the courses.
    //public LiveData<List<EventsModal>> getAllEvents() {
    //    return allEvents;
    //}

    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<EventsModal, Void, Void> {
        private Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventsModal... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update our Events.
    private static class UpdateCourseAsyncTask extends AsyncTask<EventsModal, Void, Void> {
        private Dao dao;

        private UpdateCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventsModal... models) {
            // below line is use to update
            // our modal in dao.
            dao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete Events.
    private static class DeleteCourseAsyncTask extends AsyncTask<EventsModal, Void, Void> {
        private Dao dao;

        private DeleteCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(EventsModal... models) {
            // below line is use to delete
            // our Events modal in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete all Events.
    private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllCoursesAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            //dao.deleteAllEvents();
            return null;
        }
    }
}
