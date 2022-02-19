package edu.cascadia.mobas.campusguidebook.ui.Sustainability;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.cascadia.mobas.campusguidebook.R;


import java.util.ArrayList;


import edu.cascadia.mobas.campusguidebook.data.model.Sustainability;


public class SustainabilityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<edu.cascadia.mobas.campusguidebook.data.model.Sustainability> SustArrayList;

    public SustainabilityAdapter() {
        this.SustArrayList = new ArrayList<Sustainability>();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sustainability_card_keep_notusedyet,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Sustainability Sust = SustArrayList.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;

        viewHolder.txtView_title.setText(Sust.getSustainabilityName());
        viewHolder.txtView_description.setText(Sust.getSustainabilityDescription());


    }

    @Override
    public int getItemCount() {
        return SustArrayList.size();
    }

    public void updateSustList(final ArrayList<edu.cascadia.mobas.campusguidebook.data.model.Sustainability> SustArrayList) {
        this.SustArrayList.clear();
        this.SustArrayList = SustArrayList;
        notifyDataSetChanged();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView_icon;
        TextView txtView_title;
        TextView txtView_description;


        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView_icon = itemView.findViewById(R.id.imgView_icon);
            txtView_title = itemView.findViewById(R.id.txtView_title);
            txtView_description = itemView.findViewById(R.id.txtView_description);


        }
    }
}