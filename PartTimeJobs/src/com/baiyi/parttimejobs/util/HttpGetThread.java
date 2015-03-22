package com.baiyi.parttimejobs.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.baiyi.parttimejobs.model.Model;

import android.os.Handler;
import android.os.Message;

/*
 * ����Get������߳�
 */
public class HttpGetThread implements Runnable {

	private Handler hand;
	private String url;
	private MyGet myGet = new MyGet();

	public HttpGetThread(Handler hand, String endParamerse) {
		this.hand = hand;
		// ƴ�ӷ��ʷ����������ĵ�ַ
		url = Model.HTTPURL + endParamerse;
	}

	@Override
	public void run() {
		// ��ȡ���ǻص���ui��message
		Message msg = hand.obtainMessage();

		try {
			String result = myGet.doGet(url);
			msg.what = 200;
			msg.obj = result;
		} catch (ClientProtocolException e) {
			msg.what = 404;
		} catch (IOException e) {
			msg.what = 100;
		}
		// ����ui������Ϣ��������
		hand.sendMessage(msg);
	}
}
