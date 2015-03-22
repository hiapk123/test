package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends BaseActivity {
	private Button homePublishJobs;//发布兼职
	private Button homeManageJobs;//兼职管理

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initView();
		MyBtnOnclickListener mOnclickListener = new MyBtnOnclickListener();
		// 快速发布兼职事件
		homePublishJobs.setOnClickListener(mOnclickListener);
		//兼职管理
		homeManageJobs.setOnClickListener(mOnclickListener);
	}

	// 初始化系统组件
	private void initView() {

		homePublishJobs = (Button) findViewById(R.id.home_publish_jobs);
		homeManageJobs=(Button) findViewById(R.id.home_manage_jobs);
	}

	class MyBtnOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (v == homePublishJobs) {//快速发布兼职
				Intent intent = new Intent(getApplicationContext(),
						QuickPublishJobs.class);
				startActivity(intent);
			}else if(v==homeManageJobs){//兼职管理
				Intent intent = new Intent(getApplicationContext(),
						ManageJobActivity.class);
				startActivity(intent);
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
