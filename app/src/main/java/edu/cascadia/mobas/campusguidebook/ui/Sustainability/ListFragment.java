package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.R;

import edu.cascadia.mobas.campusguidebook.viewmodel.SustListViewModel;

// SustsListFragment
// Displays the list of all Susts
@RequiresApi(api = Build.VERSION_CODES.O)
public class ListFragment extends Fragment {

    private static final String TAG = "SustListFragment";
    private SustListViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LiveData<List<SustUIItem>> mSustList = null;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SustListViewModel.class);
        mSustList = mViewModel.getAllSustainability();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_sust_list, container, false);
        viewRoot.setTag(TAG);

        // RecyclerView setup
        mRecyclerView = viewRoot.findViewById(R.id.sust_list_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false));
        mSustList = mViewModel.getAllSustainability();
        mListAdapter = new ListAdapter(mSustList.getValue(), mViewModel);
        mRecyclerView.setAdapter(mListAdapter);

        // Respond to changes in LiveData
        mSustList.observe(this.getViewLifecycleOwner(), (mSustList) -> mListAdapter.setList(mSustList));

        // return the inflated root view
        return viewRoot;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}