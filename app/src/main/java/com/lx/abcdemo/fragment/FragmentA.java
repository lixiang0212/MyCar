package com.lx.abcdemo.fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.activity.MainActivity;
import com.lx.abcdemo.adapter.RecyclerAdapter;
import com.lx.abcdemo.info.Car;
import com.lx.abcdemo.info.CharacterParser;
import com.lx.abcdemo.info.PinyinComparator;
import com.lx.abcdemo.interfaces.ClickA;
import com.lx.abcdemo.interfaces.GridClick;
import com.lx.abcdemo.manager.DataManager;
import com.lx.abcdemo.view.SideBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment{
    private SideBar sideBar;
    private TextView tv_letter;
    private ImageView iv1,iv2;
    private EditText editText;
    private List<Car> data,gridData;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private CharacterParser characterParser;
    private MainActivity mainActivity ;
    private DataManager dataManager;
    private LinearLayoutManager manager;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String s = (String) msg.obj;
                    if (TextUtils.isEmpty(s)||s.equals("")){
                        iv1.setVisibility(View.VISIBLE);
                        iv2.setVisibility(View.INVISIBLE);
                        adapter.clearAll();
                        adapter.addData(dataManager.initData());
                        recyclerView.setAdapter(adapter);
                    }else {
                        iv1.setVisibility(View.INVISIBLE);
                        iv2.setVisibility(View.VISIBLE);
                        selectData(s);
                    }break;
                case 1:
                    //没有输入字符的时候
                    iv1.setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.INVISIBLE);
                    adapter.clearAll();
                    adapter.addData(dataManager.initData());
                    recyclerView.setAdapter(adapter);
                    break;
            }
        }
    };
    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initAdapter();
        initEditText();
    }
    private void initView(View view) {
        dataManager = DataManager.getInstance();
        data = new ArrayList<>();
        gridData = new ArrayList<>();
        characterParser = new CharacterParser();
        iv1 = (ImageView) view.findViewById(R.id.fragment_a_findIv1);
        iv2 = (ImageView) view.findViewById(R.id.fragment_a_findIv2);
        iv2.setVisibility(View.INVISIBLE);
        tv_letter = (TextView) view.findViewById(R.id.sideBar_letter);
        editText = (EditText) view.findViewById(R.id.fragment_a_et);
        editText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        sideBar = (SideBar) view.findViewById(R.id.sideBar);
        sideBar.setShowId(tv_letter);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        sideBar.setOnTouchingListener(new SideBar.OnTouchingListener() {
            @Override
            public void onTouching(String s) {
                int position = adapter.getLetterPosition(s);
                if (position!=-1&&position>=0&&position<data.size()) {
                    //recyclerView.scrollToPosition(position);
                 //

                    //   manager.scrollToPosition(position);
                    manager.scrollToPositionWithOffset(position,0);
                   int a= manager.findFirstVisibleItemPosition();
                   int b = manager.findLastVisibleItemPosition();
                    Log.i("AAA",a+"a--"+"b"+b+"position"+position);
//                    if (position==b){
//                        manager.scrollToPosition(position+6);
//                    }
                }
            }
        });
        data = dataManager.initData();
        gridData = dataManager.initGridData();
    }
    private void initAdapter() {
        adapter = new RecyclerAdapter(getActivity(),data,gridData);
        recyclerView.setAdapter(adapter);
        adapter.setClickA(new ClickA() {
            @Override
            public void onClick(int id) {
                Clicked(1,id);
            }
        });
        adapter.setGridClick(new GridClick() {
            @Override
            public void Click(int id) {Clicked(0,id);
            }
        });
    }
    private void initEditText() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if(charSequence.length()>0){
                    Message msg = new Message();
                    String s = charSequence.toString();
                    msg.obj =s;
                    msg.what=0;
                    handler.sendMessage(msg);
                }else {
                    Message m = new Message();
                    m.what=1;
                    handler.sendMessage(m);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    /*动态添加输入车名的数据*/
    public void selectData(String name){
        List<Car> car = new ArrayList<>();
        List<Car> cars =dataManager.initData();
        car.clear();
        for (Car c:cars) {
            String s = c.getName();
            if (s.contains(name)||s.contains(name.toUpperCase()) ||s.toUpperCase().contains(name)
                    ||s.toUpperCase().contains(name.toUpperCase())
                    ||characterParser.getSelling(s).startsWith(name)){
                car.add(c);
            }
        }
        if(car.size()>0){
            Log.i("AAA","find data"+car.size());
            Collections.sort(car,new PinyinComparator());
         //   car.add(0,new Car(Type.TYPE_HEADER,""));
            adapter.clearAll();
            adapter.addData(car);
            recyclerView.setAdapter(adapter);
        }else {
            Log.i("AAA","not find data");
        }
    }
   /* 点击的类型*/
    public void Clicked(int kind,int id){
        if (mainActivity==null){
            mainActivity = (MainActivity) getActivity();
        }
        Car car=null;
        if(kind==0){car = gridData.get(id);}
        else if(kind==1){car = data.get(id);}
        String name = car.getName();
        int ids = car.getPicId();
        FragmentB fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        Log.i("AAA","name="+name+",id="+ids);
        bundle.putString("name",name);
        bundle.putInt("picId",ids);
        fragmentB.setArguments(bundle);
        mainActivity.initFragmentRight(fragmentB);
        mainActivity.setCurrentId(1,ids,name,"");
        mainActivity.CanClick(1);
    }

}
