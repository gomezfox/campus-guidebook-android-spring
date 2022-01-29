package edu.cascadia.mobas.campusguidebook;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.model.User;


@androidx.room.Dao
public interface ClubDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(Club model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(Club model);

    // below line is use to delete a
    // specific Event in our database.
    @Delete
    void delete(Club model);

    @Query("SELECT * FROM Club")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM Club WHERE id=:clubID")
    LiveData<User> getUserById(int clubID);

    @Query("SELECT COUNT(*) FROM Club")
    int getClubCount();

}

