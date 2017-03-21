package com.lx.abcdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lx.abcdemo.R;
import com.lx.abcdemo.activity.OrderActivity;
import com.lx.abcdemo.info.Order;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lixiang on 2017/3/14.
 */

public class PayAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Order> orders;

    public PayAdapter(Context context, List<Order> orders) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        TempHolder holder = null;
        if(view==null){
            holder = new TempHolder();
            view=inflater.inflate(R.layout.inflate_fragment_pay_item,null);
            holder.icon = (ImageView) view.findViewById(R.id.pay_item_Icon);
            holder.status= (ImageView) view.findViewById(R.id.pay_item_ivStatus);
            holder.tvTitle= (TextView) view.findViewById(R.id.pay_item_Title);
            holder.tvPrice= (TextView) view.findViewById(R.id.pay_item_Price);
            holder.tvSize= (TextView) view.findViewById(R.id.pay_item_Sum);
            holder.tvTotal= (TextView) view.findViewById(R.id.pay_item_Total);
            holder.tvNumber= (TextView) view.findViewById(R.id.pay_item_Number);
            holder.tvSend = (TextView) view.findViewById(R.id.pay_item_go);
            holder.rl = (RelativeLayout) view.findViewById(R.id.pay_item_rl);
            view.setTag(holder);
        }else {
            holder = (TempHolder) view.getTag();
        }
        final Order order = orders.get(i);
        holder.icon.setImageResource(order.getPicUrl());
        holder.tvNumber.setText(""+order.getNumber()+"");
        holder.tvTitle.setText(order.getTitle());
        holder.tvPrice.setText("¥"+order.getPrice()+"");
        holder.tvSize.setText("×"+order.getSize()+"");
        double b = (order.getPrice()*order.getSize());
        holder.tvTotal.setText("合计:"+b+"");
        if (order.getStatus().equals("待付款")){
             holder.status.setImageResource(R.drawable.pending_payment);
             holder.tvSend.setText("去付款");
             holder.tvSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"去付款",Toast.LENGTH_SHORT).show();
                }
            });
        }else if(order.getStatus().equals("待发货")){
            holder.status.setImageResource(R.drawable.wait_ship);
            holder.tvSend.setText("提醒发货");
            holder.tvSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"等待发货",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if(order.getStatus().equals("待收货")){
            holder.status.setImageResource(R.drawable.wait_receipt);
            holder.tvSend.setText("确认收货");
            holder.tvSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"待收货",Toast.LENGTH_SHORT).show();
                }
            });
            holder.rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(context, OrderActivity.class);
                    intent.putExtra("order",order);
                    context.startActivity(intent);
                }
            });
        }
        else if(order.getStatus().equals("售后")){
            holder.status.setImageResource(R.drawable.after_sale);
            holder.tvSend.setText("申请售后");
            holder.tvSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"售后",Toast.LENGTH_SHORT).show();
                }
            });
        }
        return view;
    }

    private class TempHolder{
        private TextView tvNumber,tvTitle,tvPrice,tvSize,tvTotal,tvSend;
        private ImageView icon,status;
        private RelativeLayout rl;
    }
    public static double mul(double d,int n){
        BigDecimal bd = new BigDecimal(Double.toString(d));
        BigDecimal bd2 = new BigDecimal(n);
        return bd.multiply(bd2).doubleValue();
    }

}
