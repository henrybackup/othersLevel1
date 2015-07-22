package com.example.hdestorycloth;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnTouchListener {
	private ImageView imageView;
	private Bitmap bmCopy;
	private Bitmap bmSrc;
	private Paint paint;
	private Canvas canvas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bmSrc = BitmapFactory.decodeResource(getResources(),
				R.drawable.headhunterzzz);
		bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(),
				bmSrc.getConfig());
		paint = new Paint();
		paint.setStrokeWidth(7);
	
		canvas = new Canvas(bmCopy);
		canvas.drawBitmap(bmSrc, new Matrix(), paint);
		imageView = (ImageView) findViewById(R.id.iv);
		imageView.setImageBitmap(bmCopy);
		imageView.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			break;
		case MotionEvent.ACTION_MOVE:
			int x = (int) event.getX();
			int y = (int) event.getY();
//超屌的边界判断+圆心内判断~freestyle！
			for (int i = -8; i < 8; i++) {
				for (int j = -8; j < 8; j++) {
					// 计算某个像素是否在园内
					if ((Math.sqrt(j * j + i * i) <= 8)
							&& ((x + i) < bmCopy.getWidth())
							&& ((y + j) < bmCopy.getHeight()) && ((y + j) > 0)
							&& ((x + i) > 0)) {
						bmCopy.setPixel(x + i, y + j, Color.TRANSPARENT);

					}
				}

			}

			imageView.setImageBitmap(bmCopy);
			break;
		case MotionEvent.ACTION_UP:

			break;

		default:
			break;
		}

		return true;
	}

}
