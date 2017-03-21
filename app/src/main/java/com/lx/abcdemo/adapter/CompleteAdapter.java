package com.lx.abcdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.info.Order;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lixiang on 2017/3/14.
 */

public class CompleteAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Order> orders;

    public CompleteAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Order getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TempHolder holder = null;
        if(view==null){
            holder = new TempHolder();
            view=inflater.inflate(R.layout.inflate_order_items,null);
            holder.icon = (ImageView) view.findViewById(R.id.order_item_Icon);
            holder.tvTitle= (TextView) view.findViewById(R.id.order_item_Title);
            holder.tvPrice= (TextView) view.findViewById(R.id.order_item_Price);
            holder.tvSize= (TextView) view.findViewById(R.id.order_item_Sum);
            holder.tvTotal= (TextView) view.findViewById(R.id.order_item_Total);
            holder.tvNumber= (TextView) view.findViewById(R.id.order_item_Number);
            view.setTag(holder);
        }else {
            holder = (TempHolder) view.getTag();
        }
        Order order = orders.get(i);
        holder.icon.setImageResource(order.getPicUrl());
        holder.tvNumber.setText(""+order.getNumber()+"");
        holder.tvTitle.setText(order.getTitle());
        holder.tvPrice.setText("¥ "+order.getPrice()+"");
        holder.tvSize.setText("x "+order.getSize()+"");
        double b = (double) (order.getPrice()*order.getSize());
        holder.tvTotal.setText("合计: "+b+"");
        return view;
    }

    private class TempHolder{
        private TextView tvNumber,tvTitle,tvPrice,tvSize,tvTotal;
        private ImageView icon;
    }
    public static double mul(double d,int n){
        BigDecimal bd = new BigDecimal(Double.toString(d));
        BigDecimal bd2 = new BigDecimal(n);
        return bd.multiply(bd2).doubleValue();
    }

}
