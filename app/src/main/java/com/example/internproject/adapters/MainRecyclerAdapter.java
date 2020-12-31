package com.example.internproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internproject.R;
import com.example.internproject.models.mainRVModel;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    List<mainRVModel> mainRVModelList;
    private ChildRecyclerAdapter.ChildAdapterEvents childAdapterEvents;

    public MainRecyclerAdapter(List<mainRVModel> mainRVModelList , ChildRecyclerAdapter.ChildAdapterEvents childAdapterEvents) {
        this.mainRVModelList = mainRVModelList;
        this.childAdapterEvents = childAdapterEvents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_model_main , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mainRVModel mainModel= mainRVModelList.get(position);
        holder.moduleName.setText(mainModel.getModuleName());
        ChildRecyclerAdapter childRecyclerAdapter = new ChildRecyclerAdapter(mainModel.getModuleItems() , childAdapterEvents);
        holder.childRecyclerView.setAdapter(childRecyclerAdapter);
    }

    @Override
    public int getItemCount() {
        return mainRVModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView moduleName;
        RecyclerView childRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moduleName = itemView.findViewById(R.id.tvModule);
            childRecyclerView = itemView.findViewById(R.id.rvChild);
        }
    }
}
