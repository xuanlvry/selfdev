/************************************************************************************
 *  Copyright 2012 WZITech Corporation. All rights reserved.
 *	
 *	模	块：		SystemExceptin
 *	包	名：		com.wzitech.chaos.framework.common.exception
 *	项目名称：	chaos-common 
 *	作	者：		Shawn
 *	创建时间：	2012-4-13
 *	描	述：		系统异常基类（Checked Exception）
 *	更新纪录：	1. Shawn 创建于 2012-4-13 下午3:57:22
 * 				
 ************************************************************************************/
package com.my.test.common.exception;

import com.my.test.common.constants.RuntimeConstants;
import com.my.test.common.enums.ErrorCodeType;
import org.apache.commons.lang3.StringUtils;

/**
 * 系统异常基类（UnChecked Exception）
 * @author Shawn
 *
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	private String errorCode;
	
	public void setExceptionStackMsg(String exceptionStackMsg) {
		this.exceptionStackMsg = exceptionStackMsg;
	}

	/**
	 * 异常信息
	 */
	private String errorMsg;
	
	/**
	 * 错误代码类型 :<br/>
	 * E001：内部错误<br/>
	 * E002：外部错误
	 */
	private ErrorCodeType errorCodeType;
	
	/**
	 * 业务信息参数
	 */
	private String[]  args ;
	
	/**
	 * 内部异常
	 */
	private Throwable t;
	
	/**
	 * 堆栈信息
	 */
	private String exceptionStackMsg;
	
	/**
	 * 通过错误码及业务信息构造SystemException
	 * @param errorCode
	 * @param args
	 */
	public SystemException(String errorCode, String... args) {
		super(errorCode);
		this.errorCode = errorCode;
		this.args = args;
	}

	/**
	 * 通过错误码及错误异常构造SystemException
	 * @param errorCode
	 * @param t
	 */
	public SystemException(String errorCode, Throwable t) {
		super(t);
		this.t = t;
		this.errorCode=errorCode;
	}
	
	/**
	 * 获取异常堆栈信息
	 * @return
	 */
	public String getExceptionStackMsg() {
		if(this.t!=null){
			return this.t.getStackTrace().toString();
		}
		if(exceptionStackMsg != null){
			return exceptionStackMsg;
		}
		return null;
	}
	
	/**
	 * 判断是否为系统异常
	 * @return
	 */
	public boolean isSystemException() {
    	if (StringUtils.isNotBlank(errorCode)) {
    		if (errorCode.startsWith(RuntimeConstants.SYSTEM_EXCEPTION_PREFIX)) {
    			return true;
    		}
    	}
    	return false;
    }
    
	/**
	 * 判断是否为业务异常
	 * @return
	 */
    public boolean isBusinessException() {
    	if (StringUtils.isNotBlank(errorCode)) {
    		if (errorCode.startsWith(RuntimeConstants.BUSSINESS_EXCEPTION_PREFIX)) {
    			return true;
    		}
    	}
    	return false;
    }
    
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public ErrorCodeType getErrorCodeType() {
		return errorCodeType;
	}

	public void setErrorCodeType(ErrorCodeType errorCodeType) {
		this.errorCodeType = errorCodeType;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public Throwable getT() {
		return t;
	}

	public void setT(Throwable t) {
		this.t = t;
	}
}
