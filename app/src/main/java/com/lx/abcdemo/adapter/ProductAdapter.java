package com.lx.abcdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.info.CarProduct;
import java.util.List;

/**
 * Created by lixiang on 2017/3/15.
 */

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<CarProduct> cars;

    public ProductAdapter(Context context, List<CarProduct> cars) {
        this.context = context;
        this.cars = cars;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public CarProduct getItem(int i) {
        return cars.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Temp temp = null;
        if(view==null){
            temp = new Temp();
            view = inflater.inflate(R.layout.inflate_product_item,null);
            temp.iv = (ImageView) view.findViewById(R.id.product_item_iv);
            temp.name = (TextView) view.findViewById(R.id.product_item_name);
            temp.price = (TextView) view.findViewById(R.id.product_item_price);
            view.setTag(temp);
        }else {
            temp = (Temp) view.getTag();
        }
        CarProduct c = cars.get(i);
        temp.iv.setImageResource(c.getPicUrl());
        temp.name.setText(c.getName());
        temp.price.setText("¥"+c.getPrice());
        return view;
    }
    private class Temp{
        private ImageView iv;
        private TextView name,price;
    }
}
