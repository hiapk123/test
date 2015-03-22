package com.baiyi.parttimejobs.activity;

import java.util.List;
import java.util.Map;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.myviews.JobLists;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;//�����õ�λ�����ѹ��ܣ���Ҫimport����
//���ʹ�õ���Χ�����ܣ���Ҫimport������
import com.baidu.location.BDGeofence;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.location.GeofenceClient;
import com.baidu.location.GeofenceClient.OnAddBDGeofencesResultListener;
import com.baidu.location.GeofenceClient.OnGeofenceTriggerListener;
import com.baidu.location.GeofenceClient.OnRemoveBDGeofencesResultListener;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.platform.comapi.map.m;
/*
 * ��ҵ��ְ����
 */
public class ManageJobActivity extends BaseActivity {
	private LinearLayout mLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_jobs);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		initView();
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		JobLists jobLists = new JobLists(getApplicationContext());
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "ccccccccccccccccccccccccccccccccccc");
		
		jobLists.setTypeText("����");
		jobLists.setAddrText("�ɶ�");
		jobLists.setDateText("2015-03-15");
		jobLists.setCountText("10");
		jobLists.setStatusText("���ͨ��");
		jobLists.setOnClickListener(jobLists);
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "ddddddddddddddddddddddddddddddddddddd");
		LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		mLayout.addView(jobLists, params);
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		JobLists jobsLists1 = new JobLists(getApplicationContext());
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "ccccccccccccccccccccccccccccccccccc");
		
		jobsLists1.setTypeText("����");
		jobsLists1.setAddrText("�ɶ�");
		jobsLists1.setDateText("2015-03-15");
		jobsLists1.setCountText("10");
		jobsLists1.setStatusText("���ͨ��");
		jobsLists1.setOnClickListener(jobsLists1);
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "ddddddddddddddddddddddddddddddddddddd");
		
		mLayout.addView(jobsLists1, params);
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

	}

	private void initView() {
		mLayout = (LinearLayout) findViewById(R.id.manage_list_jobs_content);
	}

	public void onMyToggleBtnListener(View v) {

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in Action Bar clicked; go home
			Intent intent = new Intent(this, HomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
