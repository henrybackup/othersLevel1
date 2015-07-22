package com.example.ztimedialogversion2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
public class MainActivity extends Activity {
private TextView tx;
private Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tx=(TextView)findViewById(R.id.qwe);
		tx.setText("1993-09-08");
		bt=(Button)findViewById(R.id.asd);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c=Calendar.getInstance();
				
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 String time=tx.getText().toString();
				 try { 
					Date date=format.parse(time);
					Calendar ca=Calendar.getInstance();
					ca.setTime(date);
				
					int myear=ca.get(ca.YEAR);
					int mmonth=ca.get(ca.MONTH)+1;//+1
					int mday=ca.get(ca.DAY_OF_MONTH);
				
					c.set(myear,mmonth-1,mday);//าชฃญ1
				 } catch (ParseException e) {
				
					e.printStackTrace();
				}
			
						
				MYdpdl dp= new MYdpdl(MainActivity.this, new MYdpdl.OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub						
						int correctmonth=monthOfYear+1;
						tx.setText(year+"-"+correctmonth+"-"+dayOfMonth);				
						
					}
				}  , c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH));
		
				
				dp.show();
			
			
			
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
