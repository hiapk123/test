package com.baiyi.parttimejobs.myviews;

import com.baiyi.parttimejobs.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class LookHistory extends LinearLayout {

	public LookHistory(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater.from(getContext()).inflate(
				R.layout.quick_publish_jobs_history_list, this, true);
	}

	public LookHistory(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(getContext()).inflate(
				R.layout.quick_publish_jobs_history_list, this, true);
	}

	public LookHistory(Context context) {
		super(context);
		LayoutInflater.from(getContext()).inflate(
				R.layout.quick_publish_jobs_history_list, this, true);
	}
}
