package com.example.jpushexample;

import cn.jpush.android.api.JPushInterface;
import android.app.Application;

public class MyApplication extends Application {
@Override
public void onCreate() {

	super.onCreate();
	System.out.println("初始化");
	 JPushInterface.setDebugMode(true);
	    JPushInterface.init(this);
}
}
