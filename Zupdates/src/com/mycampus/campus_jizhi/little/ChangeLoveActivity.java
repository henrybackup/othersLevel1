package com.mycampus.campus_jizhi.little;

import com.easemob.chatuidemo.DemoApplication;
import com.jizhi.base.user.domain.SchoolUser;
import com.mycampus.campus_jizhi.R;
import com.mycampus.campus_jizhi.bean.UserBean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ChangeLoveActivity extends Activity {
	private RelativeLayout rl_single;
	private RelativeLayout rl_loving;
	private RelativeLayout rl_married;
	public static int comp2;
	private String love = "";
	private static ImageView img_single;
	private static ImageView img_loving;
	private static ImageView img_married;
	private SchoolUser schooluser;
	private UserBean userbean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_love);
		schooluser = DemoApplication.getInstance().getUser();
		userbean = new UserBean(this);
		img_single = (ImageView) findViewById(R.id.check_pic_single);
		img_loving = (ImageView) findViewById(R.id.check_pic_loving);
		img_married = (ImageView) findViewById(R.id.check_pic_married);
		rl_single = (RelativeLayout) findViewById(R.id.rly_single);
		rl_loving = (RelativeLayout) findViewById(R.id.rly_loving);
		rl_married = (RelativeLayout) findViewById(R.id.rly_married);
		
		rl_single.setOnClickListener(listener);
		rl_loving.setOnClickListener(listener);
		rl_married.setOnClickListener(listener);
		if (comp2 == 1) {
			img_single.setImageResource(R.drawable.cakecolor);
			img_loving.setImageResource(0);
			img_married.setImageResource(0);
		}
		if (comp2 == 0) {
			img_single.setImageResource(0);
			img_loving.setImageResource(R.drawable.cakecolor);
			img_married.setImageResource(0);
		
		}if (comp2 == 2) {
			img_single.setImageResource(0);
			img_loving.setImageResource(0);
			img_married.setImageResource(R.drawable.cakecolor);
		
		}

	
		
	}
	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			RelativeLayout rl = (RelativeLayout) v;
			switch (rl.getId()) {
			case R.id.rly_single:
				love = "光棍";
				img_single.setImageResource(R.drawable.cakecolor);           //纯粹为了增强用户体验 ，下面这三行	
				img_loving.setImageResource(0);
				img_married.setImageResource(0);
				userbean.changeGender(love);
				comp2 = 1;
				break;
			case R.id.rly_loving:
				love = "热恋中";
				img_single.setImageResource(0);								//纯粹为了增强用户体验 ，下面这三行	
				img_loving.setImageResource(R.drawable.cakecolor);
				img_married.setImageResource(0);
				userbean.changeGender(love);
				comp2 = 0;
				break;
			case R.id.rly_married:
				love = "已婚";
				img_single.setImageResource(0);                              //纯粹为了增强用户体验 ，下面这三行	
				img_loving.setImageResource(0);
				img_married.setImageResource(R.drawable.cakecolor);
				userbean.changeGender(love);
				comp2 = 2;
				break;
			}
			Bundle bundle = new Bundle();
			bundle.putCharSequence("love", love);
			Intent intent = getIntent();
			Log.d("", "--------3*-------");
			intent.putExtras(bundle);
			setResult(0x772, intent);
			finish();
		}
	};
}
