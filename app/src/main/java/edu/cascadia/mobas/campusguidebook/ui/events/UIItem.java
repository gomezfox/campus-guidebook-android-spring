package edu.cascadia.mobas.campusguidebook.ui.events;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.databinding.FragmentEventsBinding;
import edu.cascadia.mobas.campusguidebook.viewmodel.EventListViewModel;

public class UIItem extends androidx.fragment.app.Fragment {

    private EventListViewModel slideshowViewModel;
    private FragmentEventsBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(EventListViewModel.class);
//TODO: this may be needed. if not, clean this code
        binding = FragmentEventsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*CardView card1 = root.findViewById(R.id.card);


        card1.setOnClickListener(CardView -> {
            Navigation.findNavController(card1).navigate(R.id.fragment_Event_Info);
        });*/



        //final TextView textView = binding.spinner;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
        //    }
        //});
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}