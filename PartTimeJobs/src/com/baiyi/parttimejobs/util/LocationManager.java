package com.baiyi.parttimejobs.util;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
//假如用到位置提醒功能，需要import该类
//如果使用地理围栏功能，需要import如下类

public class LocationManager {
	private Context mContext;
	private LocationClient mLocationClient = null;
	private BDLocationListener myListener = new MyLocationListener();
	private String addr;

	public LocationManager(Context mContext) {
		super();
		this.mContext = mContext;
		mLocationClient = new LocationClient(mContext); // 声明LocationClient类
		mLocationClient.registerLocationListener(myListener); // 注册监听函数

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
		option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
		option.setNeedDeviceDirect(true);// 返回的定位结果包含手机机头的方向

		mLocationClient.setLocOption(option);
		mLocationClient.start();
	}

	/*
	 * 关闭定位
	 */
	public void stop() {
		mLocationClient.stop();
	}

	public String getAddr() {
		return addr;
	}

	private class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;

			if (location.getLocType() == BDLocation.TypeGpsLocation) {

			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

				addr = location.getAddrStr();
			}

		}
	}

}
