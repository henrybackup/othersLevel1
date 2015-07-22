package com.example.zbitmaptest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img = (ImageView) findViewById(R.id.img_bit);

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.skrillex1);
		//img.setImageBitmap(getRoundCornerImage(bitmap, 50));
		img.setImageBitmap(getCircleImage(bitmap));
	}

	public static Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
		// 创建一个和原始图片一样大小位图
		Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		// 创建带有位图roundConcerImage的画布
		Canvas canvas = new Canvas(roundConcerImage);
		// 创建画笔
		Paint paint = new Paint();
		// 创建一个和原始图片一样大小的矩形
		Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		RectF rectF = new RectF(rect);
		// 去锯齿
		paint.setAntiAlias(true);
		// 画一个和原始图片一样大小的圆角矩形
		canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
		// 设置相交模式

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		// 把图片画到矩形去
		canvas.drawBitmap(bitmap, null, rect, paint);

		return roundConcerImage;
	}

	public static Bitmap getCircleImage(Bitmap bitmap) {
		Bitmap circleImg = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(circleImg);
		Paint paint = new Paint();
	 
		paint.setAntiAlias(true);
		canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
				bitmap.getHeight() / 2, paint);
		
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap,0,0, paint);//设定它的左上角在哪里.
	
	

		return circleImg;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
