package edu.cascadia.mobas.campusguidebook;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

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

    @Query("SELECT * FROM User_Table")
    LiveData<List<UserModel>> getAllUsers();

    @Query("SELECT * FROM User_Table WHERE id=:userID")
    LiveData<UserModel> getUserById(int userID);

    @Query("SELECT COUNT(*) FROM User_Table")
    int getUserCount();

}

