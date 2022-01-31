package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sustainability_Table")
public class Sustainability {
    // below line is to auto increment
    // id for each Sustainability.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // below line is a variable
    // for Event name.
    private String SustainabilityName;


    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public Sustainability(String SustainabilityName) {
        this.SustainabilityName = SustainabilityName;
    }

    // on below line we are creating
    // getter and setter methods.
    public String getSustainabilityName() {
        return SustainabilityName;
    }

    public void setSustainabilityName(String SustainabilityName) {
        this.SustainabilityName = SustainabilityName;
    }


    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
