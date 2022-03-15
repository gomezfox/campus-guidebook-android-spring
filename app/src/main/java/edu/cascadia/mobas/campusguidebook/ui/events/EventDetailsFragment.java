package edu.cascadia.mobas.campusguidebook.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.LinkedHashMap;

import edu.cascadia.mobas.campusguidebook.ui.BaseDetailsFragment;

public class EventDetailsFragment extends BaseDetailsFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        LinkedHashMap<String, String> properties = new LinkedHashMap<>(getItem().getProperties());

        properties.forEach(this::addDetail);

        return root;
    }
}
