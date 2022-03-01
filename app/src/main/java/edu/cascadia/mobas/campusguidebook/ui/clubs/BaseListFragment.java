package edu.cascadia.mobas.campusguidebook.ui.clubs;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.IEntity;
import edu.cascadia.mobas.campusguidebook.viewmodel.MainActivityViewModel;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// ListFragment
// Base class for displaying a recyclerview for the provided type
public abstract class BaseListFragment<T extends IEntity> extends Fragment {

    private String TAG = "ListFragment";
    private MainActivityViewModel mViewModel;
    private BaseListAdapter<T> mBaseListAdapter;
    private LiveData<List<T>> mList = new MutableLiveData<>();

    protected abstract LiveData<List<T>> getList();

    protected MainActivityViewModel getViewModel() {
        return mViewModel;
    }

    protected void setTag(String tag) {
        this.TAG = tag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this.requireActivity()).get(MainActivityViewModel.class);
        mList = getList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_list, container, false);
        viewRoot.setTag(TAG);

        // RecyclerView setup
        RecyclerView recyclerView = viewRoot.findViewById(R.id.list_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false));
        /*
         RecyclerView.OnItemTouchListener listener =
                new SimpleListener<T>(mList);
        recyclerView.addOnItemTouchListener(listener);
        */
        BaseListAdapter<T> adapter = new BaseListAdapter<T>(mList.getValue(), mViewModel);
        recyclerView.setAdapter(adapter);

        // respond to changes in livedata
        mList.observe(this.getViewLifecycleOwner(), adapter::setList);
        return viewRoot;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
/*
    // This provides an accessible event listener for people with movement disorders
    // It records when a touch down occurs and afterwards responds to touch up when it occurs
    private  class SimpleListener<U> extends RecyclerView.SimpleOnItemTouchListener {
        boolean actionDown = false;
        LiveData<List<U>> itemList;

        public SimpleListener(LiveData<List<U>> list) {
            super();
            itemList = list;
        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    // record that a touch event has started
                    actionDown = true;
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    // respond if touch up event follows a touch down event
                    if (actionDown) {
                        actionDown = false;
                        // gets the view where the touch event finished
                        View child = rv.findChildViewUnder(e.getX(), e.getY());
                        if (child != null) {
                            // gets the index in the recyclerview row clicked
                            int position = rv.getChildAdapterPosition(child);
                            // test response
                            String name = mList.getValue().get(position).getName();
                            Log.d("Recycler", name);
                            Toast.makeText(rv.getContext(), name, Toast.LENGTH_LONG).show();
                            return true;
                        }
                    }
                }
            }
            // not the touch event we are looking for, so don't intercept it
            return false;
        }
    }
    */
}














