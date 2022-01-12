package edu.cascadia.mobas.campusguidebook;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@androidx.room.Dao
public interface Dao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(EventsModal model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(EventsModal model);

    // below line is use to delete a
    // specific Events in our database.
    @Delete
    void delete(EventsModal model);

    // on below line we are making query to
    // delete all Events from our database.
    //@Query("DELETE FROM Events_table")
    //void deleteAllEvents();

    // below line is to read all the Events from our database.
    // in this we are ordering our Events in ascending order
    // with our Events name.
    //@Query("SELECT * FROM Events_table ORDER BY courseName ASC")
    //LiveData<List<EventsModal>> getAllEvents();
}

