package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import java.util.List;

import androidx.navigation.Navigation;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.ui.BaseListFragment;



public class ListFragment extends BaseListFragment<Sustainability> {
    @Override
    public LiveData<List<Sustainability>> getList() {
        return getViewModel().getAllSustainability();
    }

    @Override
    protected void itemClicked(Sustainability item) {
        getViewModel().setDetailsItem(item);
        Navigation.findNavController(getRootView()).navigate(R.id.nav_sust_details);
    }

    //protected void itemClicked(Sustainability item) {
    //    Log.d("Clicked", item.getName());
    //}

}