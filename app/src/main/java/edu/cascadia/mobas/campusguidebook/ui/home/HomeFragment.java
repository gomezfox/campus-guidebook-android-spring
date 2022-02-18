package edu.cascadia.mobas.campusguidebook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        CardView cardViewEvents = root.findViewById(R.id.cardview_home_events);

        cardViewEvents.setOnClickListener(CardView -> {
            Navigation.findNavController(cardViewEvents).navigate(R.id.nav_events);
        });

        CardView cardViewSustainability = root.findViewById(R.id.cardview_home_sustainability);

        cardViewSustainability.setOnClickListener(CardView -> {
            Navigation.findNavController(cardViewSustainability).navigate(R.id.nav_info);
        });

        CardView cardViewClubs = root.findViewById(R.id.cardview_home_clubs);

        cardViewClubs.setOnClickListener(CardView -> {
            Navigation.findNavController(cardViewClubs).navigate(R.id.action_nav_home_to_nav_club_list);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}