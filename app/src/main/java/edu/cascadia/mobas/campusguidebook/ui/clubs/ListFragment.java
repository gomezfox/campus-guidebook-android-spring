package edu.cascadia.mobas.campusguidebook.ui.clubs;

import androidx.lifecycle.LiveData;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.data.model.Club;

public class ClubListFragment extends BaseListFragment<Club> {
    @Override
    public LiveData<List<Club>> getList() {
        return getViewModel().getAllClubs();
    }
}
