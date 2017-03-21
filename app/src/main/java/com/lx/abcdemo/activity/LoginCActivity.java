package com.lx.abcdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.abcdemo.R;

public class LoginCActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private View view;
    private TextView title,kind,getCode;
    private EditText phone,pass;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_p);
        initView();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.include_bar_ivBack);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("登陆");
        kind = (TextView) findViewById(R.id.include_bar_add);
        kind.setVisibility(View.VISIBLE);
        kind.setText("密码登陆");
        kind.setOnClickListener(this);
        phone = (EditText) findViewById(R.id.login_etPhoneP);
        phone.setHintTextColor(getResources().getColor(R.color.colorLogin));
        pass = (EditText) findViewById(R.id.login_etPassP);
        pass.setHintTextColor(getResources().getColor(R.color.colorLogin));
        login = (Button) findViewById(R.id.login_btLoginP);
        login.setOnClickListener(this);
        getCode = (TextView) findViewById(R.id.login_getCodeP);
        getCode.setVisibility(View.VISIBLE);
        getCode.setOnClickListener(this);
        view = findViewById(R.id.login_p_view);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.include_bar_ivBack:
                finish();
                break;
            case R.id.include_bar_add:
                intent.setClass(LoginCActivity.this,LoginPActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login_btLoginP:
                intent.setClass(LoginCActivity.this,UserActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
