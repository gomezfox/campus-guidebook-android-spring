package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_Table")
public class User {
    // below line is to auto increment
    // id for each User.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // below line is a variable
    // for User name.
    @ColumnInfo(name = "user_name")
    private String userName;

    // below line is a variable
    // for User password.
    private String password;  //TODO: add some security like an encryption or something

    // below line is use for
    // User Subscriptions.
    private String subscriptions;

    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public User(String userName, String subscriptions, String password) {
        this.userName = userName;
        this.password = password;
        this.subscriptions = subscriptions;
    }

    // on below line we are creating
    // getter and setter methods.
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscriptions() {
        return subscriptions;
    }
    public void setSubscriptions(String subscriptions) {
        this.subscriptions = subscriptions;
    }

    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
