package com.lx.abcdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.interfaces.ClickA;

import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class RecyclerLookBAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Integer> data;
    private ClickA clickA;

    public void setClickA(ClickA clickA) {
        this.clickA = clickA;
    }

    public RecyclerLookBAdapter(Context context, List<Integer> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_look_bg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int id= data.get(position);
        ((ViewHolder)holder).imageView.setImageResource(id);
        ((ViewHolder)holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickA.onClick(position);
            }
        });
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.inflate_look_bg_iv);
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
