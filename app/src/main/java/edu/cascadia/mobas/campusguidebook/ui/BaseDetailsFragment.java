package edu.cascadia.mobas.campusguidebook.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.IEntity;
import edu.cascadia.mobas.campusguidebook.viewmodel.MainActivityViewModel;


public abstract class BaseDetailsFragment extends Fragment {

    private View mViewRoot = null;
    private ImageView mImageView = null;
    private TextView mHeading = null;
    private TextView mDescription = null;
    private Button mLeftButton = null;
    private Button mRightButton = null;
    private CardView mButtonBar = null;
    private LinearLayout  detailsLayout = null;
    private LiveData<Drawable> mLiveDrawable = null;
    private MainActivityViewModel mViewModel = null;
    private FloatingActionButton mFloatingActionButton = null;
    private IEntity mItem = null;

    public BaseDetailsFragment() { }

    // used to add rows of details in Label:  Value format
    public void addDetail(String label, String value) {
        if (detailsLayout == null) return;
        View row = getLayoutInflater().inflate(R.layout.details_row, detailsLayout, false);
        TextView textViewLabel = row.findViewById(R.id.textview_detail_label);
        TextView textViewValue = row.findViewById(R.id.textview_detail_value);
        textViewLabel.setText(label);
        textViewValue.setText(value);
        detailsLayout.addView(row);
    }

    // use to respond to clicks on the button bar
    public void onClickLeftButton() { }
    public void onClickRightButton() { }
    public void onClickFloatingActionButton() { }
    public IEntity getItem() { return mItem; }

    // fragment handling
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this.requireActivity()).get(MainActivityViewModel.class);
        mItem = mViewModel.getDetailsItem();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater  inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        View mViewRoot = inflater.inflate(R.layout.details_view, container, false);

        // Get references to views
        mImageView = mViewRoot.findViewById(R.id.imageview_details);
        mHeading = mViewRoot.findViewById(R.id.textview_heading);
        mDescription = mViewRoot.findViewById(R.id.textview_description);
        mLeftButton = mViewRoot.findViewById(R.id.button_left);
        mRightButton = mViewRoot.findViewById(R.id.button_right);
        mButtonBar = mViewRoot.findViewById(R.id.cardview_button_bar);
        detailsLayout = mViewRoot.findViewById(R.id.layout_details_list);
        mFloatingActionButton = mViewRoot.findViewById(R.id.floatingActionButton);

        // Populate basic fields and image
        mLiveDrawable = mViewModel.getImageFromUri(mItem.getImageUri());
        mLiveDrawable.observe(getViewLifecycleOwner(), mImageView::setImageDrawable);
        mHeading.setText(mItem.getName());
        mDescription.setText(mItem.getDescription());
        mButtonBar.setVisibility(View.GONE);
        mLeftButton.setOnClickListener(v -> onClickLeftButton());
        mRightButton.setOnClickListener(v -> onClickRightButton());
        mFloatingActionButton.setOnClickListener(v -> onClickFloatingActionButton());
        return mViewRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mViewRoot = null;
        mImageView = null;
        mHeading = null;
        mDescription = null;
        mLeftButton = null;
        mRightButton = null;
        mButtonBar = null;
        mFloatingActionButton = null;
        detailsLayout = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel = null;
    }

    // convenience functions to control the views on the fragment
    public void setHeading(String heading) {
        if (mHeading == null) return;
        mHeading.setText(heading);
    }

    public void setDescription(String description) {
        if (mDescription == null) return;
        mDescription.setText(description);
    }

    public void setLeftButtonText(String text) {
        if (mLeftButton == null) return;
        mLeftButton.setText(text);
    }

    public void setRightButtonText(String text) {
        if (mRightButton == null) return;
        mRightButton.setText(text);
    }

    public void setLeftButtonDrawable(Drawable icon) {
        if (mLeftButton == null) return;
        mLeftButton.setCompoundDrawables(icon, null, null, null);
    }

    public void setRightButtonDrawable(Drawable icon) {
        if (mRightButton == null) return;
        mRightButton.setCompoundDrawables(icon, null, null, null);
    }

    public void showButtonBar() {
        if (mButtonBar == null) return;
        mButtonBar.setVisibility(View.VISIBLE);
    }

    public void hideButtonBar() {
        if (mButtonBar == null) return;
        mButtonBar.setVisibility(View.GONE);
    }

    public void showFloatingActionButton() { mFloatingActionButton.setVisibility(View.VISIBLE); }

    public void hideFloatingActionButton() { mFloatingActionButton.setVisibility(View.GONE); }

    // Allow direct access to the views for more advanced operations
    @Nullable protected View getViewRoot() { return mViewRoot; }
    @Nullable protected FloatingActionButton getFloatingActionButton() { return mFloatingActionButton; }
    @Nullable protected ImageView getImageView() { return mImageView; }
    @Nullable protected TextView getHeadingTextView() { return mHeading; }
    @Nullable protected TextView getDescriptionTextView() { return mDescription; }
    @Nullable protected TextView getLeftButton() { return mLeftButton; }
    @Nullable protected Button getRightButton() { return mRightButton; }
}