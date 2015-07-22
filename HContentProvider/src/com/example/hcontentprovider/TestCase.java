package com.example.hcontentprovider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

public class TestCase extends AndroidTestCase {
public void testInsert(){
	Uri uri=Uri.parse("content://com.example.hsqlitedemo.provider.PersonContentProvider/person/insert");
	// 内容提供者访问对象
			ContentResolver resolver = getContext().getContentResolver();
			 
			ContentValues values = new ContentValues();
			values.put("name", "fengjie");
			values.put("age", 90);
			
			uri = resolver.insert(uri, values);
			Log.i("aaaaaaaa", "uri: " + uri);
			long id = ContentUris.parseId(uri);
			Log.i("aaaaaaaa", "添加到: " + id);
	
}
}
