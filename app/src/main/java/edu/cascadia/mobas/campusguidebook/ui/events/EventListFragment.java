package edu.cascadia.mobas.campusguidebook.ui.events;

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
import android.widget.Button;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.databinding.FragmentEventListBinding;
import edu.cascadia.mobas.campusguidebook.ui.events.EventListAdapter;
import edu.cascadia.mobas.campusguidebook.viewmodel.EventListViewModel;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


// EventListFragment
// Displays the list of all Events
public class EventListFragment extends Fragment {

    private static final String TAG = "EventListFragment";
    private EventListViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private EventListAdapter mEventListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LiveData<List<Event>> mEventList = null;
    private FragmentEventListBinding mBinding;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EventListViewModel.class);
        mEventList = mViewModel.getAllEvents();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentEventListBinding.inflate(inflater, container,false);

        // RecyclerView setup
        mRecyclerView = mBinding.recyclerView;

        mRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false));
        mEventListAdapter = new EventListAdapter(mEventList.getValue());
        mRecyclerView.setAdapter(mEventListAdapter);

        // Respond to changes in LiveData
        mEventList.observe(getViewLifecycleOwner(), (mEventList) -> {
            mEventListAdapter.setData(mEventList);
        });

        FloatingActionButton addEventBtn = mBinding.getRoot().findViewById(R.id.floatingActionButton);
        addEventBtn.setOnClickListener(view -> {
            Navigation.findNavController(addEventBtn).navigate(R.id.addEventFragment);
        });

        return mBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}