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


	public Myview(Context context, AttributeSet attrs) {//һ��Ҫ�У�
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
		paint.setAntiAlias(true);//����ݣ�������
		paint.setColor(Color.RED);
		paint.setStrokeWidth(2);//��ߵĿ��
		paint.setStrokeJoin(Join.BEVEL);//����ת�䴦�ķ��
		paint.setShadowLayer(10, 10, 10, Color.rgb(180, 180, 180));//������Ӱ��1.radius=0û����Ӱ������������xy��ƫ����
		paint.setStrokeCap(Cap.ROUND);//�ߵĶ˵�
		Shader shader=new LinearGradient(0, 0, 50, 50, Color.RED, Color.GREEN,TileMode.MIRROR);
		paint.setShader(shader);
		canvas.drawRect(150, 130, 300, 300, paint);
		canvas.rotate(30);
		canvas.drawRect(150, 130, 300, 300, paint);
		
		//----------------------------------------------
//		Path CCWRectpath = new Path();  
//		RectF rect1 =  new RectF(50, 50, 240, 200);  
//	    CCWRectpath.addRect(rect1, Direction.CCW);   
//		//�ڶ���˳������  
//		Path CWRectpath = new Path();  
//		RectF rect2 =  new RectF(290, 50, 480, 200);  
//		CWRectpath.addRect(rect2, Direction.CW);  
//		  
//		//�Ȼ���������·��   
//		canvas.drawPath(CCWRectpath, paint);  
//		canvas.drawPath(CWRectpath, paint);  
	//------------------------------------------
		
	}

}
