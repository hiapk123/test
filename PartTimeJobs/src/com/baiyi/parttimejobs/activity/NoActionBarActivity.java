package com.baiyi.parttimejobs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/*
 * �Զ�����theme֮�󣬲���ͨ�������ļ�����û��actionbar,ͨ�����������
 */
public class NoActionBarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
}
