package com.demo.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.demo.R;

import java.util.ArrayList;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyViewHolder> {

    private ArrayList<String> drawerList;
    private Context context;
    private ArrayList<Integer> drawerIconList;
    private View.OnClickListener clickListener;
    private MainContract.View mainView;

    public DrawerAdapter(ArrayList<String> drawerList, ArrayList<Integer> drawerIconList, MainActivity mainActivity) {
        this.drawerList = drawerList;
        this.mainView = mainActivity;
        this.context = mainActivity;
        this.drawerIconList = drawerIconList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_navigation_drawer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvDraderName.setText(drawerList.get(position));
        holder.tvDraderName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, holder.tvDraderName.getText(), Toast.LENGTH_LONG).show();
                mainView.onItemSelect(String.valueOf(holder.tvDraderName.getText()));
            }
        });
//        holder.tvDraderName.setCompoundDrawablesWithIntrinsicBounds( drawerIconList.get(position), 0, 0, 0);
        holder.ivDrawableLeft.setImageResource(drawerIconList.get(position));
        if (holder.tvDraderName.getText().equals("My Messages")){
            holder.tvBadge.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return drawerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDraderName;
        public TextView tvBadge;
        public ImageView ivDrawableLeft;

        public MyViewHolder(View view) {
            super(view);
            tvDraderName = (TextView) view.findViewById(R.id.tvDrawerName);
            tvBadge = (TextView) view.findViewById(R.id.action_badge);
            ivDrawableLeft = (ImageView) view.findViewById(R.id.ivDrawableLeft);
        }
    }

}
