package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;
import edu.cascadia.mobas.campusguidebook.viewmodel.MainActivityViewModel;


public class DetailsFragment extends Fragment {


//    public DetailsFragment() {
//        // Required empty public constructor
//    }

    private MainActivityViewModel mViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this.requireActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.sust_view_details, container, false);
        CardView buttonBar = root.findViewById(R.id.cardview_button_bar);
        Sustainability item = (Sustainability)(mViewModel.getDetailsItem());
        ImageView image = root.findViewById(R.id.imageview_details);
        Button datetime = root.findViewById(R.id.button_datetime);
        Button location = root.findViewById(R.id.button_location);
        TextView heading = root.findViewById(R.id.textview_heading);
        TextView description = root.findViewById(R.id.textview_description);

        buttonBar.setVisibility(View.GONE);

        String imageUri = item.getImageUri();
        LiveData<Drawable> drawableLiveData = mViewModel.getImageFromUri(imageUri);
        drawableLiveData.observe(getViewLifecycleOwner(), image::setImageDrawable);

        heading.setText(item.getName());
        description.setText(item.getDetails());

        return root;
    }
}