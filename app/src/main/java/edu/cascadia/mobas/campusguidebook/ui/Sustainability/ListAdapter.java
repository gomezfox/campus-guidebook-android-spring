package edu.cascadia.mobas.campusguidebook.ui.Sustainability;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.viewmodel.SustListViewModel;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<UIItem> mSustList;
    private final SustListViewModel mViewModel;
    private LifecycleOwner mLifecycleOwner;

    // ViewHolder provides access to the individual views in a row of the RecyclerView's row
    // This internal static class is supplied in the diamond brackets in the class declaration
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Provide variables to hold references to each View in the Sustainability list item fragment
        public final CardView SustCardView;
        public final ImageView SustImageView;
        public final TextView SustNameTextView;

        // The constructor takes a parent view (LinearLayout) on the Sustainability list item fragment
        // and allows us to get references to the views it contains
        public ViewHolder(View parentView) {
            super(parentView);
            // look up and assign the views in the Sustainability list item fragment to our variables
            SustCardView = parentView.findViewById(R.id.cardView_sust_list);
            SustImageView = parentView.findViewById(R.id.imageView_sust_banner);
            SustNameTextView = parentView.findViewById(R.id.textView_sust_title);
            // TODO: Define click listener(s) for the ViewHolder's CardView

        }
    }  // End of static ViewHolder class

    // SustListAdapter constructor and methods
    // Initialize this adapter with a reference to the datasource to be used.
    public ListAdapter(List<UIItem> SustList, SustListViewModel viewModel) {
        mSustList = SustList;
        mViewModel = viewModel;
    }

    // TODO: Investigate using SwitchMap to modify instead of completely replacing the list
    // Updates the list of Sustainability  used by the RecyclerView
    public void setList(List<UIItem> newSustList) {
        this.mSustList = newSustList;
        notifyDataSetChanged();
    }


    // Used by the layout manager to return the ViewHolder for a row containing Sustainability info
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {

        // get the parent LifecycleOwner if this is the first time
        if (mLifecycleOwner == null) {
            mLifecycleOwner = (LifecycleOwner) parentViewGroup.getContext();
        }

        // Create a new view containing all the views for the UI of the list item
        View view = LayoutInflater.from(parentViewGroup.getContext())
                .inflate(R.layout.sust_list_item, parentViewGroup, false);

        return new ViewHolder(view);
    }

    // Used by the layout manager to change the displayed values in a bound ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        // Get the data for a particular row within the list; return if null
        UIItem UIItem = mSustList.get(position);

        // return if no data
        if (UIItem == null || UIItem.getSustainability() == null) {
            return;
        }

        // otherwise, fill in the ui with the SustItem data, using null checks for safety
        if (viewHolder.SustNameTextView != null) {
            viewHolder.SustNameTextView.setText(UIItem.getSustainability().getSustainabilityName());
        }

        // the image is livedata so it needs an observer
        if (viewHolder.SustImageView != null) {
            UIItem.getImage().observe(mLifecycleOwner, viewHolder.SustImageView::setImageDrawable);
        }
    }

    // Used by the layout manager to determine the number of Sustainability  in the list
    @Override
    public int getItemCount() {
        if (mSustList == null) {
            return 0;
        } else {
            return mSustList.size();
        }
    }

}