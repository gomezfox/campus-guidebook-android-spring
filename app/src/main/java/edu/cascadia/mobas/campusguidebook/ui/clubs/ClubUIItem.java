package edu.cascadia.mobas.campusguidebook.ui.clubs;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import edu.cascadia.mobas.campusguidebook.data.model.Club;

// This POJO class combines a club entity with a livedata of its associated image
// TODO: this chooses composition. Should inheritance be considered?
public class ClubUIItem {

    private Club mClub;
    private LiveData<Drawable> mImage;

    public ClubUIItem(Club club, LiveData<Drawable> image) {
        mClub = club;
        mImage = image;
    }

    public Club getClub() {
        return mClub;
    }

    public void setClub(Club mClub) {
        this.mClub = mClub;
    }

    public LiveData<Drawable> getImage() {
        return mImage;
    }

    public void setImage(LiveData<Drawable> image) {
        this.mImage = image;
    }
}
