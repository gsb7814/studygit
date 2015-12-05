package com.sxmccitlab.common.exception;

public class ConfigException extends BaseException {
	
    public ConfigException() 
    {
    	super();
    }
    
    /**
     * @param errorMsg
     * @roseuid 45F7E8F302BF
     */
    public ConfigException(String errorMsg) 
    {
    	super(errorMsg);
    }
    
    /**
     * @param errorCode
     * @param errorMsg
     * @roseuid 45F7E8850119
     */
    public ConfigException(String errorCode, String errorMsg) 
    {
    	super(errorCode, errorMsg);
    }


}
