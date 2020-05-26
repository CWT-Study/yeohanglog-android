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

public class TripLogContentAdapter extends RecyclerView.Adapter<TripLogContentAdapter.ViewHolder>{

    private ArrayList<TripLog> tripLogs = new ArrayList<>();
    Context context;

    public TripLogContentAdapter(Context mContext, ArrayList<TripLog> mtripLogs){

        tripLogs = mtripLogs;

        context = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView text_prev_year;
        public TextView text_next_year;
        public TextView text_prev_month;
        public TextView text_next_month;
        public TextView text_prev_day;
        public TextView text_next_day;
        public TextView text_title;
        public View imageView;

        public ViewHolder(View v){

            super(v);

            text_prev_year =  v.findViewById(R.id.text_trip_start_year);
            text_next_year =  v.findViewById(R.id.text_trip_end_year);
            text_prev_month =  v.findViewById(R.id.text_trip_start_month);
            text_next_month =  v.findViewById(R.id.text_trip_end_month);
            text_prev_day =  v.findViewById(R.id.text_trip_start_day);
            text_next_day =  v.findViewById(R.id.text_trip_end_day);
            text_title =  v.findViewById(R.id.text_trip_name);
            imageView = v.findViewById(R.id.view_trip);


            //item click event
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        if (pos == 0){
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
    public TripLogContentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(context).inflate(R.layout.item_trip_log_content,parent,false);

        TripLogContentAdapter.ViewHolder viewHolder1 = new TripLogContentAdapter.ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(TripLogContentAdapter.ViewHolder Vholder, int position){
        TripLog tripLog = tripLogs.get(position);

//        Vholder.imageView.setBackground(new ShapeDrawable(new OvalShape()));
//        Vholder.imageView.setClipToOutline(true);


//        Vholder.imageView.setImageResource(tripLog.drawbleId);

    }

    @Override
    public int getItemCount(){

        return tripLogs.size();
    }

}
