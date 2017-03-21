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

public class LoginPActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private TextView title,kind;
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
        kind.setOnClickListener(this);
        kind.setText("验证码登陆");
        phone = (EditText) findViewById(R.id.login_etPhoneP);
        phone.setHintTextColor(getResources().getColor(R.color.colorLogin));
        pass = (EditText) findViewById(R.id.login_etPassP);
        pass.setHintTextColor(getResources().getColor(R.color.colorLogin));
        pass.setHint("请输入密码");
        login = (Button) findViewById(R.id.login_btLoginP);
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
                intent.setClass(LoginPActivity.this,LoginCActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login_btLoginP:
                intent.setClass(LoginPActivity.this,UserActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
