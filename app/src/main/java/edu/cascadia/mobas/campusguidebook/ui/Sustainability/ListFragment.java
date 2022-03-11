package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;


import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.ui.BaseListFragment;



public class ListFragment extends BaseListFragment<Sustainability> {
    @Override
    public LiveData<List<Sustainability>> getList() {
        return getViewModel().getAllSustainability();
    }

    @Override
    protected void itemClicked(Sustainability item) {
        Log.d("Clicked", item.getName());
    }

}