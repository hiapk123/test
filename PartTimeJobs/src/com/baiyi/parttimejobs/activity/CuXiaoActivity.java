package com.baiyi.parttimejobs.activity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.baiyi.parttimejobs.R;

/*
 * �ҽ�
 */
public class CuXiaoActivity extends NoActionBarActivity {
	private ImageView jiaJiaoBack;//�ҽ̷���
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cuxiao);
		initView();
		jiaJiaoBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				finish();
			}
		});
	}
	
	private void initView(){
		jiaJiaoBack=(ImageView) findViewById(R.id.user_home_jiajiao_back);
	}
}
