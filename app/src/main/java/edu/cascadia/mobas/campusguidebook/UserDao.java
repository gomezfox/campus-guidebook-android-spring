package edu.cascadia.mobas.campusguidebook;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import edu.cascadia.mobas.campusguidebook.data.model.UserModel;


@androidx.room.Dao
public interface UserDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(UserModel model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(UserModel model);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(UserModel model);

}

