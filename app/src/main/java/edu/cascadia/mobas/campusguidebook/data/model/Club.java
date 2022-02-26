package edu.cascadia.mobas.campusguidebook.data.model;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import edu.cascadia.mobas.campusguidebook.AppConfig;

@RequiresApi(api = Build.VERSION_CODES.O)
@Entity(tableName = "Club_Table")
public class Club implements IEntity{

    @NonNull
    @PrimaryKey(autoGenerate = false)
    private long id = -1;

    @NonNull
    @ColumnInfo(name = "name")
    private String name = "";

    @ColumnInfo(name = "details")
    private String details;

    @ColumnInfo(name = "image_uri")
    private String imageUri;

    @ColumnInfo(name = "properties")
    private Map<String, String> properties;

    @ColumnInfo(name = "last_updated")
    private ZonedDateTime lastUpdated;

    // Constructor
    public Club(long id, @NonNull String name, String details, String imageUri,
                ZonedDateTime lastUpdated, Map<String, String> properties) {
        this.name = name;
        this.details = details;
        this.imageUri = imageUri;
        this.lastUpdated = (lastUpdated == null ? ZonedDateTime.now(AppConfig.TIMEZONE) : lastUpdated);
        this.properties = (properties == null ? new HashMap<String, String>() : properties);
    }

    // Convenience constructors for backwards compatibility
    @Ignore
    public Club(long id, String name, String details, String imageUri, String json, ZonedDateTime lastUpdated) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.properties =

    }

    @Ignore
    public Club(String name, String details, String clubAdvisor, String clubContact, String imageUri) {
        this(name, details, clubAdvisor, clubContact, imageUri,null);
    }

    // getter and setter methods.
    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String description) {
        this.details = description;
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

    public String getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(String uri) {
        this.imageUri = uri;
    }

    public ZonedDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(ZonedDateTime updatedOn) {
        this.lastUpdated = updatedOn;
    }

    public LiveData<Drawable> getImageDrawable() { return this.imageDrawable; }

    public void setImageDrawable(LiveData<Drawable> drawable) { this.imageDrawable = drawable; }

    public void clearImageDrawable() { this.imageDrawable = null; }
}

