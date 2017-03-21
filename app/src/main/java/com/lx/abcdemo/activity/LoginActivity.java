package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.lx.abcdemo.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private TextView title,kind,getCode;
    private EditText phone,code,pass,pass2;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        kind.setText("验证码登陆");
        kind.setOnClickListener(this);
        phone = (EditText) findViewById(R.id.login_etPhone);
        phone.setHintTextColor(getResources().getColor(R.color.colorLogin));
        code = (EditText) findViewById(R.id.login_etCode);
        code.setHintTextColor(getResources().getColor(R.color.colorLogin));
        getCode = (TextView) findViewById(R.id.login_getCode);
        getCode.setOnClickListener(this);
        pass = (EditText) findViewById(R.id.login_etPassword);
        pass.setHintTextColor(getResources().getColor(R.color.colorLogin));
        pass2 = (EditText) findViewById(R.id.login_etPasswordT);
        pass2.setHintTextColor(getResources().getColor(R.color.colorLogin));
        login = (Button) findViewById(R.id.login_btLogin);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.include_bar_ivBack:
                finish();
                break;
            case R.id.include_bar_add:
                intent.setClass(LoginActivity.this,LoginCActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login_getCode:

                break;
            case R.id.login_btLogin:
                intent.setClass(LoginActivity.this,UserActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }
}
