package com.lx.abcdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lx.abcdemo.R;

public class PayActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("支付中心");
        back = (ImageView) findViewById(R.id.include_bar_ivBack);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.include_bar_ivBack:
                finish();
                break;
        }
    }
}
