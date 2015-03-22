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
 * 欢迎首页。
 */
public class WelcomeActivity extends BaseActivity {
	/*
	 * 3秒后进入主界面
	 */
	private Intent intent ;
	private boolean isFrist=true;
	private Handler mHandler = new Handler(){

		public void handleMessage(Message msg) {
			//如果是第一进入则跳过引导页面
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 不需要标题栏
		setContentView(R.layout.activity_welcome);

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					SharedPreferences mPreferences=getSharedPreferences("login", MODE_PRIVATE);
					//不存在，说明是首次进入
					if(!mPreferences.getBoolean("isFrist", false)){
						Editor mEditor=mPreferences.edit();
						mEditor.putBoolean("isFrist", true);
						mEditor.commit();
						isFrist=true;//是第一次进入
					}else{
						isFrist=false;//不是第一次进入
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
