package com.example.zgenderradiotest;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
private Button submit;
private TextView gender;
final public int CODE=0x777;
private String first="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
	
		gender=(TextView)findViewById(R.id.gender);
		gender.setText("ÄÐ");
		submit=(Button)findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				first=gender.getText().toString();
				if ("ÄÐ".equals(first)) {
					GenderChoose.comp=1;
				}if ("Å®".equals(first)) {
					GenderChoose.comp=0;
				}
			
				Intent intent=new Intent(MainActivity.this, GenderChoose.class);
			
				startActivityForResult(intent, CODE);
			
		
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==CODE&&resultCode==CODE) {
		
		    Bundle bundle=data.getExtras();
			gender.setText(bundle.getString("gender"));
		}

	}
	

}
