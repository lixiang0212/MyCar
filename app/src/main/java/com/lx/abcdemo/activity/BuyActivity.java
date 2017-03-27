package com.lx.abcdemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.PagerBuyAdapter;
import com.lx.abcdemo.aliplay.AliPay;
import com.lx.abcdemo.fragment.FragmentBuy;
import com.lx.abcdemo.info.CarProduct;
import com.lx.abcdemo.info.Order;
import com.lx.abcdemo.view.CircleTextView;
import com.lx.abcdemo.view.CircleView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuyActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title,tv_size,tv_sum,tv_price,tv_total,tvTitle;
    private ImageView ivBack,ivLess,ivAdd;
    private CircleTextView circleTextView;
    private LinearLayout ll;
    private ViewPager pager;
    private View v;
    private PagerBuyAdapter pagerAdapter;
    private List<Fragment> fragments;
    private List<CircleView> circleViews;
    private Button bt_Go;
    private LayoutInflater inflater;
    private int id[]={R.drawable.aodi,R.drawable.babosi,R.drawable.asidunmading,R.drawable.baowo,R.drawable.beiqihuansu};
    private int cid[]={R.id.circle_0,R.id.circle_1,R.id.circle_2,R.id.circle_3,R.id.circle_4};
    private CarProduct car;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                circleTextView.setText((msg.arg1+1)+"");
                circleTextView.invalidate();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        car = (CarProduct) getIntent().getSerializableExtra("car");
        initView();
        initData();
        addView();
    }
    private void initView() {
        inflater = LayoutInflater.from(this);
        fragments = new ArrayList<>();
        circleViews = new ArrayList<>();
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("商品详情");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        circleTextView = (CircleTextView) findViewById(R.id.buy_circleTextView);
        ll = (LinearLayout) findViewById(R.id.include_bar_ll);
        ll.setBackgroundColor(getResources().getColor(R.color.colorBuy));
        pager = (ViewPager) findViewById(R.id.buy_viewPager);
        bt_Go = (Button) findViewById(R.id.buy_commodity_go);
        bt_Go.setOnClickListener(this);
        ivLess = (ImageView) findViewById(R.id.buy_commodity_less);
        ivLess.setOnClickListener(this);
        ivAdd = (ImageView) findViewById(R.id.buy_commodity_adds);
        ivAdd.setOnClickListener(this);
        tv_size = (TextView) findViewById(R.id.buy_commodity_size);
        tv_sum = (TextView) findViewById(R.id.buy_commodity_sum);
        tv_price = (TextView) findViewById(R.id.buy_commodity_price);
        tv_total = (TextView) findViewById(R.id.buy_commodity_total);
        tvTitle = (TextView) findViewById(R.id.buy_commodity_title);
        /*初始化当前界面的数据---从外面传进来的*/
        if (car!=null){
            tvTitle.setText(car.getName());
            tv_price.setText("¥"+car.getPrice());
            tv_total.setText("¥"+car.getPrice());
        }
    }
    private void initData(){
        for (int i = 0;i<5;i++){
            FragmentBuy fragment = new FragmentBuy();
            Bundle bundle = new Bundle();
            bundle.putInt("picId",id[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
            circleViews.add((CircleView) findViewById(cid[i]));
        }
        pagerAdapter = new PagerBuyAdapter(getSupportFragmentManager(),fragments);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                Message message = new Message();
                message.what=0;
                message.arg1 = position;
                handler.sendMessage(message);
                for (int i = 0;i<circleViews.size();i++){
                    CircleView view = circleViews.get(i);
                    view.setVisibility(View.VISIBLE);
                    if(i==position){
                        view.setColor(getResources().getColor(R.color.colorYellow));
                        view.invalidate();
                    }else {
                        view.setColor(getResources().getColor(R.color.colorGro));
                        view.invalidate();
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        /*初始化下标小球的颜色*/
        for (int i = 0;i<circleViews.size();i++){
            CircleView view = circleViews.get(i);
            view.setVisibility(View.VISIBLE);
            if(i==0){view.setColor(getResources().getColor(R.color.colorYellow));view.invalidate();}
            else {view.setColor(getResources().getColor(R.color.colorGro));view.invalidate();}
        }
    }
    /*AlertDialog的自定义视图和监听*/
    private void addView() {
        v = inflater.inflate(R.layout.inflate_buy_go,null);
        TextView zhi = (TextView) v.findViewById(R.id.inflate_buy_zhi);
        TextView wei = (TextView) v.findViewById(R.id.inflate_buy_wei);
        zhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BuyActivity.this,"支付宝",Toast.LENGTH_SHORT).show();
                AliPay aliPay = new AliPay(BuyActivity.this,BuyActivity.this);
                aliPay.payV2();
            }
        });
        wei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BuyActivity.this,"微信",Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*按钮监听*/
    @Override
    public void onClick(View view) {
        String s = tv_size.getText().toString();
        int size = Integer.parseInt(s);
        String a = tv_price.getText().toString();
        String b = a.substring(1,a.length());
        double price = Double.parseDouble(b);
        double total;
        switch (view.getId()){
            case R.id.buy_commodity_go:
//               new AlertDialog.Builder(this)
//                       .setTitle("请选择结算方式")
//                       .setNegativeButton("取消",null)
//                       .setView(v).create().show();
                Intent intent = new Intent();
                intent.setClass(BuyActivity.this, PayActivity.class);
                startActivity(intent);
                break;
            case R.id.buy_commodity_less:
                if (size>0){
                    size--;
                    tv_size.setText(size+"");
                    tv_sum.setText(size+"个");
                    total =mul(price,size);
                    tv_total.setText("¥"+total);
                }
                break;
            case R.id.buy_commodity_adds:
                if (size>=0){
                    size++;
                    tv_size.setText(size+"");
                    tv_sum.setText(size+"个");
                    total =mul(price,size);
                    tv_total.setText("¥"+total);
                }
                break;
            case R.id.include_bar_ivBack:
                finish();
                break;
        }
    }
    /*单位换算*/
    public static double mul(double d,int n){
        BigDecimal bd = new BigDecimal(Double.toString(d));
        BigDecimal bd2 = new BigDecimal(n);
        return bd.multiply(bd2).doubleValue();
    }
}
