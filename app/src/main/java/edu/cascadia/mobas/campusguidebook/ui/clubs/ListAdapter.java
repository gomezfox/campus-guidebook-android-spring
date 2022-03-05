package edu.cascadia.mobas.campusguidebook.ui.clubs;

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
import edu.cascadia.mobas.campusguidebook.viewmodel.ClubListViewModel;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<UIItem> mClubList;
    private final ClubListViewModel mViewModel;
    private LifecycleOwner mLifecycleOwner;

    // ViewHolder provides access to the individual views in a row of the RecyclerView's row
    // This internal static class is supplied in the diamond brackets in the class declaration
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Provide variables to hold references to each View in the club list item fragment
        public final CardView clubCardView;
        public final ImageView clubImageView;
        public final TextView clubNameTextView;

        // The constructor takes a parent view (LinearLayout) on the club list item fragment
        // and allows us to get references to the views it contains
        public ViewHolder(View parentView) {
            super(parentView);
            // look up and assign the views in the club list item fragment to our variables
            clubCardView = parentView.findViewById(R.id.cardView_club_list);
            clubImageView = parentView.findViewById(R.id.imageView_club_banner);
            clubNameTextView = parentView.findViewById(R.id.textView_club_title);
            // TODO: Define click listener(s) for the ViewHolder's CardView
        }
    }  // End of static ViewHolder class

    // ClubListAdapter constructor and methods
    // Initialize this adapter with a reference to the datasource to be used.
    public ListAdapter(List<UIItem> clubList, ClubListViewModel viewModel) {
        mClubList = clubList;
        mViewModel = viewModel;
    }

    // TODO: Investigate using SwitchMap to modify instead of completely replacing the list
    // Updates the list of clubs used by the RecyclerView
    public void setList(List<UIItem> newClubList) {
        this.mClubList = newClubList;
        notifyDataSetChanged();
    }

    // Used by the layout manager to return the ViewHolder for a row containing club info
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {

        // get the parent LifecycleOwner if this is the first time
        if (mLifecycleOwner == null) {
            mLifecycleOwner = (LifecycleOwner) parentViewGroup.getContext();
        }

        // Create a new view containing all the views for the UI of the list item
        View view = LayoutInflater.from(parentViewGroup.getContext())
                .inflate(R.layout.fragment_club_list_item, parentViewGroup, false);

        return new ViewHolder(view);
    }

    // Used by the layout manager to change the displayed values in a bound ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        // Get the data for a particular row within the list; return if null
        UIItem UIItem = mClubList.get(position);

        // return if no data
        if (UIItem == null || UIItem.getClub() == null) {
            return;
        }

        // otherwise, fill in the ui with the clubItem data, using null checks for safety
        if (viewHolder.clubNameTextView != null) {
            viewHolder.clubNameTextView.setText(UIItem.getClub().getClubName());
        }

        // the image is livedata so it needs an observer
        if (viewHolder.clubImageView != null) {
            UIItem.getImage().observe(mLifecycleOwner, viewHolder.clubImageView::setImageDrawable);
        }
    }

    // Used by the layout manager to determine the number of clubs in the list
    @Override
    public int getItemCount() {
        if (mClubList == null) {
            return 0;
        } else {
            return mClubList.size();
        }
    }

}