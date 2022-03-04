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

    protected void setTag(String tag) {
        this.TAG = tag;
    }
}














