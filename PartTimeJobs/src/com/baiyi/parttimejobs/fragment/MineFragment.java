package com.baiyi.parttimejobs.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baiyi.parttimejobs.R;
import com.baiyi.parttimejobs.activity.mineMyCollectionActivity;
import com.baiyi.parttimejobs.activity.mine_personalinfoActivity;

public class MineFragment extends Fragment {
   
	private View personalInfo;
	private View mycollection;
	View view;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		   view = inflater.inflate(R.layout.activity_mine, null);
	     initView();
		return view;
	}
   
	
	public void initView(){
		
		mycollection=(View)view.findViewById(R.id.userinfo_mine_button2);
		personalInfo=(View)view.findViewById(R.id.userinfo_mine_button1);
		mycollection.setOnClickListener(new OnClickListener(){
		       
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent=new Intent(getActivity(),mineMyCollectionActivity.class);
						getActivity().startActivity(intent);
					}
					
				});
		
		personalInfo.setOnClickListener(new OnClickListener(){
       
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getActivity(),mine_personalinfoActivity.class);
				getActivity().startActivity(intent);
			}
			
		});
	}


 
  
}
