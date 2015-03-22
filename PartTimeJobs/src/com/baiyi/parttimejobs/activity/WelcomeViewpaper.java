package com.baiyi.parttimejobs.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.baiyi.parttimejobs.R;

public class WelcomeViewpaper extends BaseActivity implements View.OnClickListener,
		OnPageChangeListener {
	// 定义ViewPager对象
	private ViewPager mViewPager;
	// 定义ViewPagerAdapter
	private ViewPagerAdapter vpAdapter;
	// 存放view
	private ArrayList<View> views;
	// 引导图片资源
	private static final int[] pics = { R.drawable.user_home_guide1,
			R.drawable.user_home_guide2, R.drawable.user_home_guide3 };
	//最后一张图片资源的id

   private RadioButton button1;
   private RadioButton button2;
   private RadioButton button3;

   
   private RadioButton[] buttons={null,null,null};
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 不需要标题栏
		setContentView(R.layout.activity_welcome_viewpaper);
		mViewPager = (ViewPager) findViewById(R.id.ViewPager);
		initView();
		initData();
		 
		
		
	}

	/*
	 * 初始化view
	 */
	private void initView() {
		views = new ArrayList<View>();
		mViewPager = (ViewPager) findViewById(R.id.ViewPager);
		vpAdapter = new ViewPagerAdapter(views);
		
		button1=(RadioButton)this.findViewById(R.id.activity_welcome_cursor1);
		button2=(RadioButton)this.findViewById(R.id.activity_welcome_cursor2);
		button3=(RadioButton)this.findViewById(R.id.activity_welcome_cursor3);
		
		 buttons[0]=button1;
		 buttons[1]=button2;
		 buttons[2]=button3;
		 button1.setChecked(true);
	
		

	}

	/*
	 * 初始化数据
	 */
	private void initData() {
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
	
		for (int i = 0; i < pics.length; i++) {
			ImageView iv = new ImageView(getApplicationContext());
			iv.setScaleType(ScaleType.FIT_XY);
			iv.setLayoutParams(mParams);
			
			iv.setImageResource(pics[i]);
			views.add(iv);
		}
		
	  LayoutInflater inflater=this.getLayoutInflater();
	  View view=inflater.inflate(R.layout.activity_welcome_lastview, null);
	 ImageView mImgView=(ImageView)view.findViewById(R.id.activity_welcome_button);
	
		mImgView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),activity_login_firstActivity.class);
				startActivity(intent);
				
			}
		});
	   Log.v("daole2","daole ");
		views.add(view);
		
		mViewPager.setAdapter(vpAdapter);
		mViewPager.setOnPageChangeListener(this);
		

	}

	/*
	 * 设置当前要显示的view
	 */
	private void setCurView(int position) {
		if (position < 0 && position >pics.length) {
			return;
		}
		mViewPager.setCurrentItem(position);
		
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
	
		

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		if(arg0==3){
			buttons[0].setVisibility(View.GONE);
			buttons[1].setVisibility(View.GONE);
			buttons[2].setVisibility(View.GONE);
		}else{
			buttons[0].setVisibility(View.VISIBLE);
			buttons[1].setVisibility(View.VISIBLE);
			buttons[2].setVisibility(View.VISIBLE);
		buttons[arg0].setChecked(true);}
		

	}

	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag();
		setCurView(position);

	}

	class ViewPagerAdapter extends PagerAdapter {
		// 界面列表
		private ArrayList<View> views;

		public ViewPagerAdapter(ArrayList<View> views) {
			this.views = views;
		}

		// 获得当前界面数
		@Override
		public int getCount() {
			if (views != null) {
				return views.size();
			}
			return 0;
		}

		// 判断是否由对象生成界面
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		// 初始化position位置界面
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(views.get(position));
			return views.get(position);
		}

		// 销毁position位置的界面
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));

		}

	}

}
