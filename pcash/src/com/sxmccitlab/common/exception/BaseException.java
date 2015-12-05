package com.sxmccitlab.common.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668714919608965202L;

	/**
	 * 异常编码，编码规则定义如下：
	 * 1)	000000: 正常
	 * 2)	－1: 未知错误
	 * 3)	其他错误代码的编码由8位数组成：格式为XX0YYY。
	 * 其中：
	 * XX代表各个模块的编码参见错误编码文档
	 * YYY代表错误号；
	 * 0~100：公共错误号，保留使用，具体编码参阅错误编码文档的"公共错误码"部分；
	 * YYY表示各应用的错误号，由开发人员自己定义；
	 */
    private String errorCode;
    
    /**
     * 异常描述信息
     */
    private String errorMsg;
    
    /**
     * @roseuid 45F7E8670109
     */
    public BaseException() 
    {
    	errorCode = "000000";
    }
    
    /**
     * @param errorMsg
     * @roseuid 45F7E8F302BF
     */
    public BaseException(String errorMsg) 
    {
    	super(errorMsg);
    	errorCode = "000000";
    	this.errorMsg = errorMsg;
    }
    
    /**
     * @param errorCode
     * @param errorMsg
     * @roseuid 45F7E8850119
     */
    public BaseException(String errorCode, String errorMsg) 
    {
    	super(errorMsg);
    	this.errorCode = errorCode;
    	this.errorMsg = errorMsg;
    }
    
    public BaseException(String errMsg,Throwable rootCause) {
    	super(errMsg,rootCause);
    }

    /**
     * @return int
     * @roseuid 45F7E7CD006D
     */
    public String getErrorCode() 
    {
    	return this.errorCode;     
    }
    
    /**
     * @param errorCode
     * @roseuid 45F7E7D8003E
     */
    public void setErrorCode(String errorCode) 
    {
    	this.errorCode = errorCode;     
    }
    
    /**
     * @return String
     * @roseuid 45F7E7CD006D
     */
    public String getErrorMsg() 
    {
    	return this.errorMsg;     
    }
    
    /**
     * @param errorMsg
     * @roseuid 45F7E7D8003E
     */
    public void setErrorMsg(String errorMsg) 
    {
    	this.errorMsg = errorMsg;     
    }
    
}
