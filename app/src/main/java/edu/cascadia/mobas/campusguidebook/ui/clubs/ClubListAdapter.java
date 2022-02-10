package edu.cascadia.mobas.campusguidebook.ui.clubs;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Club;

public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.ViewHolder> {

    private List<Club> mClubList;
    private Context mContext;

    // Viewholder provides access to the individual views in a row of the RecyclerView's row
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView clubCardView;
        private final ImageView clubImageView;
        private final TextView clubTextView;

        public ViewHolder(View parentView) {
            super(parentView);
            // TODO: Define click listener(s) for the ViewHolder's Views
            clubCardView = (CardView) parentView.findViewById(R.id.cardView_club_list);
            clubImageView = (ImageView) parentView.findViewById(R.id.imageView_club_banner);
            clubTextView = (TextView) parentView.findViewById(R.id.textView_club_title);
        }

        // These methods return references to the views on the current row
        public TextView getTextView() {
            return clubTextView;
        }

        public ImageView getImageView() {
            return clubImageView;
        }

        public CardView getCardView() {
            return clubCardView;
        }

    }

    // Updates the list of clubs used
    public void setData(List<Club> newClubList) {
        this.mClubList = newClubList;
        notifyDataSetChanged();
    }

    // Initialize the datasource used by the Adapter.
    public ClubListAdapter(List<Club> clubList) {
        mClubList = clubList;
    }

    // Used by the layout manager to return a ViewHolder for a row containing club info
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_club_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Used by the layout manager to change the displayed values in a bound ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get the data for a particular row within the list; return if null
        Club clubItem = mClubList.get(position);
        if (clubItem == null) {
            Log.d("ClubListAdapter", "Club item is null");
            return;
        }

        String clubName = clubItem.getClubName();
        Log.d("ClubListAdapter", "Club name is " + clubName);


        // display the data from clubItem in the Views provided by the ViewHolder
        TextView tv = viewHolder.getTextView();
        Log.d("ClubListAdapter", "getTextView returns " + (tv == null ? "null" : "view"));
        if (tv == null) {
            return;
        }
        Log.d("ClubListAdapter", "Setting textview to " + clubName);
        tv.setText(clubName);
        // TODO: replace static image below with one based on uri in Club.getUri
        // viewHolder.getImageView().setImageResource(R.drawable.engineer_s_mindset__1_);
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
