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
    void insert(EventModal model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(EventModal model);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(EventModal model);


}

