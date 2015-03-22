package com.baiyi.parttimejobs.myviews;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.navisdk.ui.routeguide.subview.i;
import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.activity.JobDetailsActivity;

public class JobLists extends RelativeLayout implements OnClickListener {
	private TextView type, addr, date, count, status;

	public Button look, del;

	public JobLists(Context context) {
		super(context);
		LayoutInflater.from(getContext()).inflate(
				R.layout.manage_jobs_list_group, this, true);
		// 设置兼职类型的样式
		type = (TextView) findViewById(R.id.manage_list_jobs_type);
		type.setTextAppearance(getContext(),
				android.R.style.TextAppearance_Large);
		type.setTextColor(getResources().getColor(
				android.R.color.background_dark));

		addr = (TextView) findViewById(R.id.manage_list_jobs_addr);
		date = (TextView) findViewById(R.id.manage_list_jobs_publish_time);
		count = (TextView) findViewById(R.id.manage_list_jobs_reqiures);
		status = (TextView) findViewById(R.id.manage_list_jobs_status);
		// 按钮
		look = (Button) findViewById(R.id.manage_list_jobs_look);
		del = (Button) findViewById(R.id.manage_list_jobs_del);

		// look.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_green_light));
		// del.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_orange_light));
		Log.i("aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		// 设置按钮点击事件，查看按钮，点击进入兼职列表详细页面
		MyBtnListener mListener = new MyBtnListener();
		look.setOnClickListener(mListener);// 查看按钮
		del.setOnClickListener(mListener);// 删除按钮
	
	}

	// 监听器
	class MyBtnListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (v == look) {
				Intent intent=new Intent(getContext(),JobDetailsActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				getContext().startActivity(intent);
				
				Toast.makeText(getContext(), "Look!", Toast.LENGTH_SHORT)
						.show();
			} else if (v == del) {
				Toast.makeText(getContext(), "Delete!", Toast.LENGTH_SHORT)
						.show();
			}

		}

	}

	public void setTypeText(String text) {
		type.setText(text);
	}

	public void setAddrText(String text) {
		addr.setText(text);
	}

	public void setDateText(String text) {
		date.setText(text);
	}

	public void setCountText(String text) {
		count.setText(text);
	}

	public void setStatusText(String text) {
		status.setText(text);
	}

	@Override
	public void onClick(View view) {

		LinearLayout mLayout = (LinearLayout) findViewById(R.id.manage_list_jobs_operation);
		if (mLayout.getVisibility() == VISIBLE)
			mLayout.setVisibility(GONE);
		else
			mLayout.setVisibility(VISIBLE);

	}

}
