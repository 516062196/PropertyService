package com.property.glory.propertyservice.utils;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author 走马灯textview
 */
public class MarqueeText extends TextView implements Runnable {
    private int currentScrollX;// 当前滚动的位置
    private boolean isStop = false;
    private int textWidth;
    private boolean isMeasure = false;
int i=0,adnum=0;
private OnclickInterface onclickinterface;

	public OnclickInterface getOnclickinterface() {
		return onclickinterface;
	}

	public void setOnclickinterface(OnclickInterface onClickListener) {
		this.onclickinterface = onClickListener;
	}
    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    public MarqueeText(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isMeasure) {
            getTextWidth(this.getText().toString());
            isMeasure = true;
        }
    }

    public int getTextWidth(String str) {
        Paint paint = this.getPaint();
    
        return textWidth = (int) paint.measureText(str);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        this.isMeasure = false;
    }

    @Override
    public void run() {
        currentScrollX += 1;// 滚动速度
        scrollTo(currentScrollX/2, 0);
        if (isStop) {
            return;
        }
        if (getScrollX() >= textWidth) {
            scrollTo(-this.getWidth(), 0);
            currentScrollX = -this.getWidth();
            i++;
            if(i>=adnum){
            	i=0;
            }
        	onclickinterface.onclicks(i, 0,"3");
        }
        postDelayed(this, 10);
    }

    public void startScroll() {
        isStop = false;
        this.removeCallbacks(this);
        post(this);
        
    }

    public void stopScroll() {
        currentScrollX = 0;
        isStop = true;
    }

    public void startFor0(String str,int adnum) {
    	this.adnum=adnum;
    	this.setText(str);
  	  this.getTextWidth(str);
        currentScrollX = 0;
        startScroll();
    }
    public interface OnclickInterface {
		public void onclicks(int position, int flag, String evalType);
	}
}
