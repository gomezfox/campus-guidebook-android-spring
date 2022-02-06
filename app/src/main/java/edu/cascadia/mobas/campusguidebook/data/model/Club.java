package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.ZonedDateTime;

@Entity(tableName = "Club_Table")
public class Club {
    // below line is to auto increment
    // id for each club.
    @PrimaryKey(autoGenerate = true)

    // field for the club id.
    private int id;

    @ColumnInfo(name = "club_name")
    private String clubName;

    @ColumnInfo(name = "club_description")
    private String clubDescription;

    @ColumnInfo(name = "club_advisor")
    private String clubAdvisor;

    @ColumnInfo(name = "club_contact")
    private String clubContact;

    @ColumnInfo(name = "image_uri")
    private String imageUri;

    @ColumnInfo(name = "last_updated")
    private ZonedDateTime lastUpdated;



    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public Club(String clubName, String clubDescription, String clubAdvisor, String clubContact) {
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.clubAdvisor = clubAdvisor;
        this.clubContact = clubContact;
    }

    // on below line we are creating
    // getter and setter methods.

    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

    public String getClubName() {
        return clubName;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return this.clubDescription;
    }
    public void setClubDescription(String description) {
        this.clubDescription = description;
    }

    public String getClubAdvisor() {
        return this.clubAdvisor;
    }
    public void setClubAdvisor(String advisor) {
        this.clubAdvisor = advisor;
    }

    public String getClubContact() {
        return this.clubContact;
    }
    public void setClubContact(String contact) {
        this.clubContact = contact;
    }

    public String getImageUri() { return this.imageUri; };
    public void setImageUri(String uri) { this.imageUri = uri; };

    public ZonedDateTime getLastUpdated() { return this.lastUpdated; }
    public void setLastUpdated(ZonedDateTime updatedOn) { this.lastUpdated = updatedOn; }


}

