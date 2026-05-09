package com.niranjana.ai.gemini.dto;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ApiResponse(boolean success, String message, T data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApiResponse [success=" + success + ", message=" + message + ", data=" + data + "]";
	}
    
    
}