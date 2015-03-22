package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;

public class mine_personal_timeActivity extends Activity{
	
	
	private CheckBox button11;
	private CheckBox button21;
	private CheckBox button31;
	private CheckBox button41;
	private CheckBox button51;
	private CheckBox button61;
	private CheckBox button71;
	private CheckBox button12;
	private CheckBox button22;
	private CheckBox button32;
	private CheckBox button42;
	private CheckBox button52;

	private CheckBox button62;
	private CheckBox button72;
	
	private CheckBox button13;
	private CheckBox button23;
	private CheckBox button33;
	private CheckBox button43;
	private CheckBox button53;
	
	private CheckBox button63;
	private CheckBox button73;
	
	private Button submit;
	private ImageView back;
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mine_personal_timetable);
		initView();
	}
  
	public void initView(){
		button11=(CheckBox)this.findViewById(R.id.time_table_11);
		button21=(CheckBox)this.findViewById(R.id.time_table_21);
		button31=(CheckBox)this.findViewById(R.id.time_table_31);
		button41=(CheckBox)this.findViewById(R.id.time_table_41);
		button51=(CheckBox)this.findViewById(R.id.time_table_51);
		button61=(CheckBox)this.findViewById(R.id.time_table_61);
		button71=(CheckBox)this.findViewById(R.id.time_table_71);
		
		button12=(CheckBox)this.findViewById(R.id.time_table_12);
		button22=(CheckBox)this.findViewById(R.id.time_table_22);
		button32=(CheckBox)this.findViewById(R.id.time_table_32);
		button42=(CheckBox)this.findViewById(R.id.time_table_42);
		button52=(CheckBox)this.findViewById(R.id.time_table_52);
		button62=(CheckBox)this.findViewById(R.id.time_table_62);
		button72=(CheckBox)this.findViewById(R.id.time_table_72);
		
		button13=(CheckBox)this.findViewById(R.id.time_table_13);
		button23=(CheckBox)this.findViewById(R.id.time_table_23);
		button33=(CheckBox)this.findViewById(R.id.time_table_33);
		button43=(CheckBox)this.findViewById(R.id.time_table_43);
		button53=(CheckBox)this.findViewById(R.id.time_table_53);
		button63=(CheckBox)this.findViewById(R.id.time_table_63);
		button73=(CheckBox)this.findViewById(R.id.time_table_73);
		
		back=(ImageView)this.findViewById(R.id.personal_time_back);
		submit=(Button)this.findViewById(R.id.personal_time_submit);
		
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(mine_personal_timeActivity.this,mine_personalinfoActivity.class);
				mine_personal_timeActivity.this.startActivity(intent);
				
			}
			
		});
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
}
