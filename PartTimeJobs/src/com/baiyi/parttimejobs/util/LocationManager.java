package com.baiyi.parttimejobs.util;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
//�����õ�λ�����ѹ��ܣ���Ҫimport����
//���ʹ�õ���Χ�����ܣ���Ҫimport������

public class LocationManager {
	private Context mContext;
	private LocationClient mLocationClient = null;
	private BDLocationListener myListener = new MyLocationListener();
	private String addr;

	public LocationManager(Context mContext) {
		super();
		this.mContext = mContext;
		mLocationClient = new LocationClient(mContext); // ����LocationClient��
		mLocationClient.registerLocationListener(myListener); // ע���������

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// ���ö�λģʽ
		option.setCoorType("bd09ll");// ���صĶ�λ����ǰٶȾ�γ��,Ĭ��ֵgcj02
		option.setScanSpan(5000);// ���÷���λ����ļ��ʱ��Ϊ5000ms
		option.setIsNeedAddress(true);// ���صĶ�λ���������ַ��Ϣ
		option.setNeedDeviceDirect(true);// ���صĶ�λ��������ֻ���ͷ�ķ���

		mLocationClient.setLocOption(option);
		mLocationClient.start();
	}

	/*
	 * �رն�λ
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
