package com.baiyi.parttimejobs.util;

import java.util.Map;

import android.os.Handler;
import android.os.Message;

/*
 * ����Post������߳�
 */

public class HttpPostThread implements Runnable {

	private Handler hand;
	private String url;

	private MyPost myPost;
	private Map<String, String> nameValueMap;

	/*public HttpPostThread(Handler hand, String endParamerse, String mycode,
			String value) {
		myPost = new MyPost();
		this.hand = hand;
		// ƴ�ӷ��ʷ����������ĵ�ַ
		url = endParamerse;
		this.mycode = mycode;
		this.value = value;
	}*/

	public HttpPostThread(Handler hand, String url, Map<String, String> nameValueMap) {
		myPost = new MyPost();
		this.hand = hand;
		this.url = url;
		this.nameValueMap = nameValueMap;
	}

	@Override
	public void run() {
		// ��ȡ���ǻص���ui��message
		Message msg = hand.obtainMessage();
		String result = myPost.doPost(url, nameValueMap);
		msg.what = 200;
		msg.obj = result;
		// ����ui������Ϣ��������
		hand.sendMessage(msg);

	}

}
