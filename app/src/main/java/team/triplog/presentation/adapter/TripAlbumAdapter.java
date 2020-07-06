package team.triplog.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import team.triplog.R;

public class TripAlbumAdapter extends RecyclerView.Adapter<TripAlbumAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> items;
    private OnItemClickListener onItemClickListener;

    public TripAlbumAdapter(
            Context context,
            ArrayList<String> images,
            OnItemClickListener onItemClickListener
    ) {
        this.context = context;
        this.items = images;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_trip_album, parent, false),
                onItemClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imagePath = items.get(position);

        Glide.with(context)
                .load(imagePath)
                .thumbnail(0.1f)
                .into(holder.viewAlbum);
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnItemClickListener onItemClickListener;
        ImageView viewAlbum;

        ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);

            this.onItemClickListener = onItemClickListener;
            viewAlbum = view.findViewById(R.id.view_album);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}