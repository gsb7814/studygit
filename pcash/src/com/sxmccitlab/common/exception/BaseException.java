package com.sxmccitlab.common.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668714919608965202L;

	/**
	 * �쳣���룬������������£�
	 * 1)	000000: ����
	 * 2)	��1: δ֪����
	 * 3)	�����������ı�����8λ����ɣ���ʽΪXX0YYY��
	 * ���У�
	 * XX�������ģ��ı���μ���������ĵ�
	 * YYY�������ţ�
	 * 0~100����������ţ�����ʹ�ã����������Ĵ�������ĵ���"����������"���֣�
	 * YYY��ʾ��Ӧ�õĴ���ţ��ɿ�����Ա�Լ����壻
	 */
    private String errorCode;
    
    /**
     * �쳣������Ϣ
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
