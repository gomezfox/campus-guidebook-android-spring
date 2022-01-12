package edu.cascadia.mobas.campusguidebook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentWetlandsViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;

    public FragmentWetlandsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is wetlands fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}