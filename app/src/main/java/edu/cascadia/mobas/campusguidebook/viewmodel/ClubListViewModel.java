package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private final MediatorLiveData<List<Club>> mLiveClubList = new MediatorLiveData<List<Club>>();

    public ClubListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        // Adds repository source for textual live data
        mLiveClubList.addSource(mAppRepository.getAllClubs(), value -> {
            mLiveClubList.setValue(value);
        });
        //TODO: Add a source and observe image data
    }

    public LiveData<List<Club>> getAllClubs() {
        return mLiveClubList;
    }

}

