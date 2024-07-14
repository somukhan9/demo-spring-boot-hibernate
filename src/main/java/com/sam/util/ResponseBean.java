package com.sam.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseBean {

	// success value 0 = auth fail,1 = true/success, 2 = error, 3 = alert
	private int success = 1;
	private String error;
	/* private String alert; */

	private String msg;
	private Object result;
	private List<?> list;
	private Object data;

	public int isSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	/*
	 * public String getAlert() { return alert; }
	 */
	/*
	 * public void setAlert(String alert) { this.alert = alert; }
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public int getSuccess() {
		return success;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseBean [success=" + success + ", error=" + error + ", msg=" + msg + ", result=" + result
				+ ", list=" + list + ", data=" + data + "]";
	}

}
