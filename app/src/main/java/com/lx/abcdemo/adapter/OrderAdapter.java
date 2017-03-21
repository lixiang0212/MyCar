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
import java.util.List;

/**
 * Created by lixiang on 2017/3/14.
 */

public class OrderAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
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
            view=inflater.inflate(R.layout.inflate_order_item,null);
            holder.iv = (ImageView) view.findViewById(R.id.order_item_iv);
            holder.tvPay= (TextView) view.findViewById(R.id.order_item_status);
            holder.tvTitle= (TextView) view.findViewById(R.id.order_item_title);
            holder.tvPrice= (TextView) view.findViewById(R.id.order_item_price);
            holder.tvSize= (TextView) view.findViewById(R.id.order_item_size);
            holder.tvTotal= (TextView) view.findViewById(R.id.order_item_total);
            holder.tvTime= (TextView) view.findViewById(R.id.order_item_time);
            holder.tvNumber= (TextView) view.findViewById(R.id.order_item_Number);
            view.setTag(holder);
        }else {
            holder = (TempHolder) view.getTag();
        }
        Order order = orders.get(i);
        holder.iv.setImageResource(order.getPicUrl());
        holder.tvNumber.setText(order.getNumber()+"");
        holder.tvTitle.setText(order.getTitle());
        holder.tvPrice.setText(order.getPrice()+"");
        holder.tvSize.setText(order.getSize()+"");
        holder.tvTotal.setText(order.getSize()+"");
        holder.tvTime.setText(order.getTime()+"");
        holder.tvPay.setText(order.getStatus());
        return view;
    }

    private class TempHolder{
        private TextView tvNumber,tvPay,tvTitle,tvPrice,tvSize,tvTotal,tvTime;
        private ImageView iv;
    }

}
