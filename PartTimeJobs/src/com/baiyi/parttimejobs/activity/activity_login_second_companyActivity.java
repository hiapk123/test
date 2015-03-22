package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_login_second_companyActivity extends Activity{
	
	
	private TextView registerAccount;
	private TextView loginFrogetPwd;
    private CheckBox loginRemberPwd;
	private ImageView login;
	
	

	private EditText account;// 账号
	private EditText password;// 密码
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_second_company);
		initView();
		TextViewOnclickListener mListener = new TextViewOnclickListener();
		registerAccount.setOnClickListener(mListener);
		loginFrogetPwd.setOnClickListener(mListener);
		 loginRemberPwd.setOnClickListener(new CheckBoxListener());
		 login.setOnClickListener(new LoginListener());
	}
	
	
	private void initView() {
		registerAccount = (TextView) findViewById(R.id.activity_login_qiye_register);
		loginFrogetPwd = (TextView) findViewById(R.id.activity_login_qiye_forget);
		loginRemberPwd = (CheckBox) findViewById(R.id.activity_login_qiye_jizhumima);
		login = (ImageView) findViewById(R.id.activity_login_qiye_login);
	
		account = (EditText) findViewById(R.id.activity_login_qiye_zhanghao);
		password = (EditText) findViewById(R.id.activity_login_qiye_mima);
	}
	
	
	 private class CheckBoxListener implements OnClickListener {

			@Override
			public void onClick(View v) {
				if (loginRemberPwd.isChecked()) {
					Toast.makeText(getApplicationContext(), "记住密码！",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "未记住密码！",
							Toast.LENGTH_SHORT).show();
				}

			}
		}
	 
	 private class TextViewOnclickListener implements OnClickListener {

			@Override
			public void onClick(View v) {
				if (v == registerAccount) {
			
						Intent intent=new Intent(getApplicationContext(),QiyeRegisterActivity.class);
						startActivity(intent);
					
				} else if (v == loginFrogetPwd) {
					
				
					Intent intent=new Intent(getApplicationContext(),GetBackPasswordActivity.class);
					startActivity(intent);
					
				}

			}

		}
	 
	 private class LoginListener implements OnClickListener {

			@Override
			public void onClick(View v) {
			/*	if (company.isChecked()) {
					Intent intent = new Intent(getApplicationContext(),
							HomeActivity.class);
					startActivity(intent);
				} else if (person.isChecked()) {/*
					// 个人用户登录
					String mAccount = account.getText().toString();// 取得账号
					String mPwd = password.getText().toString();// 取得密码
					//访问服务器的url
					String url = "http://192.168.1.107:8080/PandaServer/login/login";
					//要发送到服务器的参数
					Map<String, String> nameValueMap = new HashMap<String, String>();
					nameValueMap.put("account", mAccount);
					nameValueMap.put("pwd", mPwd);
					// HttpPost方式发送
					HttpPostThread mPostThread = new HttpPostThread(mHandler, url,
							nameValueMap);// 启动一个线程发送请求
					// 判断网络是否正常
					if (NetWork.isNetworkConnected(getApplicationContext())) {
						// wifi或者移动网络其中之一可用
						if (NetWork.isMobileConnected(getApplicationContext())
								|| NetWork.isWifiConnected(getApplicationContext())) {
							ThreadPoolUtils.execute(mPostThread);// 启动线程
						}else{
							Toast.makeText(getApplicationContext(), "请检查网络或者WIFI是否打开！", Toast.LENGTH_SHORT).show();
						}
					}else{
						Toast.makeText(getApplicationContext(), "网络异常！。", Toast.LENGTH_SHORT).show();
					}

				*/
					Intent intent = new Intent(getApplicationContext(),
							HomeActivity.class);
					startActivity(intent);	
				}
			}
	 
}
