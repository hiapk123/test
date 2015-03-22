package com.baiyi.parttimejobs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/*
 * 自定义了theme之后，不能通过配置文件设置没有actionbar,通过程序来设计
 */
public class NoActionBarActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
}
