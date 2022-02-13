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
    public void set_SustainabilityName(String name) { this.sustainabilityName = name; }

    @ColumnInfo(name = "sustainability_description")
    private String sustainabilitydescription;
    public String get_SustainabilityDescription() {
        return sustainabilitydescription;
    }
    public void set_SustainabilityDescription(String name) { this.sustainabilitydescription = name; }

    @ColumnInfo(name = "sustainability_location")
    private String sustainabilitylocation;
    public String get_SustainabilityLocation() {
        return sustainabilitylocation;
    }
    public void set_SustainabilityLocation(String name) { this.sustainabilitylocation = name; }


    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically

    public Sustainability(String sustainabilityName, String sustainabilitydescription, String sustainabilitylocation) {
        this.sustainabilityName = sustainabilityName;
        this.sustainabilitydescription = sustainabilitydescription;
        this.sustainabilitylocation = sustainabilitylocation;
    }





    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
