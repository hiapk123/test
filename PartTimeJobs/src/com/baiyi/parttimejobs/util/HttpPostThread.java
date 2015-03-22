package com.baiyi.parttimejobs.util;

import java.util.Map;

import android.os.Handler;
import android.os.Message;

/*
 * 网络Post请求的线程
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
		// 拼接访问服务器完整的地址
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
		// 获取我们回调主ui的message
		Message msg = hand.obtainMessage();
		String result = myPost.doPost(url, nameValueMap);
		msg.what = 200;
		msg.obj = result;
		// 给主ui发送消息传递数据
		hand.sendMessage(msg);

	}

}
