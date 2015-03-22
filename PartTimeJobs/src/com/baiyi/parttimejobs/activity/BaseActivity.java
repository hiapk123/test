package com.baiyi.parttimejobs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/*
 * Ϊ���е�activity��д���ؼ���home���Լ��˵���
 */
public class BaseActivity extends Activity {
	private long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) { // ���/����/���η��ؼ�
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				AppManager.getAppManager().AppExit(this);
			}
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_MENU) {
			// ���/���ز˵���
		} else if (keyCode == KeyEvent.KEYCODE_HOME) {
			// ����Home��Ϊϵͳ�����˴����ܲ�����Ҫ��дonAttachedToWindow()
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {

		if ((System.currentTimeMillis() - exitTime) > 2000) {
			Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
			exitTime = System.currentTimeMillis();
		} else {
			/*finish();
			System.exit(0);*/
			AppManager.getAppManager().AppExit(this);
		}
	}

}
