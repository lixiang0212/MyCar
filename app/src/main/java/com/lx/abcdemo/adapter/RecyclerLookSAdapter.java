package com.lx.abcdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.interfaces.ClickA;
import java.util.List;

/**
 * Created by lixiang on 2017/3/8.
 */

public class RecyclerLookSAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Integer> data;
    private int id =0;
    private ClickA clickA;

    public void setClickA(ClickA clickA) {
        this.clickA = clickA;
    }

    public RecyclerLookSAdapter(Context context, List<Integer> data) {
        this.context = context;
        this.data = data;
    }
    public void setPosition(int position){
        id=position;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_look_sm_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int i= data.get(position);
        if(position==id){
            ((ViewHolder)holder).imageView.setBackground(context.getResources().getDrawable(R.drawable.frame_selected));
            ((ViewHolder)holder).imageView.setImageResource(i);
        }else {
            ((ViewHolder)holder).imageView.setBackground(context.getResources().getDrawable(R.drawable.frame_normal));
            ((ViewHolder)holder).imageView.setImageResource(i);
            ((ViewHolder)holder).imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickA.onClick(position);
                }
            });
        }

    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.inflate_look_sm_iv);
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
