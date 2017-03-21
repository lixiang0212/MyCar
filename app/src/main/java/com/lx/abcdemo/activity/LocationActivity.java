package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.LocationAdapter;
import com.lx.abcdemo.info.User;
import com.lx.abcdemo.interfaces.ClickA;
import com.lx.abcdemo.sqlite.UserSqlUtils;
import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvTitle,tvAdd;
    private ImageView ivBack;
    private ListView listView;
    private LocationAdapter adapter;
    private UserSqlUtils utils;
    private List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        initView();
        initData();
        Log.i("AAA","onCreate");
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.location_listView);
        tvTitle = (TextView) findViewById(R.id.include_bar_title);
        tvTitle.setText("收货地址");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        tvAdd = (TextView) findViewById(R.id.location_tvAdd);
        tvAdd.setOnClickListener(this);
        utils = new UserSqlUtils(this);
        users = new ArrayList<>();
        adapter = new LocationAdapter(this,users);
        listView.setDividerHeight(30);
        listView.setAdapter(adapter);
        adapter.setClickA(new ClickA() {
            @Override
            public void onClick(int id) {
                adapter.setPosition(id);
                adapter.notifyDataSetInvalidated();
            }
        });
    }
    private void initData() {
        users = utils.queryAll();
            if (users!=null){
            adapter = new LocationAdapter(this,users);
            adapter.setClickA(new ClickA() {
                    @Override
                    public void onClick(int id) {
                        adapter.setPosition(id);
                        adapter.notifyDataSetInvalidated();
                }
                });
            listView.setAdapter(adapter);
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Intent intent = new Intent();
//                    intent.setClass(LocationActivity.this,OrderActivity.class);
//                    intent.putExtra("user",users.get(i));
//                    startActivity(intent);
//                }
//            });
        }

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.include_bar_ivBack:
                finish();
                break;
            case R.id.location_tvAdd:
                Intent intent = new Intent();
                intent.setClass(LocationActivity.this,LocationAddActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("AAA","onRestart");
        utils = new UserSqlUtils(this);
        users = new ArrayList<>();
        users = utils.queryAll();
        if (users!=null){
            adapter = new LocationAdapter(this,users);
            adapter.setClickA(new ClickA() {
                @Override
                public void onClick(int id) {
                    adapter.setPosition(id);
                    adapter.notifyDataSetInvalidated();
                }
            });
            listView.setAdapter(adapter);
        }
    }
}
