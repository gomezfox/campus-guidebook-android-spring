package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Event_Table")
public class Event {
    // below line is to auto increment
    // id for each Event.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // below line is a variable
    // for Event name.
    private String EventName;

    // below line is use for
    // Event Description.
    private String Description;

    // below line is use
    // for Event Location.
    private String Location;

    // below line is use
    // for Event Date and Time.
    private String DateTime;

    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public Event(String EventName, String Description, String Location, String DateTime) {
        this.EventName = EventName;
        this.Description = Description;
        this.Location = Location;
        this.DateTime = DateTime;

    }

    // on below line we are creating
    // getter and setter methods.
    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        this.EventName = eventName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }
    public String getDateTime(){
        return DateTime;
    }
    public void setDateTime(String dateTime){
        this.DateTime = dateTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
