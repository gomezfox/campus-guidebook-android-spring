package edu.cascadia.mobas.campusguidebook.ui.clubs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Club;

public class ClubListAdapter extends RecyclerView.Adapter<ClubListAdapter.ViewHolder> {

    private MutableLiveData<ArrayList<Club>> clubList;

    /**
     * Provide reference to the views that will be populated using the ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CardView clubCardView;
        private final ImageView clubImageView;
        private final TextView clubTextView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            clubCardView = (CardView) view.findViewById(R.id.cardView_club_list);
            clubImageView = (ImageView) view.findViewById(R.id.imageView_club_banner);
            clubTextView = (TextView) view.findViewById(R.id.textView);
        }

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

    /**
     * Initialize the datasource used by the Adapter.
     *
     * @param liveDataClubList LiveData<List<Club>> containing the data to populate views to be used
     * bythe Club List RecyclerView.
     */
    public ClubListAdapter(LiveData<List<Club>> liveDataClubList) {
        clubList.setValue((ArrayList<Club>) liveDataClubList.getValue());
    }

    // Used by the layout manager to return a ViewHolder for a row containing club info
    @Override @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_club_list_item , viewGroup, false);
        return new ViewHolder(view);
    }

    // Usedby the layout manager to change the displayed values in a bound viewholder
    @Override @NonNull
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get the data for a particular row within the list
        Club clubItem = clubList.getValue().get(position);

        // display the data from clubItem in the ViewHolder
        if (clubItem != null) {

            // Set the text view to display the club name
            viewHolder.getTextView().setText(clubItem.getClubName());

            // TODO: replace static image below with one based on uri in Club.getUri
            viewHolder.getImageView().setImageResource(R.drawable.engineer_s_mindset__1_);
        }
    }

    // Used by the layout manager to determine the number of clubs in the list
    @Override @NonNull
    public int getItemCount() {
        if (clubList == null || clubList.getValue() == null) {
            return 0;
        } else {
            return clubList.getValue().size();
        }
    }
}
