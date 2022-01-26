package edu.cascadia.mobas.campusguidebook;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

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


}

