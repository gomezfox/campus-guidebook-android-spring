package edu.cascadia.mobas.campusguidebook.data.dao;

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
   void insert(User user);

    // below method is use to update
    // the data in our database.
    @Update
    void update(User user);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(User user);

    @Query("SELECT * FROM User_Table")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM User_Table WHERE id=:userID")
    LiveData<User> getUserById(int userID);

    @Query("SELECT COUNT(*) FROM User_Table")
    int getUserCount();

}

