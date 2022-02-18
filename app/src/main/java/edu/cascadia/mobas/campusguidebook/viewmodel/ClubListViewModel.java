package edu.cascadia.mobas.campusguidebook.viewmodel;

import android.app.Application;
import android.graphics.drawable.Drawable;
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
import edu.cascadia.mobas.campusguidebook.ui.clubs.ClubUIItem;


@RequiresApi(api = Build.VERSION_CODES.O)
public class ClubListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private final MediatorLiveData<List<ClubUIItem>> mLiveClubList = new MediatorLiveData<List<ClubUIItem>>();
    private ImageRepository mImageRepository = null;
    public ClubListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        mImageRepository = ((CampusGuidebookApp) application).getImageRepository();

        // Observes the club list from the repository and emits a new one that also contains images
        mLiveClubList.addSource(mAppRepository.getAllClubs(), clubs -> {
            List<ClubUIItem> list = new ArrayList<ClubUIItem>();
            for (Club club : clubs) {
                list.add(new ClubUIItem(club, mImageRepository.getImage(club.getImageUri())));
            }
            mLiveClubList.setValue(list);
        });
    }

    // return a reference to the livedata containing all clubs and their images
    public LiveData<List<ClubUIItem>> getAllClubs() {
        return mLiveClubList;
    }
}

