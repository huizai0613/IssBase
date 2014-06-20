package com.iss.exception;

public class NetRequestException extends Exception {

	private com.iss.bean.Error error;

	
	public com.iss.bean.Error getError() {
		return error;
	}
	public void setError(com.iss.bean.Error error) {
		this.error = error;
	}
	public NetRequestException(com.iss.bean.Error error) {
		super();
		
		this.error=error;
	}
	public NetRequestException(String detailMessage, Throwable throwable,
			com.iss.bean.Error error) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
		this.error=error;
	}

	public NetRequestException(String detailMessage, com.iss.bean.Error error) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
		this.error=error;
	}

	public NetRequestException(Throwable throwable, com.iss.bean.Error error) {
		super(throwable);
		// TODO Auto-generated constructor stub
		this.error=error;
	}

}
