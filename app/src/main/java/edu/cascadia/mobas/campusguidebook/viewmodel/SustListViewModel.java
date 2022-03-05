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
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.data.repository.AppRepository;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;
import edu.cascadia.mobas.campusguidebook.ui.Sustainability.UIItem;


@RequiresApi(api = Build.VERSION_CODES.O)
public class SustListViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = null;
    private final MediatorLiveData<List<UIItem>> mLiveSustList = new MediatorLiveData<List<UIItem>>();
    private ImageRepository mImageRepository = null;
    public SustListViewModel(@NonNull Application application) {
        super(application);
        // gets a reference to the repository
        mAppRepository = ((CampusGuidebookApp) application).getAppRepository();
        mImageRepository = ((CampusGuidebookApp) application).getImageRepository();

        // Observes the Sustainability list from the repository and emits a new one that also contains images
        mLiveSustList.addSource(mAppRepository.getAllSustainability(), Sustainability -> {
            List<UIItem> list = new ArrayList<UIItem>();
            for (Sustainability sustainability : Sustainability) {
                list.add(new UIItem(sustainability, mImageRepository.getImage(sustainability.getImageUri())));
            }
            mLiveSustList.setValue(list);
        });
    }

    // return a reference to the livedata containing all Sustianability and their images
    public LiveData<List<UIItem>> getAllSustainability() {
        return mLiveSustList;
    }
}

