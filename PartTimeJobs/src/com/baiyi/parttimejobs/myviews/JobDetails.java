package com.baiyi.parttimejobs.myviews;

import com.baiyi.parttimejobs.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JobDetails extends LinearLayout {

	private TextView type;// ��ְ����
	private TextView addr;// ��ְ��ַ
	private TextView date;// ��ְ����
	private TextView type_a;// ��ְ����
	private TextView company;// ��������
	private TextView count;// ��Ƹ����
	private TextView salary;// ���ʴ���
	private TextView content;// ��������
	private TextView address;// ��ϸ��ַ
	private TextView person;// ��ϵ��
	private TextView tel;// ��ϵ�绰
	private TextView email;// ��ϵ����

	public JobDetails(Context context) {
		super(context);
		LayoutInflater.from(getContext()).inflate(
				R.layout.activity_manage_jobs_details, this, true);
		// ��ʼ�����
		type = (TextView) findViewById(R.id.manage_jobs_details_type);
		type_a = (TextView) findViewById(R.id.manage_jobs_details_a_type);
		addr = (TextView) findViewById(R.id.manage_jobs_details_addr);
		date = (TextView) findViewById(R.id.manage_jobs_details_date);
		company = (TextView) findViewById(R.id.manage_jobs_details_a_publish_company);
		count = (TextView) findViewById(R.id.manage_jobs_details_a_count);
		salary = (TextView) findViewById(R.id.manage_jobs_details_a_salary);
		content = (TextView) findViewById(R.id.manage_jobs_details_content);
		address = (TextView) findViewById(R.id.manage_jobs_details_address);
		person = (TextView) findViewById(R.id.manage_jobs_details_contact_people);
		tel = (TextView) findViewById(R.id.manage_jobs_details_contact_tel);
		email = (TextView) findViewById(R.id.manage_jobs_details_contact_email);
		Log.i("11111111111111111111111111111", "testing...............................");
	}

	/*
	 * setter
	 */
	public void setTypeText(String text) {
		type.setText(text);
	}

	public void setAddrText(String text) {
		addr.setText(text);
	}

	public void setDate(String text) {
		this.date.setText(text);
	}

	public void setType_a(String text) {
		this.type_a.setText(text);
	}

	public void setCompany(String text) {
		this.company.setText(text);
	}

	public void setCountText(String text) {
		this.count.setText(text);
	}

	public void setSalaryText(String text) {
		this.salary.setText(text);
	}

	public void setContentText(String text) {
		this.content.setText(text);
	}

	public void setAddressText(String text) {
		this.address.setText(text);
	}

	public void setPersonText(String text) {
		this.person.setText(text);
	}

	public void setTelText(String text) {
		this.tel.setText(text);
	}

	public void setEmailText(String text) {
		this.email.setText(text);
	}

}
