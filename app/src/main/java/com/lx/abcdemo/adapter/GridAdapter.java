package com.lx.abcdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.Car;

import java.util.List;

/**
 * Created by lixiang on 2017/3/6.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private List<Car> data;
    private LayoutInflater inflater;

    public GridAdapter(Context context, List<Car> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Car getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TempHolder holder;
        if(view==null){
            holder = new TempHolder();
            view = inflater.inflate(R.layout.inflate_grid_item,null);
            holder.imageView = (ImageView) view.findViewById(R.id.grid_item_iv);
            holder.name = (TextView) view.findViewById(R.id.grid_item_tv);
            view.setTag(holder);
        }else {
            holder = (TempHolder) view.getTag();
        }
        Car car = data.get(i);
        holder.name.setText(car.getName());
        holder.imageView.setImageResource(car.getPicId());
        return view;
    }
    private class TempHolder{
        private ImageView imageView;
        private TextView name;
    }
}
