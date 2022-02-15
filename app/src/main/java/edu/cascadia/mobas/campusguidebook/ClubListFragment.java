package edu.cascadia.mobas.campusguidebook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClubListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClubListFragment extends Fragment {

    public ClubListFragment() {
        // Required empty public constructor
    }

    // TODO: Determine if parameters are useful and include them if so
    public static ClubListFragment newInstance() {
        ClubListFragment fragment = new ClubListFragment();
        Bundle args = new Bundle();
        // Any parameter based arguments for returning the fragment instance go here
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // load the arguments into variables if they exist
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club_list, container, false);
    }
}