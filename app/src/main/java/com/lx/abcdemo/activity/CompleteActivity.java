package com.lx.abcdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.CompleteAdapter;
import com.lx.abcdemo.info.Order;

import java.util.ArrayList;
import java.util.List;

public class CompleteActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private ImageView back;
    private CompleteAdapter adapter;
    private List<Order> orders;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        initView();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("我的订单");
        back = (ImageView) findViewById(R.id.include_bar_ivBack);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.complete_listView);
        orders = new ArrayList<>();
        addData();
    }
    public void addData(){
        for (int i = 0;i<3;i++){
            orders.add(new Order(12345678+i,R.drawable.babosi,"长城哈弗M4扶手箱H1M2绚丽C2专用汽车" +
                    "中央手扶箱改装配件"+i,26.0,18,50,""));
        }
        adapter = new CompleteAdapter(this,orders);
        listView.setAdapter(adapter);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.include_bar_ivBack:
                finish();
                break;
        }
    }
}
