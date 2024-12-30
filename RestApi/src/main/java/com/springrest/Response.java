package com.springrest;

public class Response {

	Boolean success;
	String message;
	Object data;
	public Response(Boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Response [success=" + success + ", message=" + message + ", data=" + data + "]";
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
