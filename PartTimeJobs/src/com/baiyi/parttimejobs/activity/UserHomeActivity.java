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
 * �û���ҳ���¼�ְ�Ͳ���ϲ��
 */
public class UserHomeActivity extends BaseActivity {
	private LinearLayout mLayout;// ͼƬ��ְ��Ϣ����,���¼�ְ

	private LinearLayout mLayout2;// ����ϲ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_home);
	/*initView();*/
		addNewJobs();
		addYouFavour();

	}

	// ��Ӳ���ϲ��
	private void addYouFavour() {

		FavouriteJobsView mFavouriteJobsView1 = new FavouriteJobsView(
				getApplicationContext());// ���ɿռ�
		// int mHeight = mFavouriteJobsView1.mLinearLayoutRight.getHeight();//
		// ��������ĸ߶�
		// ��ȡͼƬ���ӷ�������ȡ
		// ����ͼƬ
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);

		Bitmap mBitmap = new DrawBitmap(getApplicationContext())
				.drawCuXiao(src);

		mFavouriteJobsView1.title.setTextColor(getResources().getColor(
				R.color.calendar_color_orange));

		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�

		ImageView mImageView = new ImageView(getApplicationContext());
		mImageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				width / 4));
		mImageView.setImageBitmap(mBitmap);
		/*
		 * mImageView
		 * .setImageDrawable(getResources().getDrawable(R.drawable.test));
		 */
		mFavouriteJobsView1.mLinearLayoutLeft.addView(mImageView);// ��ӵ�����
		mFavouriteJobsView1.date.setText("1��ǰ");
		mFavouriteJobsView1.remark.setText("20������");
		mFavouriteJobsView1.salary.setText("30Ԫ/Сʱ");
		mFavouriteJobsView1.title.setText("�¿�ʿ");

		mFavouriteJobsView1.disance.setText("100m");
		mLayout2.addView(mFavouriteJobsView1);
	}

	// ������¼�ְ
	private void addNewJobs() {
		InputStream is = getResources().openRawResource(R.drawable.test);
		Bitmap src = BitmapFactory.decodeStream(is);
		
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�
		// int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�
		// ����3��imageview����
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
		// ���¼�ְ
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
