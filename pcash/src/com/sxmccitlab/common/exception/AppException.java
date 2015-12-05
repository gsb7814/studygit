package com.sxmccitlab.common.exception;

/**
 * ”¶”√“Ï≥£
 * @author pancy
 *
 */

public class AppException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8754136208346556523L;

	public AppException(){
		super();
	}
	
	public AppException(String errMsg){
		super(errMsg);
	}

	public AppException(String errCode,String errMsg){
		super(errCode,errMsg);
	}
	
	public AppException(String errMsg,Throwable rootCause) {
		super(errMsg,rootCause);
	}
}
