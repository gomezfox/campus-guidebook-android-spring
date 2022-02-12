package edu.cascadia.mobas.campusguidebook.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SustainabilityList_ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SustainabilityList_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}