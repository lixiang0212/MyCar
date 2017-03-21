package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lx.abcdemo.R;
import com.lx.abcdemo.info.User;
import com.lx.abcdemo.sqlite.UserSqlUtils;

public class LocationAddActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName,etNumber,etAddress;
    private Button btYes,btBack;
    private TextView tvTitle;
    private ImageView ivBack;
    private UserSqlUtils sqlUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_add);
        initView();
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.location_add_name);
        etNumber = (EditText) findViewById(R.id.location_add_number);
        etAddress = (EditText) findViewById(R.id.location_add_address);
        btYes = (Button) findViewById(R.id.location_add_yes);
        btYes.setOnClickListener(this);
        btBack = (Button) findViewById(R.id.location_add_back);
        btBack.setOnClickListener(this);
        tvTitle = (TextView) findViewById(R.id.include_bar_title);
        tvTitle.setText("编辑地址");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        sqlUtils = new UserSqlUtils(this);
    }

    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        String number = etNumber.getText().toString();
        String address = etAddress.getText().toString();
        Intent intent = new Intent();
        intent.setClass(LocationAddActivity.this,LocationActivity.class);
        switch (view.getId()){
            case R.id.location_add_yes:
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(number)||TextUtils.isEmpty(address)){
                    Toast.makeText(LocationAddActivity.this,"请输入正确的信息",Toast.LENGTH_SHORT).show();
                }else {
                    sqlUtils.addUser(new User(name,number,address));
                    Toast.makeText(LocationAddActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etNumber.setText("");
                    etAddress.setText("");
                }
                break;
            case R.id.location_add_back:
               // startActivity(intent);
                finish();
                break;
            case R.id.include_bar_ivBack:
              //  startActivity(intent);
                finish();
                break;
        }

    }
}
