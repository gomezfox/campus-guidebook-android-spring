package edu.cascadia.mobas.campusguidebook.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_Table")
public class UserModel {
    // below line is to auto increment
    // id for each User.
    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;

    // below line is a variable
    // for User name.
    private String UserName;

    // below line is a variable
    // for User password.
    private String Password;  //TODO: add some security like an encryption or something

    // below line is use for
    // User Subscriptions.
    private String Subscriptions;



    // below line we are creating constructor class.
    // inside constructor class we are not passing
    // our id because it is incrementing automatically
    public UserModel(String UserName, String Subscriptions, String Password) {
        this.UserName = UserName;
        this.Password = Password;
        this.Subscriptions = Subscriptions;


    }

    // on below line we are creating
    // getter and setter methods.
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSubscriptions() {
        return Subscriptions;
    }

    public void setSubscriptions(String Subscriptions) {
        this.Subscriptions = Subscriptions;
    }

    public int getId() {
        return id;
    }
    public void setId(int ID) {
        this.id = ID;
    }

}
