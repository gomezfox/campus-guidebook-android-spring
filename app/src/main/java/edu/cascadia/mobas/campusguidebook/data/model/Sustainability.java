package edu.cascadia.mobas.campusguidebook.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.ZonedDateTime;
import java.util.Map;

import edu.cascadia.mobas.campusguidebook.application.AppConfig;


@Entity(tableName = "Sustainability")
public class Sustainability implements IEntity {

    @Override @Ignore
    public String getEntityName() {
        return this.getClass().getSimpleName();
    }

    @PrimaryKey
    private Long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image_uri")
    private String imageUri;

    @ColumnInfo(name = "last_updated")
    ZonedDateTime lastUpdated;

    public Sustainability(Long id, String name, String description, String imageUri, ZonedDateTime lastUpdated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUri = imageUri;
        this.lastUpdated = ZonedDateTime.now(AppConfig.TIMEZONE);
    }

    // getter and setter methods.
    @Override public long getId() {
        return id;
    }
    @Override public String getName() {
        return this.name;
    }
    @Override public String getDescription() {
        return this.description;
    }
    @Override public String getImageUri() {
        return this.imageUri;
    }
    @Override public Map<String, String> getProperties() {
        return null;
    }
    @Override public ZonedDateTime getLastUpdated() {
        return null;
    }
    @Override public int getUploadStatus() {
        return 0;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) { this.name = name; }
    public void setImageUri(String uri) {
        this.imageUri = uri;
    }
    public void setDescription(String description) { this.description = description; }
}
