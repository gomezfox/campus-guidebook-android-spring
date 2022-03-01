package edu.cascadia.mobas.campusguidebook.ui.clubs;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.viewmodel.MainActivityViewModel;

public class ClubListFragment extends BaseListFragment<Club> {

    public ClubListFragment() {
        super();
        setTag("ClubListFragment");
    }

    @Override
    public LiveData<List<Club>> getList() {
        return ((MainActivityViewModel)getViewModel()).getAllClubs();
    }
}
