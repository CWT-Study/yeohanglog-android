package team.triplog.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import team.triplog.R;
import team.triplog.domain.entity.TripLogInfoChat;

public class TripLogInfoChatAdapter  extends RecyclerView.Adapter<TripLogInfoChatAdapter.ViewHolder> {
    private ArrayList<TripLogInfoChat> tripLogInfoChats;
    private Context context;

    public TripLogInfoChatAdapter(Context mContext, ArrayList<TripLogInfoChat> tripLogInfoChats) {
        this.tripLogInfoChats = tripLogInfoChats;
        this.context = mContext;
    }

    @Override
    public int getItemCount() {
        return tripLogInfoChats.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_trip_log_info_user, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TripLogInfoChat tripLog = tripLogInfoChats.get(position);

        holder.tripLogInfoUserName.setText("홍길동");
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View viewUser;
        TextView tripLogInfoUserName;
        TextView textUserSentence;

        ViewHolder(View v) {
            super(v);
            viewUser = v.findViewById(R.id.view_user);
            tripLogInfoUserName = v.findViewById(R.id.trip_log_info_user_name);
            textUserSentence = v.findViewById(R.id.text_user_sentence);

        }
    }
}
