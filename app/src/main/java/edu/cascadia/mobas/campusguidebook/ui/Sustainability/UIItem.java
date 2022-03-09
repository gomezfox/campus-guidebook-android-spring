package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;

public class UIItem {

    private static LiveData<Drawable> mImage;
    private Sustainability mSustainability;


    public UIItem(Sustainability sustainability, LiveData<Drawable> image) {
        mSustainability = sustainability;
        mImage = image;
    }

    public Sustainability getSustainability() {
        return this.mSustainability;
    }
    public void setSustainability(Sustainability sustainability) {
        this.mSustainability = sustainability;
    }

    public LiveData<Drawable> getImage() { return this.mImage; }
    public void setImage(LiveData<Drawable> image) {
        this.mImage = image;
    }
}
