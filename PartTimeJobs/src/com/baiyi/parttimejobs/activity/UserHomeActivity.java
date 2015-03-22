package com.baiyi.parttimejobs.activity;

import java.io.InputStream;

import com.baidu.platform.comapi.map.m;
import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.myviews.FavouriteJobsView;
import com.baiyi.parttimejobs.myviews.MyJobsItemListView;
import com.baiyi.parttimejobs.util.DrawBitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.service.dreams.DreamService;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/*
 * 用户首页最新兼职和猜你喜欢
 */
public class UserHomeActivity extends BaseActivity {
	private LinearLayout mLayout;// 图片兼职信息容器,最新兼职

	private LinearLayout mLayout2;// 猜你喜欢

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_home);
	/*initView();*/
		addNewJobs();
		addYouFavour();

	}

	// 添加猜你喜欢
	private void addYouFavour() {

		FavouriteJobsView mFavouriteJobsView1 = new FavouriteJobsView(
				getApplicationContext());// 集成空间
		// int mHeight = mFavouriteJobsView1.mLinearLayoutRight.getHeight();//
		// 左侧容器的高度
		// 获取图片，从服务器获取
		// 处理图片
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);

		Bitmap mBitmap = new DrawBitmap(getApplicationContext())
				.drawCuXiao(src);

		mFavouriteJobsView1.title.setTextColor(getResources().getColor(
				R.color.calendar_color_orange));

		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）

		ImageView mImageView = new ImageView(getApplicationContext());
		mImageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				width / 4));
		mImageView.setImageBitmap(mBitmap);
		/*
		 * mImageView
		 * .setImageDrawable(getResources().getDrawable(R.drawable.test));
		 */
		mFavouriteJobsView1.mLinearLayoutLeft.addView(mImageView);// 添加到容器
		mFavouriteJobsView1.date.setText("1天前");
		mFavouriteJobsView1.remark.setText("20条评论");
		mFavouriteJobsView1.salary.setText("30元/小时");
		mFavouriteJobsView1.title.setText("德克士");

		mFavouriteJobsView1.disance.setText("100m");
		mLayout2.addView(mFavouriteJobsView1);
	}

	// 添加最新兼职
	private void addNewJobs() {
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);
		
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）
		// int height = metric.heightPixels; // 屏幕高度（像素）
		// 生成3个imageview对象
		LayoutParams params = new LayoutParams(width / 3, width / 3);

		ImageView mView1 = new ImageView(getApplicationContext());
		mView1.setLayoutParams(params);
		//mView1.setImageDrawable(getResources().getDrawable(R.drawable.test));
		mView1.setImageBitmap(new DrawBitmap(getApplicationContext()).drawPaiDan(src));
		mView1.setPadding(5, 5, 5, 5);

		ImageView mView2 = new ImageView(getApplicationContext());
		mView2.setLayoutParams(params);
		//mView2.setImageDrawable(getResources().getDrawable(R.drawable.test));
		mView2.setImageBitmap(new DrawBitmap(getApplicationContext()).drawFuWuYuan(src));
		
		mView2.setPadding(5, 5, 5, 5);

		ImageView mView3 = new ImageView(getApplicationContext());
		mView3.setLayoutParams(params);
		//mView3.setImageDrawable(getResources().getDrawable(R.drawable.test));
		mView3.setImageBitmap(new DrawBitmap(getApplicationContext()).drawLiYi(src));

		mView3.setPadding(5, 5, 5, 5);
		// 最新兼职
		mLayout.addView(mView1);
		mLayout.addView(mView2);
		mLayout.addView(mView3);
	}

/*	private void initView() {
		mLayout = (LinearLayout) findViewById(R.id.user_home_partitmejobs_icon_container);
		mLayout2 = (LinearLayout) findViewById(R.id.user_home_favourite_container);
	}
*/
}
