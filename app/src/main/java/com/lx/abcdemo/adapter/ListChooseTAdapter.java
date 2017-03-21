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

public class ListChooseTAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<String> data;
    private int id = -1;

    public ListChooseTAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int i) {
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
            view = inflater.inflate(R.layout.inflate_choose_item1,null);
            tempHolder.tv = (TextView) view.findViewById(R.id.choose_item1_name);
            view.setTag(tempHolder);
        }else {
            tempHolder = (TempHolder) view.getTag();
        }
        String s = data.get(i);
         
        tempHolder.tv.setText(s);
        return view;
    }

    private class  TempHolder{
        private TextView tv;
    }
}
