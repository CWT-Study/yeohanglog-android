package team.triplog.adapter;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.entity.TripLog;

public class TripLogContentAdapter extends RecyclerView.Adapter<TripLogContentAdapter.ViewHolder> {
    private ArrayList<TripLog> tripLogs;
    Context context;

    public TripLogContentAdapter(Context mContext, ArrayList<TripLog> mtripLogs) {
        tripLogs = mtripLogs;
        context = mContext;
    }

    @Override
    public int getItemCount() {
        return tripLogs.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_trip_log_content, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(TripLogContentAdapter.ViewHolder holder, int position) {
        TripLog tripLog = tripLogs.get(position);

        holder.imageView.setBackground(new ShapeDrawable(new OvalShape()));
        holder.imageView.setClipToOutline(true);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_prev_year;
        TextView text_next_year;
        TextView text_prev_month;
        TextView text_next_month;
        TextView text_prev_day;
        TextView text_next_day;
        public TextView text_title;
        AppCompatImageView imageView;

        ViewHolder(View v) {
            super(v);

            text_prev_year = v.findViewById(R.id.text_prev_year);
            text_next_year = v.findViewById(R.id.text_next_year);
            text_prev_month = v.findViewById(R.id.text_prev_month);
            text_next_month = v.findViewById(R.id.text_next_month);
            text_prev_day = v.findViewById(R.id.text_prev_day);
            text_next_day = v.findViewById(R.id.text_next_day);
            text_title = v.findViewById(R.id.text_title);
            imageView = v.findViewById(R.id.imageview);


            //item click event
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (pos == 0) {
                            Toast.makeText(context, "새로운 아이템 등록", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "기존 아이템", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }
    }
}
