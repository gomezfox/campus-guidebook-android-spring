package edu.cascadia.mobas.campusguidebook.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.model.User;

@androidx.room.Dao
public interface SustainabilityDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(Sustainability sustainability);

    // below method is use to update
    // the data in our database.
    @Update
    void update(Sustainability sustainability);

    // below line is use to delete a
    // specific Sustainability in our database.
    @Delete
    void delete(Sustainability sustainability);

    @Query("SELECT * FROM Sustainability_Table")
    LiveData<List<Sustainability>> getAllSustainability();

    @Query("SELECT * FROM Sustainability_Table WHERE id=:sustainabilityID")
    LiveData<Sustainability> getSustainabilityById(int sustainabilityID);

    @Query("SELECT COUNT(*) FROM Sustainability_Table")
    int getSustainabilityCount();
}

