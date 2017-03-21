package com.lx.abcdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.activity.LookActivity;
import com.lx.abcdemo.adapter.ListCAdapter;
import com.lx.abcdemo.adapter.ListCTAdapter;
import com.lx.abcdemo.info.Car;
import com.lx.abcdemo.info.CarC;
import com.lx.abcdemo.manager.DataCManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment {
    private TextView textView;
    private EditText editText;
    private ListView lv_time,lv_data;
    private ListCAdapter adapter;
    private ListCTAdapter adapterT;
    private String name,title;
    private List<CarC> data;
    private DataCManager manager;
    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        name = getArguments().getString("name");
        title = getArguments().getString("title");
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        manager = DataCManager.getInstance();
        data = new ArrayList<>();
        textView = (TextView) view.findViewById(R.id.fragment_c_tv);
        if (!TextUtils.isEmpty(name)){textView.setText(name);}
        editText = (EditText) view.findViewById(R.id.fragment_c_et);
        editText.setHintTextColor(getResources().getColor(R.color.colorWhite));
        lv_time = (ListView) view.findViewById(R.id.fragment_c_listView);
        lv_data = (ListView) view.findViewById(R.id.fragment_c_listViewT);
        adapter = new ListCAdapter(getActivity(), manager.getTimeData());
        lv_time.setAdapter(adapter);
        data = manager.getCarCData();
        adapterT = new ListCTAdapter(getActivity(),data);
        lv_data.setAdapter(adapterT);
        lv_time.setDividerHeight(0);
        lv_time.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                data = manager.getCarCData();
                adapterT = new ListCTAdapter(getActivity(),data);
                lv_data.setAdapter(adapterT);
                adapter.setPosition(i);
                adapter.notifyDataSetInvalidated();
            }
        });
        lv_data.setDividerHeight(1);
        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CarC c = data.get(i);
                String s = title+"-"+c.getSize()+"-"+c.getKind();
                Intent intent = new Intent();
                intent.setClass(getActivity(), LookActivity.class);
                intent.putExtra("title",s);
                startActivity(intent);
            }
        });
    }
}
