package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.ColumnInfo;
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
    @ColumnInfo(name = "sustainability_name")
    private String sustainabilityName;


    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically

    public Sustainability(String sustainabilityName) {
        this.sustainabilityName = sustainabilityName;
    }

    // on below line we are creating
    // getter and setter methods.
    public String getSustainabilityName() {
        return sustainabilityName;
    }
    public void setSustainabilityName(String name) { this.sustainabilityName = name; }

    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
