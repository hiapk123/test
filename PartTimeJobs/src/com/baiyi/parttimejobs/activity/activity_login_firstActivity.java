package com.baiyi.parttimejobs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baiyi.parttimejobs.R;

public class activity_login_firstActivity extends BaseActivity implements OnClickListener{
    
	 private TextView person;
	 private TextView company;

	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_first);
		person=(TextView)this.findViewById(R.id.activity_login_first_person);
		company=(TextView)this.findViewById(R.id.activity_login_first_company);
		person.setOnClickListener(this);
		company.setOnClickListener(this);
	  
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0==person){
			Intent intent=new Intent(getApplicationContext(),activity_login_second_personActivity.class);
			startActivity(intent);
		}else
		if(arg0==company){
			Intent intent=new Intent(getApplicationContext(),activity_login_second_companyActivity.class);
			startActivity(intent);
		
		}
	}
	
}
