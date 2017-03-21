package com.lx.abcdemo.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.OrderPagerAdapter;
import com.lx.abcdemo.fragment.FragmentBuy;
import com.lx.abcdemo.fragment.FragmentPay;
import com.lx.abcdemo.info.Order;

import java.util.ArrayList;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvPay,tvWait,tvGet,tvAfter,title;
    private ImageView iv1,iv2,iv3,iv4,back;
    private Drawable a,a1,b,b1,c,c1,d,d1;
    private ViewPager viewPager;
    private OrderPagerAdapter adapter;
    private List<Fragment> fragments;
    private String s[]={"待付款","待发货","待收货","售后"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        initView();
        initDrawable();
        initPager();
    }


    private void initView() {
        tvPay = (TextView) findViewById(R.id.myOrder_pay);
        tvPay.setOnClickListener(this);
        tvWait = (TextView) findViewById(R.id.myOrder_wait);
        tvWait.setOnClickListener(this);
        tvGet = (TextView) findViewById(R.id.myOrder_get);
        tvGet.setOnClickListener(this);
        tvAfter = (TextView) findViewById(R.id.myOrder_after);
        tvAfter.setOnClickListener(this);
        iv1= (ImageView) findViewById(R.id.myOrder_line1);
        iv2= (ImageView) findViewById(R.id.myOrder_line2);
        iv3= (ImageView) findViewById(R.id.myOrder_line3);
        iv4= (ImageView) findViewById(R.id.myOrder_line4);
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("我的订单");
        back = (ImageView) findViewById(R.id.include_bar_ivBack);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        fragments = new ArrayList<>();
    }
    private void initPager() {
        viewPager = (ViewPager) findViewById(R.id.myOrder_viewPager);
        for (int i = 0;i<4;i++){
            FragmentPay b = new FragmentPay();
            Bundle bundle = new Bundle();
            bundle.putString("status",s[i]);
            b.setArguments(bundle);
            fragments.add(b);
            Log.i("AAA",s[i]);
        }
        adapter = new OrderPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tvPay.setCompoundDrawables(null,a,null,null);
                        tvWait.setCompoundDrawables(null,b1,null,null);
                        tvGet.setCompoundDrawables(null,c1,null,null);
                        tvAfter.setCompoundDrawables(null,d1,null,null);
                        tvPay.setTextColor(getResources().getColor(R.color.colorYellow));
                        tvWait.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvGet.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvAfter.setTextColor(getResources().getColor(R.color.colorBlank));
                        iv1.setVisibility(View.VISIBLE);
                        iv2.setVisibility(View.INVISIBLE);
                        iv3.setVisibility(View.INVISIBLE);
                        iv4.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        tvPay.setCompoundDrawables(null,a1,null,null);
                        tvWait.setCompoundDrawables(null,b,null,null);
                        tvGet.setCompoundDrawables(null,c1,null,null);
                        tvAfter.setCompoundDrawables(null,d1,null,null);
                        tvPay.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvWait.setTextColor(getResources().getColor(R.color.colorYellow));
                        tvGet.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvAfter.setTextColor(getResources().getColor(R.color.colorBlank));
                        iv1.setVisibility(View.INVISIBLE);
                        iv2.setVisibility(View.VISIBLE);
                        iv3.setVisibility(View.INVISIBLE);
                        iv4.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        tvPay.setCompoundDrawables(null,a1,null,null);
                        tvWait.setCompoundDrawables(null,b1,null,null);
                        tvGet.setCompoundDrawables(null,c,null,null);
                        tvAfter.setCompoundDrawables(null,d1,null,null);
                        tvPay.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvWait.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvGet.setTextColor(getResources().getColor(R.color.colorYellow));
                        tvAfter.setTextColor(getResources().getColor(R.color.colorBlank));
                        iv1.setVisibility(View.INVISIBLE);
                        iv2.setVisibility(View.INVISIBLE);
                        iv3.setVisibility(View.VISIBLE);
                        iv4.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        tvPay.setCompoundDrawables(null,a1,null,null);
                        tvWait.setCompoundDrawables(null,b1,null,null);
                        tvGet.setCompoundDrawables(null,c1,null,null);
                        tvAfter.setCompoundDrawables(null,d,null,null);
                        tvPay.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvWait.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvGet.setTextColor(getResources().getColor(R.color.colorBlank));
                        tvAfter.setTextColor(getResources().getColor(R.color.colorYellow));
                        iv1.setVisibility(View.INVISIBLE);
                        iv2.setVisibility(View.INVISIBLE);
                        iv3.setVisibility(View.INVISIBLE);
                        iv4.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initDrawable() {
        a = getResources().getDrawable(R.drawable.pending_payment_selected);
        a.setBounds(0,0,a.getMinimumWidth(),a.getMinimumWidth());
        a1 = getResources().getDrawable(R.drawable.pending_payment_normal);
        a1.setBounds(0,0,a1.getMinimumWidth(),a1.getMinimumWidth());
        b = getResources().getDrawable(R.drawable.wait_ship_selected);
        b.setBounds(0,0,b.getMinimumWidth(),b.getMinimumWidth());
        b1 = getResources().getDrawable(R.drawable.wait_ship_normal);
        b1.setBounds(0,0,b1.getMinimumWidth(),b1.getMinimumWidth());
        c = getResources().getDrawable(R.drawable.wait_receipt_selected);
        c.setBounds(0,0,c.getMinimumWidth(),c.getMinimumWidth());
        c1 = getResources().getDrawable(R.drawable.wait_receipt_normal);
        c1.setBounds(0,0,c1.getMinimumWidth(),c1.getMinimumWidth());
        d = getResources().getDrawable(R.drawable.after_sale_selected);
        d.setBounds(0,0,d.getMinimumWidth(),d.getMinimumWidth());
        d1 = getResources().getDrawable(R.drawable.after_sale_normal);
        d1.setBounds(0,0,d1.getMinimumWidth(),d1.getMinimumWidth());
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.myOrder_pay:
                tvPay.setCompoundDrawables(null,a,null,null);
                tvWait.setCompoundDrawables(null,b1,null,null);
                tvGet.setCompoundDrawables(null,c1,null,null);
                tvAfter.setCompoundDrawables(null,d1,null,null);
                tvPay.setTextColor(getResources().getColor(R.color.colorYellow));
                tvWait.setTextColor(getResources().getColor(R.color.colorBlank));
                tvGet.setTextColor(getResources().getColor(R.color.colorBlank));
                tvAfter.setTextColor(getResources().getColor(R.color.colorBlank));
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.INVISIBLE);
                iv4.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(0);
                break;
            case R.id.myOrder_wait:
                tvPay.setCompoundDrawables(null,a1,null,null);
                tvWait.setCompoundDrawables(null,b,null,null);
                tvGet.setCompoundDrawables(null,c1,null,null);
                tvAfter.setCompoundDrawables(null,d1,null,null);
                tvPay.setTextColor(getResources().getColor(R.color.colorBlank));
                tvWait.setTextColor(getResources().getColor(R.color.colorYellow));
                tvGet.setTextColor(getResources().getColor(R.color.colorBlank));
                tvAfter.setTextColor(getResources().getColor(R.color.colorBlank));
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.VISIBLE);
                iv3.setVisibility(View.INVISIBLE);
                iv4.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(1);
                break;
            case R.id.myOrder_get:
                tvPay.setCompoundDrawables(null,a1,null,null);
                tvWait.setCompoundDrawables(null,b1,null,null);
                tvGet.setCompoundDrawables(null,c,null,null);
                tvAfter.setCompoundDrawables(null,d1,null,null);
                tvPay.setTextColor(getResources().getColor(R.color.colorBlank));
                tvWait.setTextColor(getResources().getColor(R.color.colorBlank));
                tvGet.setTextColor(getResources().getColor(R.color.colorYellow));
                tvAfter.setTextColor(getResources().getColor(R.color.colorBlank));
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.VISIBLE);
                iv4.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(2);
                break;
            case R.id.myOrder_after:
                tvPay.setCompoundDrawables(null,a1,null,null);
                tvWait.setCompoundDrawables(null,b1,null,null);
                tvGet.setCompoundDrawables(null,c1,null,null);
                tvAfter.setCompoundDrawables(null,d,null,null);
                tvPay.setTextColor(getResources().getColor(R.color.colorBlank));
                tvWait.setTextColor(getResources().getColor(R.color.colorBlank));
                tvGet.setTextColor(getResources().getColor(R.color.colorBlank));
                tvAfter.setTextColor(getResources().getColor(R.color.colorYellow));
                iv1.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.INVISIBLE);
                iv3.setVisibility(View.INVISIBLE);
                iv4.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(3);
                break;
            case R.id.include_bar_ivBack:
                finish();
                break;
        }
    }
}
