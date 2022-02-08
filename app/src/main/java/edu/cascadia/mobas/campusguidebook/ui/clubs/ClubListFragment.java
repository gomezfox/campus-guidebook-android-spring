package edu.cascadia.mobas.campusguidebook.ui.clubs;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Club;
import edu.cascadia.mobas.campusguidebook.viewmodel.ClubListViewModel;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * ClubsList Fragment
 * Displays the list of all clubs
 */
public class ClubListFragment extends Fragment {

    private static final String TAG = "ClubListFragment";
    private ClubListViewModel viewModel;
    private RecyclerView mRecyclerView;
    private ClubListAdapter mClubListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MutableLiveData<ArrayList<Club>> mClubList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ClubListViewModel.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_club_list, container, false);
        viewRoot.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) viewRoot.findViewById(R.id.club_list_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false));
        mClubList = viewModel.getAllClubs();
        mRecyclerView.setAdapter(new ClubListAdapter(mClubList));
        return viewRoot;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}