package com.lx.abcdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lx.abcdemo.R;

import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class ListCAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Integer> data;
    private int id = 0;

    public ListCAdapter(Context context, List<Integer> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Integer getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public void setPosition(int position){
        id=position;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TempHolder tempHolder;
        if(view==null){
            tempHolder = new TempHolder();
            view = inflater.inflate(R.layout.inflate_c_item,null);
            tempHolder.tv = (TextView) view.findViewById(R.id.inflate_c_item_time);
            view.setTag(tempHolder);
        }else {
            tempHolder = (TempHolder) view.getTag();
        }
        int time = data.get(i);
        if (id==i){
            tempHolder.tv.setTextColor(context.getResources().getColor(R.color.colorYellow));
            tempHolder.tv.setBackgroundColor(context.getResources().getColor(R.color.colorBlank));
        }else {
            tempHolder.tv.setTextColor(context.getResources().getColor(R.color.colorBlank));
            tempHolder.tv.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }
        tempHolder.tv.setText(time+"");
        return view;
    }

    private class  TempHolder{
        private TextView tv;
    }
}
