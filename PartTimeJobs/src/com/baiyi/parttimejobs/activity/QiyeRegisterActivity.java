package com.baiyi.parttimejobs.activity;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.baiyi.parttimejobs.R;

public class QiyeRegisterActivity extends Activity{
	
   public void onCreate(Bundle savedInstanceState){
	   super.onCreate(savedInstanceState);
	   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	   setContentView(R.layout.activity_login_register_qiye);
   }
}
