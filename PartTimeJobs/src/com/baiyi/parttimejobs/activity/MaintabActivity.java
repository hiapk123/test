package com.baiyi.parttimejobs.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.Toast;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.fragment.FragmentFactory;

public class MaintabActivity extends FragmentActivity{
	
	private long exitTime = 0;//最后一次点击返回键的时间
	private FragmentManager fragmentManager;
	
	private RadioButton jianzhi;
	private RadioButton near;
	private RadioButton mine;
	public  void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_user_home_bottom_tab);
	
		

		fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment fragment = FragmentFactory.getInstanceByIndex(1);
		transaction.replace(R.id.user_home_content, fragment);
		transaction.commit();
		
		jianzhi=(RadioButton)this.findViewById(R.id.maintab_tab_jianzhi);
		near=(RadioButton)this.findViewById(R.id.maintab_tab_near);
		mine=(RadioButton)this.findViewById(R.id.maintab_tab_mine);
		jianzhi.setChecked(true);
		jianzhi.setOnClickListener(new OnTabClickListener());
		near.setOnClickListener(new OnTabClickListener());
		mine.setOnClickListener(new OnTabClickListener());
		
	}
	
	class OnTabClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			
		 if(jianzhi.isChecked()){
			 fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				Fragment fragment = FragmentFactory.getInstanceByIndex(1);
				transaction.replace(R.id.user_home_content, fragment);
				transaction.commit();
		 }
		 else if(near.isChecked()){
			 fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				Fragment fragment = FragmentFactory.getInstanceByIndex(2);
				transaction.replace(R.id.user_home_content, fragment);
				transaction.commit();
			 
		 }else if(mine.isChecked()){
			 fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				Fragment fragment = FragmentFactory.getInstanceByIndex(3);
				transaction.replace(R.id.user_home_content, fragment);
				transaction.commit();
		 }
		}
	}
	@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) { // 监控/拦截/屏蔽返回键
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				AppManager.getAppManager().AppExit(this);
			}
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_MENU) {
			// 监控/拦截菜单键
		} else if (keyCode == KeyEvent.KEYCODE_HOME) {
			// 由于Home键为系统键，此处不能捕获，需要重写onAttachedToWindow()
		}
		return super.onKeyDown(keyCode, event);
	}


	public void onBackPressed() {

		if ((System.currentTimeMillis() - exitTime) > 2000) {
			Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
			exitTime = System.currentTimeMillis();
		} else {
		      finish();
			System.exit(0);
			AppManager.getAppManager().AppExit(this);
		}
	}



}
