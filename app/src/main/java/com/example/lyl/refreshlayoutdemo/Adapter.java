package com.example.lyl.refreshlayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 18/1/30.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<Integer> datas = new ArrayList<>();

    public void setDatas(List<Integer> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,null);

        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView tv = (TextView) holder.itemView;
        tv.setText("item" + datas.get(position));
    }

    @Override
    public int getItemCount() {
        if (datas.size() == 0){
            return 0;
        }
        return datas.size();
    }
}
