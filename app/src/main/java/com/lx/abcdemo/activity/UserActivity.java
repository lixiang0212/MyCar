package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lx.abcdemo.R;

public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.user_out);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.user_out:
                Intent intent = new Intent();
                intent.setClass(UserActivity.this,LoginPActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
