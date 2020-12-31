package com.example.internproject.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internproject.R;
import com.example.internproject.models.videoDetails;


import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ViewHolder> {

    List<videoDetails> videoDetailsList;
    private ChildAdapterEvents childAdapterEvents;


    public ChildRecyclerAdapter(List<videoDetails> videoDetailsList , ChildAdapterEvents childAdapterEvents) {
        this.videoDetailsList = videoDetailsList;
        this.childAdapterEvents = childAdapterEvents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_model_child , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.courseName.setText(videoDetailsList.get(position).getVideoName());
        holder.courseName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                childAdapterEvents.onCourseClicked(videoDetailsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoDetailsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView courseName ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.tvCourseName);
        }

    }
    public interface ChildAdapterEvents{
        void onCourseClicked(videoDetails vd);
    }
}
