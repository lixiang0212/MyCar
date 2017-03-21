package com.lx.abcdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lx.abcdemo.R;
import com.lx.abcdemo.activity.MainActivity;
import com.lx.abcdemo.adapter.RecyclerBAdapter;
import com.lx.abcdemo.info.Car;
import com.lx.abcdemo.info.CarB;
import com.lx.abcdemo.interfaces.ClickA;
import com.lx.abcdemo.manager.DataManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {
    private ImageView imageView;
    private EditText et_title;
    private TextView tv_name;
    private RecyclerView rView;
    private RecyclerBAdapter adapter;
    private List<CarB> data;
    private String name="aaa";
    private int picId=0;
    private MainActivity mainActivity;
    private DataManager dataManager;
    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        name = getArguments().getString("name");
        picId = getArguments().getInt("picId");
        Log.i("AAA","sname="+name+",sid="+picId);
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        dataManager = DataManager.getInstance();
        data = new ArrayList<>();
        imageView = (ImageView) view.findViewById(R.id.fragment_b_iv);
        imageView.setImageResource(picId);
        et_title = (EditText) view.findViewById(R.id.fragment_b_et);
        et_title.setHintTextColor(getResources().getColor(R.color.colorWhite));
        tv_name = (TextView) view.findViewById(R.id.fragment_b_selectedName);
        if(!TextUtils.isEmpty(name)){tv_name.setText(name);}
        rView = (RecyclerView) view.findViewById(R.id.recyclerViewB);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));
        data =  dataManager.initBData();
        adapter = new RecyclerBAdapter(getActivity(),data);
        rView.setAdapter(adapter);
        adapter.setClickA(new ClickA() {
            @Override
            public void onClick(int id) {
                if (mainActivity==null){
                    mainActivity = (MainActivity) getActivity();
                }
                CarB car =data.get(id);
                String s = car.getName();
                mainActivity.CanClick(2);
                mainActivity.setCurrentId(2,picId,name,s);
                FragmentC fragmentC = new FragmentC();
                Bundle bundle = new Bundle();
                bundle.putString("name",s);
                bundle.putString("title",name+"-"+s);
                fragmentC.setArguments(bundle);
                mainActivity.initFragmentRight(fragmentC);
            }
        });
    }
}
