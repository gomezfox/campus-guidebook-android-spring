package edu.cascadia.mobas.campusguidebook;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.data.model.User;


@androidx.room.Dao
public interface UserDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(User model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(User model);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(User model);

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM User WHERE id=:userID")
    LiveData<User> getUserById(int userID);

    @Query("SELECT COUNT(*) FROM User")
    int getUserCount();

}

