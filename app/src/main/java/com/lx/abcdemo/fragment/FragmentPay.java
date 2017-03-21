package com.lx.abcdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.PayAdapter;
import com.lx.abcdemo.info.Order;

import java.util.ArrayList;
import java.util.List;

public class FragmentPay extends Fragment {
    private ListView listView;
    private PayAdapter adapter;
    private String status;
    private List<Order> orders;
    public FragmentPay() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        status = getArguments().getString("status");
        Log.i("AAA","status"+status);
        return inflater.inflate(R.layout.fragment_pay, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.fragment_pay_listView);
        orders = new ArrayList<>();
        for (int i = 0;i<2;i++){
            orders.add(new Order(123456789+i,R.drawable.babosi,"长城哈弗M4扶手箱H1M2绚丽C2专用" +
                    "汽车中央手扶箱改装配件",26.8,23,0,status));
        }
        adapter =new PayAdapter(getActivity(),orders);
        listView.setAdapter(adapter);
        listView.setDividerHeight(0);
    }
}
