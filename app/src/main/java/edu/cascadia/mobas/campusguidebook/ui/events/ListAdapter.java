package edu.cascadia.mobas.campusguidebook.ui.events;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.Event;
import edu.cascadia.mobas.campusguidebook.viewmodel.EventListViewModel;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<UIItem> mEventList;
    private final EventListViewModel mViewModel;
    private LifecycleOwner mLifecycleOwner;
//    private Context mContext;

    // Viewholder provides access to the individual views in a row of the RecyclerView's row
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Provide variables to hold references to each View in the event list item fragment
        public final CardView EventCardView;
        public final ImageView EventImageView;
        public final TextView EventTextView;

        public ViewHolder(View parentView) {
            super(parentView);
            // TODO: Define click listener(s) for the ViewHolder's Views
            EventCardView = parentView.findViewById(R.id.cardView_event_list);
            EventImageView = parentView.findViewById(R.id.imageView_event_list);
            EventTextView = parentView.findViewById(R.id.textView_event_title);
        }
    }
    // EventListAdapter constructor and methods
    public ListAdapter(List<UIItem> eventList, EventListViewModel viewModel) {
        mEventList = eventList;
        mViewModel = viewModel;
    }

    // Updates the list of clubs used by the RecyclerView
    public void setList(List<UIItem> newEventList) {
        this.mEventList = newEventList;
        notifyDataSetChanged();
    }
/*
        // These methods return references to the views on the current row
        public TextView getTextView() {
            return EventTextView;
        }
        public ImageView getImageView() {
            return EventImageView;
        }
        public CardView getCardView() {
            return EventCardView;
        }
    }
    // Updates the list of Events used
    public void setData(List<Event> newEventList) {
        this.mEventList = newEventList;
        notifyDataSetChanged();
    }
    // Initialize the datasource used by the Adapter.
    public EventListAdapter(List<EventUIItem> EventList) {
        mEventList = EventList;
    }*/

    // Used by the layout manager to return a ViewHolder for a row containing Event info
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parentViewGroup, int viewType) {
        // get the parent LifecycleOwner if this is the first time
        if (mLifecycleOwner == null) {
            mLifecycleOwner = (LifecycleOwner) parentViewGroup.getContext();
        }

        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parentViewGroup.getContext())
                .inflate(R.layout.event_list_item, parentViewGroup, false);
        return new ViewHolder(view);
    }

    // Used by the layout manager to change the displayed values in a bound ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get the data for a particular row within the list; return if null
        UIItem eventUIItem = mEventList.get(position);

        // return if no data
        if (eventUIItem == null || eventUIItem.getEvent() == null) {
            return;
        }

        // otherwise, fill in the ui with the eventItem data, using null checks for safety
        if (viewHolder.EventTextView != null) {
            viewHolder.EventTextView.setText(eventUIItem.getEvent().getEventName());
        }

        // the image is livedata so it needs an observer
        if (viewHolder.EventImageView != null) {
            eventUIItem.getImage().observe(mLifecycleOwner, viewHolder.EventImageView::setImageDrawable);
        }
//
//        String EventName = EventItem.getEventName();
//        Log.d("EventListAdapter", "Event name is " + EventName);


        // display the data from EventItem in the Views provided by the ViewHolder
//        TextView tv = viewHolder.getTextView();
//        Log.d("EventListAdapter", "getTextView returns " + (tv == null ? "null" : "view"));
//        if (tv == null) {
//            return;
//        }
//        Log.d("EventListAdapter", "Setting textview to " + EventName);
//        tv.setText(EventName);
        // TODO: replace static image below with one based on uri in Event.getUri
        // viewHolder.getImageView().setImageResource(R.drawable.engineer_s_mindset__1_);
    }

    // Used by the layout manager to determine the number of Events in the list
    @Override
    public int getItemCount() {
        if (mEventList == null) {
            return 0;
        } else {
            return mEventList.size();
        }
    }

}