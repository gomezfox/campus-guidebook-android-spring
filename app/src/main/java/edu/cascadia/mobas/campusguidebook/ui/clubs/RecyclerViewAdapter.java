package edu.cascadia.mobas.campusguidebook.ui.clubs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.cascadia.mobas.campusguidebook.R;
import edu.cascadia.mobas.campusguidebook.data.model.IEntity;
import edu.cascadia.mobas.campusguidebook.data.repository.ImageRepository;
import edu.cascadia.mobas.campusguidebook.viewmodel.MainActivityViewModel;

public class RecyclerViewAdapter<T extends IEntity> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<T> mList;
    private LifecycleOwner mLifecycleOwner;
    private final MainActivityViewModel mViewModel;
    private final ImageRepository mImageRepository = ImageRepository.getInstance();
    //private final View.OnClickListener mOnClickListener;

    // ClubListAdapter constructor and methods
    // Initialize this adapter with a reference to the datasource to be used.
    public RecyclerViewAdapter(List<T> list, MainActivityViewModel viewModel) {
        mList = list;
        this.mViewModel = viewModel;
        //mOnClickListener = onClickListener;
    }

    // TODO: Investigate using SwitchMap to modify instead of completely replacing the list
    // Updates the list used by the RecyclerView
    public void setList(List<T> newList) {
        this.mList = newList;
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
                .inflate(R.layout.fragment_list_item, parentViewGroup, false);

        return new ViewHolder(view);
    }

    // Used by the layout manager to change the displayed values in a bound ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        // Get the data for a particular row within the list; return if null
        T item = mList.get(position);
        viewHolder.textView.setText(item.getName());

        // get the drawable image as livedata and add an observer
        mViewModel.getImageFromUri(item.getImageUri()).observe(
                (LifecycleOwner)viewHolder.imageView.getContext(),
                viewHolder.imageView::setImageDrawable
        );
    }


    // Used by the layout manager to determine the number of clubs in the list
    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    // ViewHolder provides access to the individual views in a row of the RecyclerView's row
    // This internal static class is supplied in the diamond brackets in the class declaration
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Provide variables to hold references to each View in the list item fragment
        public final CardView cardView;
        public final ImageView imageView;
        public final TextView textView;

        // The constructor takes a parent view (a layout defined in xml) on the list item fragment
        // and allows us to get references to the views it contains
        public ViewHolder(View parentView) {
            super(parentView);
            // look up and assign the views in the club list item fragment to our variables
            cardView = parentView.findViewById(R.id.cardview_list_item);
            imageView = parentView.findViewById(R.id.imageview_list_item_image);
            textView = parentView.findViewById(R.id.textView_list_item_text);
        }
    }  // End of static ViewHolder class
}