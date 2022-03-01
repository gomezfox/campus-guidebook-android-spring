package edu.cascadia.mobas.campusguidebook.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.databinding.FragmentEventsBinding;
import edu.cascadia.mobas.campusguidebook.viewmodel.EventListViewModel;

public class EventFragment extends Fragment {

    private EventListViewModel slideshowViewModel;
    private FragmentEventsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(EventListViewModel.class);

        binding = FragmentEventsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView card1 = root.findViewById(R.id.card);
        Button addEventBtn = root.findViewById(R.id.addEventBtn);


        card1.setOnClickListener(CardView -> {
            Navigation.findNavController(card1).navigate(R.id.fragment_Event_Info);
        });

        addEventBtn.setOnClickListener(view -> {
            Navigation.findNavController(addEventBtn).navigate(R.id.addEventFragment);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}