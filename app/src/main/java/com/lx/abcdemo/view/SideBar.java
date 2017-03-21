package com.lx.abcdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.lx.abcdemo.R;

/**
 * Created by lixiang on 2017/3/3.
 */

public class SideBar extends View {
    private int currentId=-1;
    private Paint paint = new Paint();
    private TextView showId;
    private OnTouchingListener onTouchingListener;
    private String id[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public void setShowId(TextView showId) {
        this.showId = showId;
    }
    public void setOnTouchingListener(OnTouchingListener onTouchingListener) {
        this.onTouchingListener = onTouchingListener;
    }
    private Handler handler = new Handler();
    //构造方法
    public SideBar(Context context) {
        super(context);
    }
    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public SideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取焦点改变背景颜色.
        int height = getHeight();// 获取对应高度
        int width = getWidth(); // 获取对应宽度
        int singleHeight = height / id.length;// 获取每一个字母的高度
        for (int i = 0; i <id.length; i++) {
            paint.setColor(getResources().getColor(R.color.colorGroC));
            // paint.setColor(Color.WHITE);
            paint.setTypeface(Typeface.DEFAULT);
            paint.setAntiAlias(true);
            paint.setTextSize(45);
            // 选中的状态
            if (i == currentId) {
                paint.setColor(Color.parseColor("#3399ff"));
                paint.setTextSize(45);
                paint.setFakeBoldText(true);
            }
            // x坐标等于中间-字符串宽度的一半.
            float xPos = width / 2 - paint.measureText(id[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(id[i], xPos, yPos, paint);
            paint.reset();// 重置画笔
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final float y = event.getY();// 点击y坐标
        final int oldChoose = currentId;
        final OnTouchingListener listener = onTouchingListener;
        final int c = (int) (y / getHeight() * id.length);// 点击y坐标所占总高度的比例*b数组的长度就等于点击b中的个数.
        switch (action) {
            case MotionEvent.ACTION_UP:
               // setBackgroundDrawable(new ColorDrawable(0x00000000));
                currentId = -1;//
                invalidate();
                if (showId != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        showId.setVisibility(View.INVISIBLE);
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
                break;
            default:
             //   setBackgroundResource(R.drawable.sidebar_background);
                if (oldChoose != c) {
                    if (c >= 0 && c < id.length) {
                        if (listener != null) {
                            listener.onTouching(id[c]);
                        }
                        if (showId != null) {
                            showId.setText(id[c]);
                            showId.setVisibility(View.VISIBLE);
                        }
                        currentId= c;
                        invalidate();
                    }}break;
        }
        return true;
    }

    public interface OnTouchingListener{
         void onTouching(String s);
    }
}
