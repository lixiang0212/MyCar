package com.lx.abcdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lx.abcdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLook extends Fragment {
    private int id=R.drawable.aodi;
    private ImageView imageView;
    public FragmentLook() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        id = getArguments().getInt("picId");
        return inflater.inflate(R.layout.fragment_look, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        imageView = (ImageView) view.findViewById(R.id.fragment_look_iv);
        imageView.setImageResource(id);
    }
}
