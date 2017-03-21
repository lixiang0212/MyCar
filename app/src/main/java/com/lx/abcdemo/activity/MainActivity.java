package com.lx.abcdemo.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lx.abcdemo.fragment.FragmentA;
import com.lx.abcdemo.R;
import com.lx.abcdemo.fragment.FragmentB;
import com.lx.abcdemo.fragment.FragmentC;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentTransaction transaction;
    private EditText et_Oe,et_Number;
    private TextView tv_selected,tvOne,tvTwo,tvThree;
    private ImageView go1,go2,headerIcon;
    private View viewOne,viewTwo,viewThree,headerView;
    private int currentId=0,picId;
    private String name="",kind="";
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RelativeLayout hOrder,hOrderComplete,hAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initDrawerLayout();
        fragmentA = new FragmentA();
        getSupportFragmentManager().beginTransaction().addToBackStack("")
                .replace(R.id.frameLayout,fragmentA).commit();
    }
    /*动态设置当前显示的Fragment*/
    public void initFragment(Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.setCustomAnimations(R.anim.right,R.anim.right);
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }
    public void initFragmentRight(Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.setCustomAnimations(R.anim.left,R.anim.left);
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }
    /*初始化界面菜单和设置监听*/
    private void initDrawerLayout() {
        toolbar = (Toolbar) findViewById(R.id.main_toolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.person);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                initHeader();
            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
    /*侧滑界面的点击监听*/
    private void initHeader(){
        headerIcon = (ImageView) findViewById(R.id.header_icon);
        headerIcon.setOnClickListener(this);
        headerView = findViewById(R.id.header_view);
        headerView.setOnClickListener(this);
        hOrder = (RelativeLayout) findViewById(R.id.header_order);
        hOrder.setOnClickListener(this);
        hOrderComplete = (RelativeLayout) findViewById(R.id.header_orderComplete);
        hOrderComplete.setOnClickListener(this);
        hAddress = (RelativeLayout) findViewById(R.id.header_address);
        hAddress.setOnClickListener(this);
    }
   /* 初始化界面的控件*/
    private void initView() {
        et_Oe = (EditText) findViewById(R.id.et_OEFind);
        et_Number = (EditText) findViewById(R.id.et_numberFind);
        et_Oe.setHintTextColor(getResources().getColor(R.color.colorWhite));
        et_Number.setHintTextColor(getResources().getColor(R.color.colorWhite));
        tv_selected = (TextView) findViewById(R.id.main_tv_selected);
//        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/MicrosoftYaHei.ttf");
//        tv_selected.setTypeface(typeface);
        tvOne = (TextView) findViewById(R.id.tv_one);
        tvOne.setOnClickListener(this);
        tvOne.setClickable(false);
        tvTwo = (TextView) findViewById(R.id.tv_two);
        tvTwo.setOnClickListener(this);
        tvTwo.setClickable(false);
        tvThree = (TextView) findViewById(R.id.tv_three);
        viewOne = findViewById(R.id.v_one);
        viewTwo = findViewById(R.id.v_two);
        viewThree = findViewById(R.id.v_three);
        go1= (ImageView) findViewById(R.id.main_iv_go1);
        go1.setOnClickListener(this);
        go2= (ImageView) findViewById(R.id.main_iv_go2);
        go2.setOnClickListener(this);
        fragmentA = new FragmentA();
    }
    /*动态设置当前选择的车型*/
    public void setCurrentId(int id,int pic,String n,String k){
        currentId=id;
        picId=pic;
        name=n;
        kind=k;
        showTitle(id,n,k);
    }
    /*监听用户的返回键*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode ==  KeyEvent.KEYCODE_BACK){
            Log.i("AAA","back");
            if (currentId==3) {
                picId=0;name="";kind="";
                showTitle(0,name,kind);
                return super.onKeyDown(keyCode,event);
            }else if(currentId==2){
                kind="";currentId=1;
                setCurrentId(currentId,picId,name,kind);
                CanClick(1);
                fragmentB = new FragmentB();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putInt("picId",picId);
                fragmentB.setArguments(bundle);
                initFragment(fragmentB);
            }else if(currentId==1){
                picId=0;name="";kind="";
                currentId=0;
                setCurrentId(currentId,picId,name,kind);
                CanClick(0);
                fragmentA = new FragmentA();
                initFragment(fragmentA);
            }else if(currentId==0){
                finish();
            }
        }
//        return super.onKeyDown(keyCode,event);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=0,x1=0;
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            x=event.getX();
            Log.i("AAA","x"+x);
            }
        if(event.getAction()==MotionEvent.ACTION_MOVE){
            x1=event.getX();
            Log.i("AAA","x1"+x1);
            if (x1-x>120){
                if(currentId==1){
                    picId=0;name="";kind="";
                    currentId=0;
                    setCurrentId(currentId,picId,name,kind);
                    CanClick(0);
                    fragmentA = new FragmentA();
                    initFragment(fragmentA);
                }else if(currentId==2){
                    kind="";currentId=1;
                    setCurrentId(currentId,picId,name,kind);
                    CanClick(1);
                    fragmentB = new FragmentB();
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name);
                    bundle.putInt("picId",picId);
                    fragmentB.setArguments(bundle);
                    initFragment(fragmentB);
                }
            }
        }
        return true;
    }

    /*设置当前选择的车型*/
    public void showTitle(int id,String name,String kind){
        switch (id){
            case 0:
                tv_selected.setText(name);
                tvOne.setTextColor(getResources().getColor(R.color.colorYellow));
                tvTwo.setTextColor(getResources().getColor(R.color.colorGroT));
                tvThree.setTextColor(getResources().getColor(R.color.colorGroT));
                viewOne.setVisibility(View.VISIBLE);
                viewTwo.setVisibility(View.GONE);
                viewThree.setVisibility(View.GONE);
                break;
            case 1:
                tv_selected.setText(name);
                tvOne.setTextColor(getResources().getColor(R.color.colorGroT));
                tvTwo.setTextColor(getResources().getColor(R.color.colorYellow));
                tvThree.setTextColor(getResources().getColor(R.color.colorGroT));
                viewOne.setVisibility(View.GONE);
                viewTwo.setVisibility(View.VISIBLE);
                viewThree.setVisibility(View.GONE);
                break;
            case 2:
                tv_selected.setText(name+"-"+kind);
                tvOne.setTextColor(getResources().getColor(R.color.colorGroT));
                tvTwo.setTextColor(getResources().getColor(R.color.colorGroT));
                tvThree.setTextColor(getResources().getColor(R.color.colorYellow));
                viewOne.setVisibility(View.GONE);
                viewTwo.setVisibility(View.GONE);
                viewThree.setVisibility(View.VISIBLE);
                break;
            case 3:
                tv_selected.setText(name+"-"+kind);
                tvOne.setTextColor(getResources().getColor(R.color.colorGroT));
                tvTwo.setTextColor(getResources().getColor(R.color.colorGroT));
                tvThree.setTextColor(getResources().getColor(R.color.colorYellow));
                viewOne.setVisibility(View.GONE);
                viewTwo.setVisibility(View.GONE);
                viewThree.setVisibility(View.VISIBLE);
                break;
        }
    }
    /*动态设置标题是否可以点击*/
    public void CanClick(int i){
        if (i==0){
            tvOne.setClickable(false);
            tvTwo.setClickable(false);
        }else if(i==1){
            tvOne.setClickable(true);
            tvTwo.setClickable(false);
        }else if(i==2){
            tvOne.setClickable(true);
            tvTwo.setClickable(true);
        }
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.tv_one:
                currentId=0;name="";kind="";
                CanClick(0);
                showTitle(currentId,name,kind);
                fragmentA = new FragmentA();
                initFragment(fragmentA);
                break;
            case R.id.tv_two:
                currentId=1;kind="";
                CanClick(1);
                showTitle(currentId,name,kind);
                fragmentB = new FragmentB();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putInt("picId",picId);
                fragmentB.setArguments(bundle);
                initFragment(fragmentB);
                break;
            case R.id.main_iv_go1:
                intent.setClass(MainActivity.this,ChooseActivity.class);
                startActivity(intent);
                break;
            case R.id.main_iv_go2:
                currentId=3;name="奥迪";kind="奥迪Q7";
                showTitle(currentId,name,kind);
                FragmentC fragmentC = new FragmentC();
                Bundle bundle1 = new Bundle();
                bundle1.putString("name",kind);
                fragmentC.setArguments(bundle1);
                initFragment(fragmentC);
                break;
            case R.id.header_icon:
                intent.setClass(MainActivity.this,LoginActivity.class);startActivity(intent);break;
            case R.id.header_view:
                intent.setClass(MainActivity.this,LoginActivity.class);startActivity(intent);break;
            case R.id.header_order:
                intent.setClass(MainActivity.this,MyOrderActivity.class);startActivity(intent);break;
            case R.id.header_orderComplete:
                intent.setClass(MainActivity.this,CompleteActivity.class);startActivity(intent);break;
            case R.id.header_address:
                intent.setClass(MainActivity.this,LocationActivity.class);startActivity(intent);break;
        }
    }

}
