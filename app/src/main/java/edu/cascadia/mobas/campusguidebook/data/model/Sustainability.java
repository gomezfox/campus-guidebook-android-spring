package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sustainability_Table")
public class Sustainability {

    // below line is to auto increment
    // id for each Sustainability.
    @PrimaryKey(autoGenerate = true)

    // entity field for our id.
    private int id;

    // entity field for sustainability name
    @ColumnInfo(name = "sustainability_name")
    private String sustainabilityName;

    // entity field for sustainability description
    @ColumnInfo(name = "sustainability_description")
    private String sustainabilityDescription;

    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public Sustainability(String sustainabilityName, String sustainabilityDescription) {
        this.sustainabilityName = sustainabilityName;
        this.sustainabilityDescription = sustainabilityDescription;
    }

    // on below lines we are creating
    // getter and setter methods.
    public String getSustainabilityName() {
        return sustainabilityName;
    }
    public void setSustainabilityName(String name) { this.sustainabilityName = name; }

    public String getSustainabilityDescription() {
        return sustainabilityDescription;
    }

    public void setSustainabilityDescription(String sustainabilityDescription) {
        this.sustainabilityDescription = sustainabilityDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

}
