package com.lx.abcdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class LocationUpdateActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName,etNumber,etAddress;
    private Button btYes,btBack;
    private TextView tvTitle;
    private ImageView ivBack;
    private UserSqlUtils sqlUtils;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_add);
        user = (User) getIntent().getSerializableExtra("user");
        initView();
        initUser();
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
        tvTitle.setText("修改地址");
        ivBack = (ImageView) findViewById(R.id.include_bar_ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(this);
        sqlUtils = new UserSqlUtils(this);
    }
    private void initUser() {
        if (user!=null){
            etName.setText(user.getName());
            etNumber.setText(user.getNumber());
            etAddress.setText(user.getAddress());
        }
    }
    @Override
    public void onClick(View view) {
        int id = user.getId();
        String name = etName.getText().toString();
        String number = etNumber.getText().toString();
        String address = etAddress.getText().toString();
        Intent intent = new Intent();
        intent.setClass(LocationUpdateActivity.this,LocationActivity.class);
        switch (view.getId()){
            case R.id.location_add_yes:
                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(number)||TextUtils.isEmpty(address)){
                    Toast.makeText(LocationUpdateActivity.this,"请输入正确的信息",Toast.LENGTH_SHORT).show();
                }else {
                    sqlUtils.updateUser(new User(name,number,address,id));
                    Toast.makeText(LocationUpdateActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
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
