package com.example.zupdates;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Practice {
	public static void filePractice() throws IOException {

		FileInputStream fs = new FileInputStream("haha.txt");
		byte[] by = new byte[1024];
		int len = 0;

		while (len != -1) {
			len = fs.read(by);
		}
		fs.close();
	}

	public void picPractice() throws IOException {

		FileInputStream fis = new FileInputStream("xx.png");
		byte[] btt = new byte[1024];
		int len = 0;
		while (len != -1) {
			len = fis.read(btt);
		}
		// Bitmap bmBitmap=BitmapFactory.decodeByteArray(btt, 0, length)
		// 直接decode inputstream
		Bitmap bitmap = BitmapFactory.decodeStream(fis);

	}

	public void copyPicPractice() throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		fos=new FileOutputStream("outto.png");
		fis=new FileInputStream("from.png");

		byte[] btt = new byte[1024];
		int len=0;
		//注意，数组是循环利用的
		while ((len=fis.read(btt))!=-1) {
			fos.write(btt, 0, len);
		}
		
		fos.close();
		fis.close();
		
	}
}
