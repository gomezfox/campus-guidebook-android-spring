package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private MutableLiveData<ArrayList<Club>>mClubListLiveData
            = new MutableLiveData<ArrayList<Club>>();

    public ClubListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        // and use it to set the value of the LiveData
        mClubListLiveData.setValue((ArrayList<Club>)mAppRepository.getAllClubs().getValue());
    }

    public MutableLiveData<ArrayList<Club>> getAllClubs() {
        return mClubListLiveData;
    }
    public MutableLiveData<ArrayList<Club>> searchPost(String query) {
        // add a search query to the DAO and the repository
        return new MutableLiveData<ArrayList<Club>>();
    }
}

