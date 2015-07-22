package com.example.zdraw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;

public class Myview extends View {

	public Myview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}


	public Myview(Context context, AttributeSet attrs) {//一定要有！
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setStyle(paint.getStyle().STROKE);
		paint.setAntiAlias(true);//抗锯齿，更清晰
		paint.setColor(Color.RED);
		paint.setStrokeWidth(2);//描边的宽度
		paint.setStrokeJoin(Join.BEVEL);//画笔转弯处的风格
		paint.setShadowLayer(10, 10, 10, Color.rgb(180, 180, 180));//设置阴影，1.radius=0没有阴影，其他两个是xy的偏移量
		paint.setStrokeCap(Cap.ROUND);//线的端点
		Shader shader=new LinearGradient(0, 0, 50, 50, Color.RED, Color.GREEN,TileMode.MIRROR);
		paint.setShader(shader);
		canvas.drawRect(150, 130, 300, 300, paint);
		canvas.rotate(30);
		canvas.drawRect(150, 130, 300, 300, paint);
		
		//----------------------------------------------
//		Path CCWRectpath = new Path();  
//		RectF rect1 =  new RectF(50, 50, 240, 200);  
//	    CCWRectpath.addRect(rect1, Direction.CCW);   
//		//第二个顺向生成  
//		Path CWRectpath = new Path();  
//		RectF rect2 =  new RectF(290, 50, 480, 200);  
//		CWRectpath.addRect(rect2, Direction.CW);  
//		  
//		//先画出这两个路径   
//		canvas.drawPath(CCWRectpath, paint);  
//		canvas.drawPath(CWRectpath, paint);  
	//------------------------------------------
		
	}

}
