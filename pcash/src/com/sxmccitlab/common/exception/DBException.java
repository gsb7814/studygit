package com.sxmccitlab.common.exception;

public class DBException extends BaseException {
	
	public DBException(){
		super();
	}
	
	public DBException(String errMsg){
		super(errMsg);
	}

	public DBException(String errCode,String errMsg){
		super(errCode,errMsg);
	}
	
	public DBException(String errMsg,Throwable rootCause) {
		super(errMsg,rootCause);
	}

}
