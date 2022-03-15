package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_Table")
public class User {

    // id for each User.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // for User name.
    @ColumnInfo(name = "user_name")
    private String userName;

    // for User password.
    private String password;

    // User Subscriptions.
    private String subscriptions;

    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public User(String userName, String subscriptions, String password) {
        this.userName = userName;
        this.password = password; //TODO: Salt and Hash
        this.subscriptions = subscriptions;
    }

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
