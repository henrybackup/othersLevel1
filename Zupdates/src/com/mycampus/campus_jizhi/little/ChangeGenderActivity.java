package com.mycampus.campus_jizhi.little;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.easemob.chatuidemo.DemoApplication;
import com.jizhi.base.user.domain.SchoolUser;
import com.mycampus.campus_jizhi.R;
import com.mycampus.campus_jizhi.bean.UserBean;

public class ChangeGenderActivity extends Activity {

	private RelativeLayout rl_boy;
	private RelativeLayout rl_girl;
	public static int comp;
	private String gender = "";
	private static ImageView img_boy;
	private static ImageView img_girl;
	private SchoolUser schooluser;
	private UserBean userbean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_gender);
		schooluser = DemoApplication.getInstance().getUser();
		userbean = new UserBean(this);
	
		img_boy = (ImageView) findViewById(R.id.check_pic_boy);
		img_girl = (ImageView) findViewById(R.id.check_pic_girl);
		rl_boy = (RelativeLayout) findViewById(R.id.rly_boy);
		rl_girl = (RelativeLayout) findViewById(R.id.rly_girl);
		rl_boy.setOnClickListener(listener);
		rl_girl.setOnClickListener(listener);
		if (comp == 1) {
			img_boy.setImageResource(R.drawable.cakecolor);
			img_girl.setImageResource(0);
		}
		if (comp == 0) {
			img_girl.setImageResource(R.drawable.cakecolor);
			img_boy.setImageResource(0);
		
		}

		Log.d("", "--------2*-------");
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			RelativeLayout rl = (RelativeLayout) v;
			switch (rl.getId()) {
			case R.id.rly_boy:
				gender = "男";
				img_boy.setImageResource(R.drawable.cakecolor);//纯粹为了增强用户体验 ，下面这三行																 
				img_girl.setImageResource(0);
				userbean.changeGender(gender);
				comp = 1;
				break;
			case R.id.rly_girl:
				gender = "女";
				img_girl.setImageResource(R.drawable.cakecolor);//纯粹为了增强用户体验 ，下面这三行
				img_boy.setImageResource(0);
				userbean.changeGender(gender);
				comp = 0;
				break;
			}
			Bundle bundle = new Bundle();
			bundle.putCharSequence("gender", gender);
			Intent intent = getIntent();
			Log.d("", "--------3*-------");
			intent.putExtras(bundle);
			setResult(0x771, intent);
			finish();
		}
	};

}
