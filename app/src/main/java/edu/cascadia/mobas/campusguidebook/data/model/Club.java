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
import edu.cascadia.mobas.campusguidebook.data.typeconverter.PropertyListTypeConverter;


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
    public Club(long id, String name, String details, String imageUri, String properties, ZonedDateTime lastUpdated) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.properties = PropertyListTypeConverter.toMap(properties);
        this.lastUpdated = lastUpdated;
    }

    // getter and setter methods.

    public long getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    @NonNull
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

    public String getImageUri() {
        return this.imageUri;
    }

    @Override
    public Map<String, String> getProperties() { return this.properties; }

    public void setProperties(Map<String, String> properties) { this.properties = properties; }

    public void setImageUri(String uri) {
        this.imageUri = uri;
    }

    public ZonedDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(ZonedDateTime updatedOn) {
        this.lastUpdated = updatedOn;
    }
}

