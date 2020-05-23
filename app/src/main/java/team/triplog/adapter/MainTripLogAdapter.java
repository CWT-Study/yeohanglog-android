package team.triplog.adapter;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import team.triplog.R;
import team.triplog.entity.TripLog;

public class MainTripLogAdapter extends RecyclerView.Adapter<MainTripLogAdapter.ViewHolder>{

    private ArrayList<TripLog> tripLogs = new ArrayList<>();
    Context context;

    public MainTripLogAdapter(Context mContext, ArrayList<TripLog> mtripLogs){

        tripLogs = mtripLogs;

        context = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public AppCompatImageView imageView;

        public ViewHolder(View v){

            super(v);

            textView = (TextView) v.findViewById(R.id.text);
            imageView = v.findViewById(R.id.imageview);


            //item click event
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        if (pos == getItemCount()-1){
                            Toast.makeText(context,"새로운 아이템 등록",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context,"기존 아이템",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }
    }

    @Override
    public MainTripLogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(context).inflate(R.layout.item_main_trip_log,parent,false);

        ViewHolder viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position){
        TripLog tripLog = tripLogs.get(position);

        Vholder.imageView.setBackground(new ShapeDrawable(new OvalShape()));
        Vholder.imageView.setClipToOutline(true);

        if (position == getItemCount()-1){
            Vholder.imageView.setImageResource(R.drawable.button_plus);
            return;
        }

        Vholder.textView.setText(tripLog.title);
        Vholder.imageView.setImageResource(tripLog.drawbleId);

    }

    @Override
    public int getItemCount(){

        return tripLogs.size();
    }
}