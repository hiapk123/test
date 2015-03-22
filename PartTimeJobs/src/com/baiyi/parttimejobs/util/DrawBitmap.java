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
	 * ���ƴ���
	 */
	public Bitmap drawCuXiao(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_cunxiao_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * ���ƴ���
	 */
	public Bitmap drawDaiLi(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_daili_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * ���Ʒ���Ա
	 */
	public Bitmap drawFuWuYuan(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_fuwuyuan_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * ���Ƽҽ�
	 */
	public Bitmap drawJiaJiao(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_jiajiao_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * ��������
	 */
	public Bitmap drawLiYi(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_liyi_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * �����ɵ�
	 */
	public Bitmap drawPaiDan(Bitmap src) {
		InputStream is = context.getResources().openRawResource(
				R.drawable.user_home_paidan_little);
		Bitmap dest = BitmapFactory.decodeStream(is);

		return createBitmap(src, dest);

	}

	/*
	 * �ϳ�2��Bitmap
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
		Bitmap newb = Bitmap.createBitmap(w, h, Config.ARGB_8888);// ����һ���µĺ�SRC���ȿ��һ����λͼ
		Canvas cv = new Canvas(newb);
		// draw src into
		cv.drawBitmap(src, 0, 0, null);// �� 0��0���꿪ʼ����src
		// draw dest into
		cv.drawBitmap(dest, w - ww + 5, h - wh + 5, null);// ��src�����½ǻ���ˮӡ
		// save all clip
		cv.save(Canvas.ALL_SAVE_FLAG);// ����
		// store
		cv.restore();// �洢
		return newb;
	}

	/**
	 * ͼƬԲ��
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
	 * ���š���ת����תͼƬ
	 * 
	 * @param bmpOrg
	 * @param rotate
	 * @return
	 */
	private android.graphics.Bitmap gerZoomRotateBitmap(
			android.graphics.Bitmap bmpOrg, int rotate) {
		// ��ȡͼƬ��ԭʼ�Ĵ�С
		int width = bmpOrg.getWidth();
		int height = bmpOrg.getHeight();

		int newWidth = 300;
		int newheight = 300;
		// �������ŵĸߺͿ�ı���
		float sw = ((float) newWidth) / width;
		float sh = ((float) newheight) / height;
		// ��������ͼƬ���õ�Matrix����
		android.graphics.Matrix matrix = new android.graphics.Matrix();
		// ���ŷ�תͼƬ�Ķ���
		// sw sh�ľ���ֵΪ���ſ�ߵı�����swΪ������ʾX����ת��shΪ������ʾY����ת
		matrix.postScale(sw, sh);
		// ��ת30*
		matrix.postRotate(rotate);
		// ����һ���µ�ͼƬ
		android.graphics.Bitmap resizeBitmap = android.graphics.Bitmap
				.createBitmap(bmpOrg, 0, 0, width, height, matrix, true);
		return resizeBitmap;
	}
}
