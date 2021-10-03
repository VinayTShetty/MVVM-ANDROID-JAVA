package com.recycleview.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.recycleview.mvvm.R;
import com.recycleview.mvvm.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlaceItemViewHolder> {
    private List<NicePlace> nicePlaceList=new ArrayList<>();
    private Context context;

    public RecyclerAdapter(List<NicePlace> nicePlaces, Context context) {
        this.nicePlaceList = nicePlaces;
        this.context = context;
    }

    @Override
    public PlaceItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        PlaceItemViewHolder placeItemViewHolder=new PlaceItemViewHolder(view);
        return placeItemViewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerAdapter.PlaceItemViewHolder placeItemHolder, int position) {
        ((PlaceItemViewHolder)placeItemHolder).mName.setText(nicePlaceList.get(position).getTitle());
        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(context)
                .setDefaultRequestOptions(defaultOptions)
                .load(nicePlaceList.get(position).getImageUrl())
                .into(((PlaceItemViewHolder)placeItemHolder).mImage);
    }

    @Override
    public int getItemCount() {
        return nicePlaceList.size();
    }

    public class PlaceItemViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView mImage;
        private TextView mName;
        public PlaceItemViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
        }
    }
}
