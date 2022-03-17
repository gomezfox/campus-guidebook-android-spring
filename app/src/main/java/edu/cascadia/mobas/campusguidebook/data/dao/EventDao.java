package edu.cascadia.mobas.campusguidebook.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.data.model.Event;

@androidx.room.Dao
public interface EventDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(Event event);

    // below method is use to update
    // the data in our database.
    @Update
    void update(Event event);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(Event event);

    @Query("SELECT * FROM Event_Table")
    LiveData<List<Event>> getAllEvents();

    @Query("SELECT * FROM Event_Table WHERE id=:eventID")
    LiveData<Event> getEventByID(int eventID);

    @Query("SELECT COUNT(*) FROM Event_Table")
    int getEventCount();

}

