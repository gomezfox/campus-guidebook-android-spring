package edu.cascadia.mobas.campusguidebook;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;


import edu.cascadia.mobas.campusguidebook.data.model.SustainabilityModel;

@androidx.room.Dao
public interface SustainabilityDao {

    // below method is use to
    // add data to database.
    @Insert
    void insert(SustainabilityModel model);

    // below method is use to update
    // the data in our database.
    @Update
    void update(SustainabilityModel model);

    // below line is use to delete a
    // specific Sustainability in our database.
    @Delete
    void delete(SustainabilityModel model);


}

