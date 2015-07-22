package com.example.hsmsbackup;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.entities.SmsInfo;

public class MainActivity extends Activity {
	private Button backup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("aaaaaaaaaaaaa", "act");
		backup = (Button) findViewById(R.id.backup);

		backup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				backupSms();

			}
		});
		Log.d("aaaaaaaaaaaaa", "??");
	}

	public void backupSms() {
		Uri uri = Uri.parse("content//sms/");
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(uri, new String[] { "_id", "address",
				"date", "type", "body" }, null, null, null);
		List<SmsInfo> smsInfoslist = new ArrayList<SmsInfo>();
		Log.d("aaaaaaaaaaaaa", "backup");
		if (cursor != null && cursor.getCount() > 0) {

			SmsInfo smsInfo;
			while (cursor.moveToNext()) {
				smsInfo = new SmsInfo();
				smsInfo.setId(cursor.getInt(cursor.getColumnIndex("_id")));
				smsInfo.setAddress(cursor.getString(cursor
						.getColumnIndex("address")));
				smsInfo.setBody(cursor.getString(cursor.getColumnIndex("body")));
				smsInfo.setDate(cursor.getLong(cursor.getColumnIndex("date")));
				smsInfo.setType(cursor.getInt(cursor.getColumnIndex("type")));
				smsInfoslist.add(smsInfo);
			}
			cursor.close();
			writeToLocal(smsInfoslist);
		}
	}

	private void writeToLocal(List<SmsInfo> smsList) {
		Log.d("aaaaaaaaaaaaa", "write");
		try {
			XmlSerializer serializer = Xml.newSerializer(); // 得到序列化对象
			// 指定输出位置
			FileOutputStream fos = new FileOutputStream("/mnt/sdcard/sms.xml");
			serializer.setOutput(fos, "utf-8");

			serializer.startDocument("utf-8", true);

			serializer.startTag(null, "smss");

			for (SmsInfo smsInfo : smsList) {
				serializer.startTag(null, "sms");
				serializer.attribute(null, "id",
						String.valueOf(smsInfo.getId()));

				// 写号码
				serializer.startTag(null, "address");
				serializer.text(smsInfo.getAddress());
				serializer.endTag(null, "address");

				// 写时间
				serializer.startTag(null, "date");
				serializer.text(String.valueOf(smsInfo.getDate()));
				serializer.endTag(null, "date");

				// 写类型
				serializer.startTag(null, "type");
				serializer.text(String.valueOf(smsInfo.getType()));
				serializer.endTag(null, "type");

				// 写内容
				serializer.startTag(null, "body");
				serializer.text(smsInfo.getBody());
				serializer.endTag(null, "body");

				serializer.endTag(null, "sms");
			}

			serializer.endTag(null, "smss");

			serializer.endDocument();

			Toast.makeText(this, "备份成功", 0).show();
		} catch (Exception e) {
			Toast.makeText(this, "备份失败", 0).show();
			e.printStackTrace();
		}

	}

}
