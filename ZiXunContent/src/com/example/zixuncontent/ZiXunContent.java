package com.example.zixuncontent;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ZiXunContent extends Activity {
	private WebView webview; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zi_xun_content);
		 webview = (WebView) findViewById(R.id.z_webView);
		 webview.getSettings().setJavaScriptEnabled(true);//设置WebView属性，能够执行Javascript脚本 
		 webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);//自动适应webview的大小，非常重要！！
		webview.loadUrl("http://172.16.102.43:8080/campus_jizhi/campusinfor_test.action");
		 webview.setWebViewClient(new WebViewClient()); 
		
	}
	 public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {  
	            webview.goBack(); //goBack()表示返回WebView的上一页面  ，而不会直接离开webview，一定要重写这个方法
	            return true;  
	        }  
	        return false;  
	    }  
	         
	    //为了让WebView能够响应超链接功能，调用setWebViewClient( )方法，设置  WebView视图
	    private class HelloWebViewClient extends WebViewClient {  
	        @Override 
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {  
	            view.loadUrl(url);  
	            return true;  
	        }  
	    }  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zi_xun_content, menu);
		return true;
	}

}
