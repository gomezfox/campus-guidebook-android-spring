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

    @ColumnInfo(name = "sustainability_description")
    private String sustainabilitydescription;

    @ColumnInfo(name = "sustainability_location")
    private String sustainabilitylocation;


    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically

    public Sustainability(String sustainabilityName, String sustainabilitydescription, String sustainabilitylocation) {
        this.sustainabilityName = sustainabilityName;
        this.sustainabilitydescription = sustainabilitydescription;
        this.sustainabilitylocation = sustainabilitylocation;
    }

    // on below line we are creating
    // getter and setter methods.
    public String getSustainabilityName() {
        return sustainabilityName;
    }
    public void setSustainabilityName(String name) { this.sustainabilityName = name; }

    public String getSustainabilityDescription() {
        return sustainabilitydescription;
    }
    public void setSustainabilityDescription(String name) { this.sustainabilitydescription = name; }

    public String getSustainabilityLocation() {
        return sustainabilitylocation;
    }
    public void setsSustainabilityLocation(String name) { this.sustainabilitylocation = name; }

    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
