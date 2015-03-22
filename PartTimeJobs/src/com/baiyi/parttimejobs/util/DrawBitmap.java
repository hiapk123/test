package com.baiyi.parttimejobs.util;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.baiyi.parttimejobs.R;

public class DrawBitmap {
	private Context context;

	public DrawBitmap(Context context) {
		super();
		this.context = context;
	}

	/*
	 * 绘制促销
	 */
	public Bitmap drawCuXiao(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_cunxiao_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * 绘制代理
	 */
	public Bitmap drawDaiLi(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_daili_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * 绘制服务员
	 */
	public Bitmap drawFuWuYuan(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_fuwuyuan_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * 绘制家教
	 */
	public Bitmap drawJiaJiao(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_jiajiao_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * 绘制礼仪
	 */
	public Bitmap drawLiYi(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_liyi_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * 绘制派单
	 */
	public Bitmap drawPaiDan(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_paidan_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * 合成2张Bitmap
	 */
	public Bitmap createBitmap(Bitmap src, Bitmap dest) {
		if (src == null) {
			return null;
		}
		int w = src.getWidth();
		int h = src.getHeight();
		int ww = dest.getWidth();
		int wh = dest.getHeight();
		// create the new blank bitmap
		Bitmap newb = Bitmap.createBitmap(w, h, Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
		Canvas cv = new Canvas(newb);
		// draw src into
		cv.drawBitmap(src, 0, 0, null);// 在 0，0坐标开始画入src
		// draw dest into
		cv.drawBitmap(dest, w - ww + 5, h - wh + 5, null);// 在src的右下角画入水印
		// save all clip
		cv.save(Canvas.ALL_SAVE_FLAG);// 保存
		// store
		cv.restore();// 存储
		return newb;
	}

	/**
	 * 图片圆角
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = 12;

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

	/**
	 * 缩放、翻转和旋转图片
	 * 
	 * @param bmpOrg
	 * @param rotate
	 * @return
	 */
	private android.graphics.Bitmap gerZoomRotateBitmap(
			android.graphics.Bitmap bmpOrg, int rotate) {
		// 获取图片的原始的大小
		int width = bmpOrg.getWidth();
		int height = bmpOrg.getHeight();

		int newWidth = 300;
		int newheight = 300;
		// 定义缩放的高和宽的比例
		float sw = ((float) newWidth) / width;
		float sh = ((float) newheight) / height;
		// 创建操作图片的用的Matrix对象
		android.graphics.Matrix matrix = new android.graphics.Matrix();
		// 缩放翻转图片的动作
		// sw sh的绝对值为绽放宽高的比例，sw为负数表示X方向翻转，sh为负数表示Y方向翻转
		matrix.postScale(sw, sh);
		// 旋转30*
		matrix.postRotate(rotate);
		// 创建一个新的图片
		android.graphics.Bitmap resizeBitmap = android.graphics.Bitmap
				.createBitmap(bmpOrg, 0, 0, width, height, matrix, true);
		return resizeBitmap;
	}
}
