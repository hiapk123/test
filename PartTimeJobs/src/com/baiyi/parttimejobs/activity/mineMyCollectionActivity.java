package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class mineMyCollectionActivity extends Activity{
    
	private ImageView back;
	private ListView list;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mine_mycollection);
		initView();
	}
	
	public void initView(){
		back=(ImageView)this.findViewById(R.id.mine_collection_back);
		list=(ListView)this.findViewById(R.id.mine_mycollection_list);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(mineMyCollectionActivity.this,MaintabActivity.class);
				mineMyCollectionActivity.this.startActivity(intent);
			}
			
		});
		
		
	}
	
	
}
