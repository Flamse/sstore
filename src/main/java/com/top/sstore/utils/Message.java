package com.top.sstore.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wantao
 * @date 2019-01-31 20:05
 * @description: json的通用返回类
 */
public class Message {
	// 200 成功 404 失败
//	private int code;
	private Integer state;
	private String message;
	// 服务器要返回给浏览器的数据
	private Map<String, Object> data = new HashMap<String, Object>();	//可选

	public static Message success() {
		Message message = new Message();
		message.setState(200);
		message.setMessage("处理成功");
		return message;
	}
	/*默认返回*/
	public static Message fail() {
		Message message = new Message();
		message.setState(404);
		message.setMessage("处理失败");
		return message;
	}
	/*多态*/
	public static Message fail(String meg) {
		Message message = new Message();
		message.setState(404);
		message.setMessage(meg);
		return message;
	}

	public Message add(String key, Object value) {
		this.data.put(key, value);
		return this;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
