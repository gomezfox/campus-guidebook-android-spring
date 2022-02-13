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

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.ui.events.EventListAdapter;
import edu.cascadia.mobas.campusguidebook.viewmodel.EventListViewModel;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        View viewRoot = inflater.inflate(R.layout.fragment_event_list, container, false);
        viewRoot.setTag(TAG);

        // RecyclerView setup
        mRecyclerView = (RecyclerView) viewRoot.findViewById(R.id.fragment_event_list_item);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false));
        mEventList = mViewModel.getAllEvents();
        mEventListAdapter = new EventListAdapter(mEventList.getValue());
        mRecyclerView.setAdapter(mEventListAdapter);

        // Respond to changes in LiveData
        mEventList.observe(this, (mEventList) -> {
            List<Event> data = mEventList;
            mEventListAdapter.setData(data);
        });
        return viewRoot;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}