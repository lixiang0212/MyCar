package com.lx.abcdemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.ListChooseAdapter;
import com.lx.abcdemo.adapter.ListChooseTAdapter;
import com.lx.abcdemo.manager.DataChooseManager;

public class ChooseActivity extends AppCompatActivity {
    private ListView aView,bView;
    private ImageView ivBack;
    private EditText editText;
    private ListChooseAdapter adapterA;
    private ListChooseTAdapter adapterB;
    private TextView title;
    private DataChooseManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        initView();
    }

    private void initView() {
        manager =DataChooseManager.getInstance();
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("选购配件");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        aView = (ListView) findViewById(R.id.choose_listView);
        bView = (ListView) findViewById(R.id.choose_listViewT);
        editText = (EditText) findViewById(R.id.choose_et);
        editText.setHintTextColor(Color.parseColor("#F0EFF5"));
        adapterA = new ListChooseAdapter(this, manager.getData());
        aView.setAdapter(adapterA);
        adapterB = new ListChooseTAdapter(ChooseActivity.this,manager.getTData(0));
        bView.setAdapter(adapterB);
        aView.setDividerHeight(1);
        aView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapterA.setPosition(i);
                adapterA.notifyDataSetInvalidated();
                adapterB = new ListChooseTAdapter(ChooseActivity.this,manager.getTData(i));
                bView.setAdapter(adapterB);
            }
        });
        bView.setDividerHeight(1);
        bView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapterB.setPosition(i);
                adapterB.notifyDataSetInvalidated();
                Intent intent = new Intent();
                intent.setClass(ChooseActivity.this,ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}
