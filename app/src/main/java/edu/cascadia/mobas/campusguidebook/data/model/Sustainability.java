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


    @ColumnInfo(name = "sustainability_name")
    private String sustainabilityName;
    public String getSustainabilityName() { return sustainabilityName; }
    public void setSustainabilityName(String name) { this.sustainabilityName = name; }

    @ColumnInfo(name = "sustainability_description")
    private String sustainabilityDescription;
    public String getSustainabilityDescription() {
        return sustainabilityDescription;
    }
    public void setSustainabilityDescription(String name) { this.sustainabilityDescription = name; }

    @ColumnInfo(name = "sustainability_location")
    private String sustainabilityLocation;
    public String getSustainabilityLocation() {
        return sustainabilityLocation;
    }
    public void setSustainabilityLocation(String name) { this.sustainabilityLocation = name; }


    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically

    public Sustainability(String sustainabilityName, String sustainabilityDescription, String sustainabilityLocation) {
        this.sustainabilityName = sustainabilityName;
        this.sustainabilityDescription = sustainabilityDescription;
        this.sustainabilityLocation = sustainabilityLocation;
    }





    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
