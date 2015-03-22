package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class mine_personalinfoActivity extends Activity{
	
	  private  ImageView user_photo;
	  private  TextView timeTable;
	  private  TextView  workType;
	  private  TextView birthDate;
	  private EditText username;
	  private EditText height;
	  private RadioButton workMan;
	  private RadioButton workWoman;
	  private ImageView back;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_mine_personalinfo);
		initView();
		
	}
  public void initView(){
	  back=(ImageView)this.findViewById(R.id.personal_back);
	  back.setOnClickListener(new OnClickListener(){
		    
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(mine_personalinfoActivity.this,MaintabActivity.class);
				mine_personalinfoActivity.this.startActivity(intent);
			}
			  
		  });
	  timeTable=(TextView)this.findViewById(R.id.mine_timetable);
	  timeTable.setOnClickListener(new OnClickListener(){
    
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(mine_personalinfoActivity.this,mine_personal_timeActivity.class);
			mine_personalinfoActivity.this.startActivity(intent);
		}
		  
	  });
	  
  }
}
