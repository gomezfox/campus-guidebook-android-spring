package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.ZonedDateTime;
import java.util.Map;

@Entity(tableName = "Sustainability")
public class Sustainability implements IEntity {

    // below line is to auto increment
    // id for each Sustainability.
    @PrimaryKey(autoGenerate = true)

    // entity field for our id.
    private Long id;

    // entity field for sustainability name
    @ColumnInfo(name = "name")
    private String name;

    // entity field for sustainability details
    @ColumnInfo(name = "details")
    private String details;

    @ColumnInfo(name = "image_uri")
    private String imageUri;

    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public Sustainability(Long id, String name, String details, String imageUri) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.imageUri = imageUri;
    }

    // on below lines we are creating
    // getter and setter methods.

    public void setName(String name) { this.name = name; }
    @Override
    public String getImageUri() {
        return this.imageUri;
    }

    @Override
    public Map<String, String> getProperties() {
        return null;
    }

    @Override
    public ZonedDateTime getLastUpdated() {
        return null;
    }

    @Override
    public int getUploadStatus() {
        return 0;
    }

    @Override
    public String getEntityName() {
        return this.getClass().getSimpleName();
    }

    public void setImageUri(String uri) {
        this.imageUri = uri;
    }

    public void setdetails(String details) {
        this.details = details;
    }
    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
