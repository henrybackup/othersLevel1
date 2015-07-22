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
		 webview.getSettings().setJavaScriptEnabled(true);//����WebView���ԣ��ܹ�ִ��Javascript�ű� 
		 webview.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);//�Զ���Ӧwebview�Ĵ�С���ǳ���Ҫ����
		webview.loadUrl("http://172.16.102.43:8080/campus_jizhi/campusinfor_test.action");
		 webview.setWebViewClient(new WebViewClient()); 
		
	}
	 public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {  
	            webview.goBack(); //goBack()��ʾ����WebView����һҳ��  ��������ֱ���뿪webview��һ��Ҫ��д�������
	            return true;  
	        }  
	        return false;  
	    }  
	         
	    //Ϊ����WebView�ܹ���Ӧ�����ӹ��ܣ�����setWebViewClient( )����������  WebView��ͼ
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
