package com.example.zdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageview extends ImageView {

	public MyImageview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyImageview(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyImageview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Rect rect=canvas.getClipBounds();
		rect.bottom--;
		rect.right--;
		Paint paint=new Paint();
		paint.setColor(Color.GRAY);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(5);
		canvas.drawRect(rect, paint);
		
		
	}

}
