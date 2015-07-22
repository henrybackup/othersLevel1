package com.mycampus.campus_jizhi.little;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;

public class Mydpdl extends DatePickerDialog {
	int myear;
	int mmonth;
	int mday;
		public Mydpdl(Context context, OnDateSetListener callBack, int year,
				int monthOfYear, int dayOfMonth) {
			super(context, callBack, year, monthOfYear, dayOfMonth);
			// TODO Auto-generated constructor stub
			Calendar calendar=Calendar.getInstance();
		myear=calendar.get(Calendar.YEAR)-1;
		mmonth=12;  
		mday=31;
		Log.d("init", myear+"-"+mmonth+"-"+mday);

		}

		@SuppressLint("NewApi")
		@Override
		public void onDateChanged(DatePicker view, int year, int month, int day) {
			// TODO Auto-generated method stub
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			
			 String mintime="1920-1-1";
			 String  maxtime=String.valueOf(myear)+"-"+String.valueOf(mmonth)+"-"+String.valueOf(mday);
				try {
					Date maxdate=format.parse(maxtime);
					Date mindate=format.parse(mintime);
			            view.setMaxDate(maxdate.getTime());
			        	view.setMinDate(mindate.getTime());
			        

				} catch (ParseException e) {
			
					e.printStackTrace();
				}
		
			
		}

		

		@Override
		protected void onStop() {
		
		}



}
