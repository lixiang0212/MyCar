package com.lx.abcdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.info.CarC;
import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class ListCTAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<CarC> data;

    public ListCTAdapter(Context context, List<CarC> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CarC getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         TempHolder tempHolder;
        if(view==null){
            tempHolder = new TempHolder();
            view = inflater.inflate(R.layout.inflate_c_itemt,null);
            tempHolder.imageView = (ImageView) view.findViewById(R.id.inflate_c_itemT_iv);
            tempHolder.tv_size = (TextView) view.findViewById(R.id.inflate_c_itemT_size);
            tempHolder.tv_kind = (TextView) view.findViewById(R.id.inflate_c_itemT_kind);
            view.setTag(tempHolder);
        }else {
            tempHolder = (TempHolder)view.getTag();
        }
        CarC  carC= data.get(i);
        tempHolder.imageView.setImageResource(carC.getPicId());
        tempHolder.tv_size.setText(carC.getSize());
        tempHolder.tv_kind.setText(carC.getKind());
        return view;
    }
    private class  TempHolder{
        private TextView tv_size,tv_kind;
        private ImageView imageView;
    }
}
