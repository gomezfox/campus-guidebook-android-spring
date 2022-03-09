package edu.cascadia.mobas.campusguidebook.ui.events;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import edu.cascadia.mobas.campusguidebook.data.model.Event;

public class UIItem {

    private Event mEvent;
    private LiveData<Drawable> mImage;

    public UIItem(Event event, LiveData<Drawable> image) {
        mEvent = event;
        mImage = image;
    }

    public Event getEvent() {
        return this.mEvent;
    }

    public void setEvent(Event mEvent) {
        this.mEvent = mEvent;
    }

    public LiveData<Drawable> getImage() {
        return this.mImage;
    }

    public void setImage(LiveData<Drawable> image) {
        this.mImage = image;
    }
}