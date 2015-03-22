package com.baiyi.parttimejobs.util;

import com.baidu.mapapi.model.LatLng;

public class Distance {
	/**
	 * ��������֮�����
	 * 
	 * @param start
	 * @param end
	 * @return ��
	 */
	public static double getDistance(LatLng start, LatLng end) {
		double lat1 = (Math.PI / 180) * start.latitude;
		double lat2 = (Math.PI / 180) * end.latitude;

		double lon1 = (Math.PI / 180) * start.longitude;
		double lon2 = (Math.PI / 180) * end.longitude;

		// double Lat1r = (Math.PI/180)*(gp1.getLatitudeE6()/1E6);
		// double Lat2r = (Math.PI/180)*(gp2.getLatitudeE6()/1E6);
		// double Lon1r = (Math.PI/180)*(gp1.getLongitudeE6()/1E6);
		// double Lon2r = (Math.PI/180)*(gp2.getLongitudeE6()/1E6);

		// ����뾶
		double R = 6371;

		// �������� km�������Ҫ�׵Ļ������*1000�Ϳ�����
		double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1)
				* Math.cos(lat2) * Math.cos(lon2 - lon1))
				* R;

		return d * 1000;
	}
}
