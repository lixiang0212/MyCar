package com.lx.abcdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lx.abcdemo.R;
import com.lx.abcdemo.adapter.ProductAdapter;
import com.lx.abcdemo.info.CarProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    private TextView title;
    private ImageView icon;
    private ListView listView;
    private ProductAdapter adapter;
    private List<CarProduct> cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initView();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.include_bar_title);
        title.setText("选择配件");
        icon = (ImageView) findViewById(R.id.include_bar_ivBack);
        icon.setVisibility(View.VISIBLE);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.product_listView);
        cars = new ArrayList<>();
        cars = initData();
        adapter = new ProductAdapter(this,cars);
        listView.setAdapter(adapter);
        listView.setDividerHeight(1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(ProductsActivity.this,BuyActivity.class);
                intent.putExtra("car",cars.get(i));
                startActivity(intent);
            }
        });
    }

    public List<CarProduct> initData(){
        List<CarProduct> c = new ArrayList<>();
        for (int i = 0;i<3;i++){
           c.add(new CarProduct(R.drawable.product,"长城哈弗M4手扶箱H1M2绚丽C2专用汽车中央手扶" +
                    "箱改装配件免配送费",18.5+i));
        }
        return c;
    }

}
