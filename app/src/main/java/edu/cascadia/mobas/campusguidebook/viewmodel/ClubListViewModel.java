package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.CampusGuidebookApp;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;
import edu.cascadia.mobas.campusguidebook.ui.clubs.UIItem;


@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private final MediatorLiveData<List<UIItem>> mLiveClubList = new MediatorLiveData<List<UIItem>>();
    private ImageRepository mImageRepository = null;
    public ClubListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        mImageRepository = ((CampusGuidebookApp) application).getImageRepository();

        // Observes the club list from the repository and emits a new one that also contains images
        mLiveClubList.addSource(mAppRepository.getAllClubs(), clubs -> {
            List<UIItem> list = new ArrayList<UIItem>();
            for (Club club : clubs) {
                list.add(new UIItem(club, mImageRepository.getImage(club.getImageUri())));
            }
            mLiveClubList.setValue(list);
        });
    }

    // return a reference to the livedata containing all clubs and their images
    public LiveData<List<UIItem>> getAllClubs() {
        return mLiveClubList;
    }
}

