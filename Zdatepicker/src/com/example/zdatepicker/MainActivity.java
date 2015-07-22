package com.example.zdatepicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.widget.DatePicker;

public class MainActivity extends Activity {
private DatePicker picker;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		picker=(DatePicker)findViewById(R.id.date_picker);
	
		picker.setCalendarViewShown(false);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String mintime="2010-10-10";
		String  maxtime="2016-09-08";
			try {
				Date maxdate=format.parse(maxtime);
				Date mindate=format.parse(mintime);
			
				picker.setMaxDate(maxdate.getTime());
				picker.setMinDate(mindate.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
