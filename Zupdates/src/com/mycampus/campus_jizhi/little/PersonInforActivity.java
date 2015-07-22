package com.mycampus.campus_jizhi.little;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easemob.chatuidemo.DemoApplication;
import com.jizhi.base.user.domain.SchoolUser;
import com.mycampus.campus_jizhi.R;
import com.mycampus.campus_jizhi.bean.UserBean;

public class PersonInforActivity extends Activity {
	private RelativeLayout rl_nick;
	private RelativeLayout rl_gender;
	private RelativeLayout rl_love;
	private RelativeLayout rl_birthday;
	final public int CODE = 0x771;
	final public int CODE2 = 0x772;
	private String judge_love="";
	private String judge_gender = "";
	private TextView gender;
	private TextView love;
	private TextView nickname;
	private TextView birthday;
	private UserBean userbean;
	private SchoolUser schooluser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_personal_infor);
		super.onCreate(savedInstanceState);
		schooluser=DemoApplication.getInstance().getUser();
	
		userbean=new UserBean(this);
		//昵称..............
		nickname=(TextView)findViewById(R.id.nick);
		nickname.setText("hhs");     //schooluser.getNickName(),下面那些settext都是用于动态变化的，而且xml还没改
		rl_nick = (RelativeLayout) findViewById(R.id.edit_nick);
		rl_nick.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						ChangeNickNameActivity.class);
				startActivity(intent);
			}
		});
		//性别................
		gender = (TextView) findViewById(R.id.gender);
		gender.setText("男");//	schooluser.getLove();
		rl_gender = (RelativeLayout) findViewById(R.id.edit_gender);
		rl_gender.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				judge_gender = gender.getText().toString();
				if ("男".equals(judge_gender)) {
					ChangeGenderActivity.comp = 1;
				}
				if ("女".equals(judge_gender)) {
					ChangeGenderActivity.comp = 0;
				}

				Intent intent = new Intent(PersonInforActivity.this,
						ChangeGenderActivity.class);
				startActivityForResult(intent, CODE);

			}
		});
		//恋爱.............
		love=(TextView)findViewById(R.id.love);
		love.setText("单身");//schooluser.getGender();
		rl_love=(RelativeLayout)findViewById(R.id.edit_love);
		rl_love.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				judge_love = love.getText().toString();
				if ("单身".equals(judge_love)) {
					ChangeLoveActivity.comp2=1;
				}
				if ("热恋中".equals(judge_love)) {
					ChangeLoveActivity.comp2=0;
				}if ("已婚".equals(judge_love)) {
					ChangeLoveActivity.comp2=2;
				}

				Intent intent = new Intent(PersonInforActivity.this,
						ChangeLoveActivity.class);
				startActivityForResult(intent, CODE2);

			}
		});
		//生日................
		birthday=(TextView)findViewById(R.id.birthday);	
		birthday.setText("1993-09-08");//schooluser.getBirthday();,long型的，转换成日期填上去。
		rl_birthday=(RelativeLayout)findViewById(R.id.edit_birthday);
		rl_birthday.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calendar c=Calendar.getInstance();
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 String time=birthday.getText().toString();
				 try { 
					Date date=format.parse(time);
					Calendar ca=Calendar.getInstance();
					ca.setTime(date);
					
					int myear=ca.get(ca.YEAR);
					int mmonth=ca.get(ca.MONTH)+1;//+1
					int mday=ca.get(ca.DAY_OF_MONTH);
					
				
					c.set(myear,mmonth-1,mday);//要－1,用于后面的操作c.MONTH
				 } catch (ParseException e) {
				
					e.printStackTrace();
				}
			
            Mydpdl dp= new Mydpdl(PersonInforActivity.this, new Mydpdl.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						int correctmonth=monthOfYear+1;
						userbean.changeBirthday(year, correctmonth, dayOfMonth);
						birthday.setText(year+"-"+correctmonth+"-"+dayOfMonth);
						Log.d("", "correct"+correctmonth);
					}
				}, c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH));
            		dp.show();
			}
		});
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CODE && resultCode == CODE) {
			Bundle bundle = data.getExtras();
			gender.setText(bundle.getString("gender"));
		}if (requestCode == CODE2 && resultCode == CODE2) {
			Bundle bundle = data.getExtras();
			love.setText(bundle.getString("love"));
		}
	}

}
