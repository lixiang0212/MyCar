package com.lx.abcdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.lx.abcdemo.R;

/**
 * Created by lixiang on 2017/3/22.
 */

public class CircleTextView extends View {
    private Paint paint;
    private int bgColor;
    private float circleSize;
    private float textSize,textSize1;
    private int textColor,textColor1;
    private String text,text1;
    public CircleTextView(Context context) {
        this(context,null);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
       this(context, attrs,0);
    }

    public CircleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView);
        bgColor = array.getColor(R.styleable.CircleTextView_bgColor, Color.parseColor("#ffffff"));
        textColor = array.getColor(R.styleable.CircleTextView_textColor ,Color.parseColor("#ffffff"));
        textColor1 = array.getColor(R.styleable.CircleTextView_textColor1,Color.parseColor("#ffffff"));
        circleSize = array.getDimension(R.styleable.CircleTextView_circleSize,15);
        textSize = array.getDimension(R.styleable.CircleTextView_textSize,15);
        textSize1 = array.getDimension(R.styleable.CircleTextView_textSize1,15);
        text = array.getString(R.styleable.CircleTextView_text);
        text1 = array.getString(R.styleable.CircleTextView_text1);
        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth()/2;
        int y = getHeight()/2;
        float r = circleSize;
        paint.setColor(bgColor);
        canvas.drawCircle(x,y,r,paint);
        ///////////////////////

        paint.setStrokeWidth(0);
        paint.setColor(textColor);
        paint.setTextSize(textSize);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        String s = text;
        String s1 = text1;
        float width = paint.measureText(s);
        float width1 = paint.measureText(s+s1);
        if(width<getWidth()) {
            canvas.drawText(s, x - width1/2,  y+textSize/3 , paint);
        }
        paint.setStrokeWidth(0);
        paint.setColor(textColor1);
        paint.setTextSize(textSize1);
        paint.setTypeface(Typeface.DEFAULT);
        if(width<getWidth()) {
            canvas.drawText(s1, x+width-width1/2,  y+textSize/3 , paint);
        }
        paint.reset();
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public float getCircleSize() {
        return circleSize;
    }

    public void setCircleSize(float circleSize) {
        this.circleSize = circleSize;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getTextSize1() {
        return textSize1;
    }

    public void setTextSize1(float textSize1) {
        this.textSize1 = textSize1;
    }

    public int getTextColor1() {
        return textColor1;
    }

    public void setTextColor1(int textColor1) {
        this.textColor1 = textColor1;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
}
