package edu.cascadia.mobas.campusguidebook;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import edu.cascadia.mobas.campusguidebook.data.model.ClubModel;

@androidx.room.Dao
public interface ClubDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(ClubModel model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(ClubModel model);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(ClubModel model);


}

