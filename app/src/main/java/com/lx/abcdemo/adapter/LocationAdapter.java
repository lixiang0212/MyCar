package com.lx.abcdemo.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lx.abcdemo.R;
import com.lx.abcdemo.activity.LocationUpdateActivity;
import com.lx.abcdemo.info.User;
import com.lx.abcdemo.interfaces.ClickA;
import com.lx.abcdemo.sharedpre.UserLocation;
import com.lx.abcdemo.sqlite.UserSqlUtils;
import java.util.List;

/**
 * Created by lixiang on 2017/3/13.
 */

public class LocationAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<User> users;
    private int id = -1;
    private ClickA clickA;
    private UserSqlUtils sqlUtils;
    private UserLocation location;
    private User u;
    public void setClickA(ClickA clickA) {
        this.clickA = clickA;
    }

    public LocationAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
        inflater=LayoutInflater.from(context);
        sqlUtils = new UserSqlUtils(context);
        location = new UserLocation(context);
        u = location.getUser(context);
        id=u.getId();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setPosition(int i){
        id=i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        TempHolder temp = null;
        if(view==null){
            temp = new TempHolder();
            view = inflater.inflate(R.layout.inflate_location_item,null);
            temp.tvName = (TextView) view.findViewById(R.id.location_item_tvName);
            temp.tvNumber = (TextView) view.findViewById(R.id.location_item_tvNumber);
            temp.tvAddress = (TextView) view.findViewById(R.id.location_item_tvAddress);
            temp.tvDefault = (TextView) view.findViewById(R.id.location_item_default);
            temp.tvUpdate = (TextView) view.findViewById(R.id.location_item_tvSet);
            temp.tvDelete = (TextView) view.findViewById(R.id.location_item_tvDelete);
            temp.iv = (ImageView) view.findViewById(R.id.location_item_defaultIcon);
            temp.defaultA = (TextView) view.findViewById(R.id.location_item_defaultAddress);
            temp.r= (RelativeLayout) view.findViewById(R.id.location_item_relative);
            view.setTag(temp);
        }else {
            temp = (TempHolder) view.getTag();
        }
        final User user = users.get(i);
        temp.tvName.setText(user.getName());
        temp.tvNumber.setText(user.getNumber());
        temp.tvAddress.setText(user.getAddress());
        if (id==i){
            user.setSelected(true);
            temp.tvDefault.setVisibility(View.VISIBLE);
            temp.iv.setImageResource(R.drawable.selected);
            temp.r.setBackgroundResource(R.drawable.location_item_relative);
        }else {
            user.setSelected(false);
            temp.tvDefault.setVisibility(View.GONE);
            temp.iv.setImageResource(R.drawable.normal);
            temp.r.setBackgroundResource(R.color.colorWhite);
        }
        temp.tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, LocationUpdateActivity.class);
                intent.putExtra("user",user);
                context.startActivity(intent);
            }
        });
        temp.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("删除改用户？")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int idd) {
                                sqlUtils.deleteUser(user.getId());
                                users.remove(i);
                                notifyDataSetChanged();
                            }})
                        .create().show();
            }
        });
        temp.defaultA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickA.onClick(i);
                user.setSelected(true);
                location.saveUser(user,context,i);
            }
        });
        return view;
    }
    private class TempHolder{
        private TextView tvName,tvNumber,tvDefault,tvAddress,tvUpdate,tvDelete,defaultA;
        private ImageView iv;
        private RelativeLayout r;
    }

}
