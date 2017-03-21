package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.PagerLookAdapter;
import com.lx.abcdemo.adapter.RecyclerLookBAdapter;
import com.lx.abcdemo.adapter.RecyclerLookSAdapter;
import com.lx.abcdemo.fragment.FragmentLook;
import com.lx.abcdemo.interfaces.ClickA;
import com.lx.abcdemo.manager.DataLookManager;
import com.lx.abcdemo.manager.DataManager;

import java.util.ArrayList;
import java.util.List;

public class LookActivity extends AppCompatActivity {
    private ImageView iv,ivBack;
    private RecyclerView sView;
    private RecyclerLookSAdapter adapterS;
    private PagerLookAdapter pagerLookAdapter;
    private TextView textView,titles;
    private String title;
    private List<Fragment> fragments;
    private ViewPager viewPager;
    private DataLookManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        title = getIntent().getStringExtra("title");
        setContentView(R.layout.activity_look);
        initView();
        addData();
    }

    private void initView() {
        manager = DataLookManager.getInstance();
        fragments = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.look_viewPager);
        iv = (ImageView) findViewById(R.id.look_iv);
        titles = (TextView) findViewById(R.id.include_bar_title);
        titles.setText("车身外观");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textView = (TextView) findViewById(R.id.look_show_selected);
        if (!TextUtils.isEmpty(title)){
            textView.setText(title);
        }
        sView = (RecyclerView) findViewById(R.id.look_sm_recyclerView);
        sView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterS = new RecyclerLookSAdapter(this,manager.getSData());
        sView.setAdapter(adapterS);
        adapterS.setClickA(new ClickA() {
            @Override
            public void onClick(int id) {
                adapterS.setPosition(id);
                adapterS.notifyDataSetChanged();
                viewPager.setCurrentItem(id);

            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent();
                intent.setClass(LookActivity.this,ChooseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addData(){
        List<Integer> data = manager.getData();
        for (int i = 0;i<data.size();i++){
            FragmentLook look = new FragmentLook();
            Bundle bundle = new Bundle();
            bundle.putInt("picId",data.get(i));
            look.setArguments(bundle);
            fragments.add(look);
        }
        pagerLookAdapter = new PagerLookAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(pagerLookAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                adapterS.setPosition(position);
                sView.scrollToPosition(position);
                adapterS.notifyDataSetChanged();
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
