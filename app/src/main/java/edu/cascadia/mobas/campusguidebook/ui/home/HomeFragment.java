package edu.cascadia.mobas.campusguidebook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    // All UI behavior has moved from MainActivity to fragments
    // View initialization logic goes in onCreateView
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // Initialization logic beyond view initialization goes on onViewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Connect adapters
            // no adapters present on home fragment

        //Initialize ViewModel (and any other dependencies)
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Initialize properties of individual views, such as onClickListeners
        binding.cardViewHomeEvents.setOnClickListener(CardView -> {
            Navigation.findNavController(binding.cardViewHomeEvents)
                    .navigate(R.id.action_nav_home_to_nav_events);
        });
        binding.cardViewHomeInfo.setOnClickListener(CardView -> {
            Navigation.findNavController(binding.cardViewHomeClubs)
                    .navigate(R.id.action_nav_home_to_nav_info);
        });
        binding.cardViewHomeClubs.setOnClickListener(CardView -> {
                Navigation.findNavController(binding.cardViewHomeClubs)
                        .navigate(R.id.action_nav_home_to_nav_clubs);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}