package edu.cascadia.mobas.campusguidebook.ui.events;

import androidx.lifecycle.LiveData;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.ui.BaseListFragment;

import androidx.navigation.Navigation;

import java.util.List;


// EventListFragment
// Displays the list of all Events
public class EventListFragment extends BaseListFragment<Event> {

    @Override
    protected LiveData<List<Event>> getList() {
        return getViewModel().getAllEvents();
    }

    @Override
    protected void itemClicked(Event item) {
        getViewModel().setDetailsItem(item);
        Navigation.findNavController(getRootView()).navigate(R.id.nav_event_details);
    }

    @Override
    protected void onClickFloatingActionButton() {
        Log.d("MADE IT THIS FAR", "SEE WHAT HAPPENS");
        Navigation.findNavController(getRootView()).navigate(R.id.action_nav_events_to_addEventFragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        if (getViewModel().isAdmin()) {
            getFloatingActionButton().show();
        }
        return root;
    }
}
