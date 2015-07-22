package com.example.jpushexample;

import com.google.gson.Gson;

import cn.jpush.android.api.JPushInterface;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MyReceiver extends BroadcastReceiver {

	
	private String extras;
	private String extras2;

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		extras2 = bundle.getString(JPushInterface.EXTRA_EXTRA);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("我的广播接收者被调用了.");
		
		
		System.out.println("附件字段: " + extras2);
		
		// 跳转到指定的页面, 并打开对应的新闻.
		Gson gson=new Gson();
	
		Beansss bs=gson.fromJson(extras2, Beansss.class);
String aiString=bs.newsurl;
		
if (bs==null) {
	System.out.println("bs为空");
}
				System.out.println("myjson哈哈"+aiString);	
			}
		}).start();
		
		

	

}
}