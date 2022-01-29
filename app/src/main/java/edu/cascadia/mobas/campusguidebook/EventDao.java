package edu.cascadia.mobas.campusguidebook;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.data.model.EventModel;

@androidx.room.Dao
public interface EventDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(EventModel model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(EventModel model);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(EventModel model);

    @Query("SELECT * FROM Event_Table")
    LiveData<List<EventModel>> getAllEvents();

    @Query("SELECT * FROM Event_Table WHERE id=:eventID")
    LiveData<List<EventModel>> getEventByID(int eventID);

    @Query("SELECT COUNT(*) FROM Event_Table")
    int getEventCount();

}

