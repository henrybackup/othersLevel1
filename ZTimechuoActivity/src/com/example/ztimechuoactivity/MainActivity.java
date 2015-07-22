package com.example.ztimechuoactivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
private TextView show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 show=(TextView)findViewById(R.id.qwe);
	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 String time="1970-02-06";
	 try { 
		Date date=format.parse(time);
		Calendar ca=Calendar.getInstance();
		ca.setTime(date);
		show.setText(String.valueOf(ca.get(ca.YEAR))+String.valueOf(ca.get(ca.MONTH))+String.valueOf(ca.get(ca.DAY_OF_MONTH)));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	Date date = null;
//	try {
//		date = format.parse(time);
//	} catch (ParseException e) {
//		
//		e.printStackTrace();
//	}
//	 long aaa=date.getTime();
	

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
