package com.baiyi.parttimejobs.fragment;

import android.support.v4.app.Fragment;

public class FragmentFactory {
	public static Fragment getInstanceByIndex(int index) {
		Fragment fragment = null;
		switch (index) {
		case 1:
			fragment = new UserHomeFragment();
			break;
		case 2:
			fragment = new FuJinFragment();
			break;
		case 3:
			fragment = new MineFragment();
			break;

		}
		return fragment;
	}
}