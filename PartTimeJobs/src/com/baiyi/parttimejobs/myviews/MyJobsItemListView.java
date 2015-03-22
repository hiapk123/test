package com.baiyi.parttimejobs.myviews;

import com.baiyi.parttimejobs.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyJobsItemListView extends LinearLayout {
	private TextView text;// 要显示的文字内容
	private ImageView mTextIcon, mArrows;// 要显示的文字前面的图标和后面的箭头
	private Drawable mSrc0;
	private Drawable mSrc1;
	private String mText;

	public void setmAddrText(String text) {
		this.text.setText(text);
	}

	public void setmArrowsSrc(Drawable drawable) {
		this.mArrows.setImageDrawable(drawable);
	}

	public void setmTextIconSrc(Drawable drawable) {
		this.mTextIcon.setImageDrawable(drawable);
	}

	public MyJobsItemListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		LayoutInflater.from(getContext()).inflate(R.layout.myjobs_itemlistview,
				this, true);
		// 获取属性
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.myjobscenteritemlistview);
		mSrc0 = a.getDrawable(R.styleable.myjobscenteritemlistview_src0);
		mSrc1 = a.getDrawable(R.styleable.myjobscenteritemlistview_src1);
		mText = a.getString(R.styleable.myjobscenteritemlistview_text);
		// 初始化组件
		initView();
		text.setText(mText.toString());
		mTextIcon.setImageDrawable(mSrc0);
		mArrows.setImageDrawable(mSrc1);
		a.recycle();
	}

	public MyJobsItemListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(getContext()).inflate(R.layout.myjobs_itemlistview,
				this, true);
		// 获取属性
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.myjobscenteritemlistview);
		mSrc0 = a.getDrawable(R.styleable.myjobscenteritemlistview_src0);
		mSrc1 = a.getDrawable(R.styleable.myjobscenteritemlistview_src1);
		mText = a.getString(R.styleable.myjobscenteritemlistview_text);
		// 初始化组件
		initView();
		text.setText(mText.toString());
		mTextIcon.setImageDrawable(mSrc0);
		mArrows.setImageDrawable(mSrc1);
		a.recycle();
	}

	public MyJobsItemListView(Context context) {
		super(context);
		LayoutInflater.from(getContext()).inflate(R.layout.myjobs_itemlistview,
				this, true);
		initView();
	}

	private void initView() {
		text = (TextView) findViewById(R.id.parttimejobs_address_selected_tv);
		mArrows = (ImageView) findViewById(R.id.parttimejobs_address_selected_img);
		mTextIcon = (ImageView) findViewById(R.id.parttimejobs_address_selected_tv_icon);
	}

}
