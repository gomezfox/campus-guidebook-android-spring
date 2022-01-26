package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Club_Table")
public class ClubModel {
    // below line is to auto increment
    // id for each club.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // below line is a variable
    // for Event name.
    private String ClubName;


    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public ClubModel(String ClubName) {
        this.ClubName = ClubName;
    }

    // on below line we are creating
    // getter and setter methods.
    public String getClubName() {
        return ClubName;
    }

    public void setClubName(String ClubName) {
        this.ClubName = ClubName;
    }


    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
