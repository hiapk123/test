package com.baiyi.parttimejobs.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.baiyi.parttimejobs.R;

public class FuJinFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_fujin, null);
	/*	TextView tv=(TextView) view.findViewById(R.id.tab_test);
		tv.setText("hello!");*/
		return view;
	}

}
