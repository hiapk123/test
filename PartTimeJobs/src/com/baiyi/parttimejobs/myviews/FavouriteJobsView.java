package com.baiyi.parttimejobs.myviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.baiyi.parttimejobs.R;

/*
 * 猜你喜欢
 */
public class FavouriteJobsView extends LinearLayout {

	private void initView() {

		title = (TextView) findViewById(R.id.user_home_company_name);
		date = (TextView) findViewById(R.id.user_home_publish_date);
		disance=(TextView) findViewById(R.id.user_home_distance);
		salary = (TextView) findViewById(R.id.user_home_salary);
		remark = (TextView) findViewById(R.id.user_home_job_remark);
		mRatingBar = (RatingBar) findViewById(R.id.user_home_ratingbar);
		mLinearLayoutRight = (LinearLayout) findViewById(R.id.user_home_panel_right);
		mLinearLayoutLeft = (LinearLayout) findViewById(R.id.user_home_panel_left);
	}

	public FavouriteJobsView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater.from(getContext()).inflate(
				R.layout.user_home_favourite_jobs, this, true);
		initView();

	}

	public FavouriteJobsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(getContext()).inflate(
				R.layout.user_home_favourite_jobs, this, true);
		initView();

	}

	public FavouriteJobsView(Context context) {
		super(context);
		LayoutInflater.from(getContext()).inflate(
				R.layout.user_home_favourite_jobs, this, true);
		initView();

	}

	public TextView title;// 兼职标题
	public float score;// 评分
	public TextView date;// 时间
	public TextView salary;// 薪资
	public TextView remark;// 评论个数
	public TextView disance;// 距离
	public RatingBar mRatingBar;// 评论

	public LinearLayout mLinearLayoutRight;// 图片容器
	public LinearLayout mLinearLayoutLeft;// 左侧容器,根据左侧的高度设置右侧图片的高度

}
