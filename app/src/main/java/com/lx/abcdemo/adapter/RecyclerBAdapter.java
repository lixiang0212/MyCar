package com.lx.abcdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.Car;
import com.lx.abcdemo.info.CarB;
import com.lx.abcdemo.interfaces.ClickA;

import java.util.List;

/**
 * Created by lixiang on 2017/3/7.
 */

public class RecyclerBAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<CarB> data;
    private ClickA clickA;

    public void setClickA(ClickA clickA) {
        this.clickA = clickA;
    }

    public RecyclerBAdapter(Context context, List<CarB> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_b_item,parent,false);
        return new RecyclerBAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CarB car = data.get(position);
        ((RecyclerBAdapter.ViewHolder)holder).imageView.setImageResource(car.getPicId());
        ((RecyclerBAdapter.ViewHolder)holder).textView.setText(car.getName());
        ((RecyclerBAdapter.ViewHolder)holder).layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickA.onClick(position);
            }
        });
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        private LinearLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.inflate_b_tv);
            imageView = (ImageView) itemView.findViewById(R.id.inflate_b_iv);
            layout = (LinearLayout) itemView.findViewById(R.id.inflate_b_linear);
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
