package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;

public class SustUIItem {

    private Sustainability mSustainability;
    private LiveData<Drawable> mImage;

    public SustUIItem(Sustainability sustainability, LiveData<Drawable> image) {
        mSustainability = sustainability;
        mImage = image;
    }

    public Sustainability getSustainability() {
        return mSustainability;
    }
    public void setSustainability(Sustainability pSustainability) {
        this.mSustainability = pSustainability;
    }

    public LiveData<Drawable> getImage() {
        return mImage;
    }
    public void setImage(LiveData<Drawable> image) {
        this.mImage = image;
    }
}
