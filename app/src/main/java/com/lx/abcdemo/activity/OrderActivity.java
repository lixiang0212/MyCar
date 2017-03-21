package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.OrderAdapter;
import com.lx.abcdemo.info.Order;
import com.lx.abcdemo.info.User;
import com.lx.abcdemo.sharedpre.UserLocation;
import com.lx.abcdemo.sqlite.OrderSqlUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvTitle,tvName,tvNumber,tvAddress,tvSelected,itNumber,itTitle,itPrice,itSum,itTotal,yes,no;
    private ImageView ivBack,ivIcon;
    private RelativeLayout rl;
    private OrderSqlUtils sqlUtils;
    private User user;
    private UserLocation location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        user = (User)getIntent().getSerializableExtra("user");
        initView();
        initLocation();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.include_bar_title);
        tvTitle.setText("订单详情");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        rl = (RelativeLayout) findViewById(R.id.order_rl);
        rl.setOnClickListener(this);
        ivIcon = (ImageView) findViewById(R.id.order_it_Icon);
        tvName = (TextView) findViewById(R.id.order_tvName);
        tvNumber = (TextView) findViewById(R.id.order_tvNumber);
        tvAddress = (TextView) findViewById(R.id.order_tvAddress);
        tvSelected = (TextView) findViewById(R.id.order_tvSelected);
        itNumber = (TextView) findViewById(R.id.order_it_Number);
        itTitle = (TextView) findViewById(R.id.order_it_Title);
        itPrice = (TextView) findViewById(R.id.order_it_Price);
        itSum = (TextView) findViewById(R.id.order_it_Sum);
        itTotal = (TextView) findViewById(R.id.order_it_Total);
        yes = (TextView) findViewById(R.id.order_yes);
        yes.setOnClickListener(this);
        no = (TextView) findViewById(R.id.order_delete);
        no.setOnClickListener(this);
        sqlUtils = new OrderSqlUtils(this);
    }
    private void initLocation() {
        location = new UserLocation(this);
        if (user==null){
            user = location.getUser(this);
            tvSelected.setVisibility(View.VISIBLE);
            tvName.setText(user.getName());
            tvNumber.setText(user.getNumber());
            tvAddress.setText(user.getAddress());
        }else {
            if (user.isSelected()){
                tvSelected.setVisibility(View.VISIBLE);
            }
            tvName.setText(user.getName());
            tvNumber.setText(user.getNumber());
            tvAddress.setText(user.getAddress());
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.include_bar_ivBack:
                finish();
                break;
            case R.id.order_rl:
                Intent intent = new Intent();
                intent.setClass(OrderActivity.this,LocationActivity.class);
                startActivity(intent);
                break;
            case R.id.order_yes:
                Toast.makeText(OrderActivity.this,"确认送达",Toast.LENGTH_SHORT).show();
                break;
            case R.id.order_delete:
                Toast.makeText(OrderActivity.this,"取消订单",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        user = (User)getIntent().getSerializableExtra("user");
        initLocation();
    }
}
