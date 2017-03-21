package com.lx.abcdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.Car;
import com.lx.abcdemo.info.Type;
import com.lx.abcdemo.interfaces.ClickA;
import com.lx.abcdemo.interfaces.GridClick;

import java.util.List;

/**
 * Created by lixiang on 2017/3/6.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Car> data,gridData;
    private ClickA clickA;
    private GridClick gridClick;

    public void setGridClick(GridClick gridClick) {
        this.gridClick = gridClick;
    }

    public void setClickA(ClickA clickA) {
        this.clickA = clickA;
    }

    public RecyclerAdapter(Context context, List<Car> data, List<Car> gridData) {
        this.context = context;
        this.data = data;
        this.gridData = gridData;
    }

    @Override
    public int getItemViewType(int position) {

       return data.get(position).getType();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case Type.TYPE_HEADER:
                viewHolder = onCreateHeaderViewHolder(parent);
                break;
            case Type.TYPE_TEMP:
                viewHolder = onCreateTempViewHolder(parent);
                break;
            case Type.TYPE_DATA:
                viewHolder = onCreateDataViewHolder(parent);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType){
            case Type.TYPE_HEADER:
                onBindHeaderViewHolder(holder,position);
                break;
            case Type.TYPE_TEMP:
                onBindTempViewHolder(holder,position);
                break;
            case Type.TYPE_DATA:
                onBindDataViewHolder(holder, position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /* --------------onCreateViewHolder.ViewHolder---------------*/
    private RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_header,parent,false);
        return new HeaderViewHolder(view);
    }
    private RecyclerView.ViewHolder onCreateTempViewHolder(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_temp,parent,false);
        return new TempViewHolder(view);
    }
    private RecyclerView.ViewHolder onCreateDataViewHolder(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_data,parent,false);
        return new DataViewHolder(view);
    }

    /* --------------onBindViewHolder.ViewHolder---------------*/
    private void onBindHeaderViewHolder(RecyclerView.ViewHolder holder,int position){
        Car car = data.get(position);
        ((HeaderViewHolder)holder).gridView.setAdapter(new GridAdapter(context,gridData));
        ((HeaderViewHolder)holder).gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    gridClick.Click(i);
            }
        });
    }
    private void onBindTempViewHolder(RecyclerView.ViewHolder holder,int position){
        Car car = data.get(position);
        ((TempViewHolder)holder).textView.setText(car.getName());
    }
    private void onBindDataViewHolder(RecyclerView.ViewHolder holder, final int position){
        Car car = data.get(position);
        ((DataViewHolder)holder).imageView.setImageResource(car.getPicId());
        ((DataViewHolder)holder).textView.setText(car.getName());
        ((DataViewHolder)holder).layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickA.onClick(position);
            }
        });
    }

    /* --------------RecyclerView.ViewHolder---------------*/
    private class HeaderViewHolder extends RecyclerView.ViewHolder{
        private GridView gridView;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            gridView= (GridView) itemView.findViewById(R.id.gridView);
        }
    }
    private class TempViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public TempViewHolder(View itemView) {
            super(itemView);
          textView = (TextView) itemView.findViewById(R.id.inflate_temp_name);
        }
    }
    private class DataViewHolder extends RecyclerView.ViewHolder{
        private  TextView textView;
        private ImageView imageView;
        private LinearLayout layout;
        public DataViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.inflate_data_name);
            imageView = (ImageView) itemView.findViewById(R.id.inflate_data_iv);
            layout = (LinearLayout) itemView.findViewById(R.id.inflate_data_linear);
        }
    }
    //返回字母的位置
    public int getLetterPosition(String letter){
        for (int i = 0;i<data.size();i++){
            if (data.get(i).getName().equals(letter)){
                return i;
            }
        }
        return -1;
    }
    // 清除所有数据
    public void clearAll(){
        if (data!=null){
            data.clear();
            notifyDataSetChanged();
        }
    }
    //添加数据
    public void addData(List<Car> cars){
        data.addAll(cars);
        notifyDataSetChanged();
    }
}
