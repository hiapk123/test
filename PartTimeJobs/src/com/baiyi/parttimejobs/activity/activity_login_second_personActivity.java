package com.baiyi.parttimejobs.activity;

import com.baiyi.parttimejobs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_login_second_personActivity extends Activity{
	
	private TextView registerAccount;
	private TextView loginFrogetPwd;
    private CheckBox loginRemberPwd;
	private ImageView login;
	
	

	private EditText account;// �˺�
	private EditText password;// ����
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_second_person);
		initView();
		TextViewOnclickListener mListener = new TextViewOnclickListener();
		registerAccount.setOnClickListener(mListener);
		loginFrogetPwd.setOnClickListener(mListener);
		 loginRemberPwd.setOnClickListener(new CheckBoxListener());
		 login.setOnClickListener(new LoginListener());
	}
	
	
	
	private void initView() {
		registerAccount = (TextView) findViewById(R.id.activity_login_register);
		loginFrogetPwd = (TextView) findViewById(R.id.activity_login_forget);
		loginRemberPwd = (CheckBox) findViewById(R.id.activity_login_jizhumima);
		login = (ImageView) findViewById(R.id.activity_login_login);
	
		account = (EditText) findViewById(R.id.activity_login_zhanghao);
		password = (EditText) findViewById(R.id.activity_login_mima);
	}
	
	
	
	
	 private class CheckBoxListener implements OnClickListener {

			@Override
			public void onClick(View v) {
				if (loginRemberPwd.isChecked()) {
					Toast.makeText(getApplicationContext(), "��ס���룡",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "δ��ס���룡",
							Toast.LENGTH_SHORT).show();
				}

			}
		}
	 
	 private class TextViewOnclickListener implements OnClickListener {

			@Override
			public void onClick(View v) {
				if (v == registerAccount) {
					/*if(company.isChecked()){
						Intent intent=new Intent(getApplicationContext(),QiyeRegisterActivity.class);
						startActivity(intent);
					}*/
					
						Intent intent=new Intent(getApplicationContext(),QiuzhizheRegisterActivity.class);
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
					// �����û���¼
					String mAccount = account.getText().toString();// ȡ���˺�
					String mPwd = password.getText().toString();// ȡ������
					//���ʷ�������url
					String url = "http://192.168.1.107:8080/PandaServer/login/login";
					//Ҫ���͵��������Ĳ���
					Map<String, String> nameValueMap = new HashMap<String, String>();
					nameValueMap.put("account", mAccount);
					nameValueMap.put("pwd", mPwd);
					// HttpPost��ʽ����
					HttpPostThread mPostThread = new HttpPostThread(mHandler, url,
							nameValueMap);// ����һ���̷߳�������
					// �ж������Ƿ�����
					if (NetWork.isNetworkConnected(getApplicationContext())) {
						// wifi�����ƶ���������֮һ����
						if (NetWork.isMobileConnected(getApplicationContext())
								|| NetWork.isWifiConnected(getApplicationContext())) {
							ThreadPoolUtils.execute(mPostThread);// �����߳�
						}else{
							Toast.makeText(getApplicationContext(), "�����������WIFI�Ƿ�򿪣�", Toast.LENGTH_SHORT).show();
						}
					}else{
						Toast.makeText(getApplicationContext(), "�����쳣����", Toast.LENGTH_SHORT).show();
					}

				*/
					Intent intent = new Intent(getApplicationContext(),
							MaintabActivity.class);
			        
					
					startActivity(intent);	
				}
			}

}
