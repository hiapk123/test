package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

/*
 * ��ӭ��ҳ��
 */
public class WelcomeActivity extends BaseActivity {
	/*
	 * 3������������
	 */
	private Intent intent ;
	private boolean isFrist=true;
	private Handler mHandler = new Handler(){

		public void handleMessage(Message msg) {
			//����ǵ�һ��������������ҳ��
			/*if(isFrist){*/
				intent = new Intent(getApplicationContext(),
						WelcomeViewpaper.class);
			/*}else{
				intent = new Intent(getApplicationContext(),LoginActivity.class);
			}*/
			
			startActivity(intent);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ����Ҫ������
		setContentView(R.layout.activity_welcome);

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					SharedPreferences mPreferences=getSharedPreferences("login", MODE_PRIVATE);
					//�����ڣ�˵�����״ν���
					if(!mPreferences.getBoolean("isFrist", false)){
						Editor mEditor=mPreferences.edit();
						mEditor.putBoolean("isFrist", true);
						mEditor.commit();
						isFrist=true;//�ǵ�һ�ν���
					}else{
						isFrist=false;//���ǵ�һ�ν���
					}
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mHandler.sendEmptyMessage(0);

			}
		}).start();
	}
}
