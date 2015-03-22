package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class userhome_jianzhiListActivity extends Activity{
	private TextView listTitle;
	private String  title;
	private ImageView back;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.userhome_jianzhilist);
		listTitle=(TextView)this.findViewById(R.id.usehome_jianzhilist_title);
		title=getIntent().getStringExtra("title");
		listTitle.setText(title);
		initView();
	}

	
	public void initView(){
		back=(ImageView)this.findViewById(R.id.userhome_jianzhilist_back);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(userhome_jianzhiListActivity.this,MaintabActivity.class);
				userhome_jianzhiListActivity.this.startActivity(intent);
			}
			
		});
	}
}
