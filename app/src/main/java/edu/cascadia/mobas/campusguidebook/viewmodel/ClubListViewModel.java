package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private LiveData<List<Club>> mAllClubs;

    public ClubListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        // obtains the LiveData list of all clubs provided from the repository
        mAllClubs = mAppRepository.getAllClubs();
    }

    public LiveData<List<Club>> getAllClubs() {
        return mAllClubs;
    }
}

