/************************************************************************************
 *  Copyright 2012 WZITech Corporation. All rights reserved.
 *	
 *	模	块：		RuntimeConstants
 *	包	名：		com.wzitech.chaos.framework.common
 *	项目名称：	chaos-common 
 *	作	者：		Shawn
 *	创建时间：	2012-4-13
 *	描	述：		系统运行时常量定义类
 *	更新纪录：	1. Shawn 创建于 2012-4-13 下午4:15:17
 * 				
 ************************************************************************************/
package com.my.test.common.constants;

/**
 * 系统运行时常量定义类
 * @author Shawn
 *
 */
public class RuntimeConstants {
	/**
	 * 业务异常错误码前缀
	 */
	public static final String BUSSINESS_EXCEPTION_PREFIX = "B";

	/**
	 * 系统异常错误码前缀
	 */
	public static final String SYSTEM_EXCEPTION_PREFIX = "S";

	/**
	 * EGM企业管理子系统
	 */
	public static final String GAEA_JEGM = "001";
	
	/**
     * GM子系统
     */
    public static final String GAEA_JGM = "002";

    /**
     * GM Dada子系统
     */
    public static final String GAEA_Dada = "003";
	
	/**
	 * 通过子系统编号获取系统错误码
	 *
	 * @param subSystemCode 系统号
	 * @param errorCode 四位错误码
	 * @return 返回由“系统异常标识”+“子系统编号”+“错误码”组成的错误码
	 */
	public static final String getSystemErrorCode(String subSystemCode, String moduleCode, String errorCode) {
		return SYSTEM_EXCEPTION_PREFIX + subSystemCode + moduleCode + errorCode;
	}

	/**
	 * 通过子系统编号获取业务错误码
	 *
	 * @param subSystemCode 系统号
	 * @param errorCode 四位错误码
	 * @return 返回由“业务异常标识”+“子系统编号”+“错误码”组成的错误码
	 */
	public static final String getBusinessErrorCode(String subSystemCode, String moduleCode, String errorCode) {
		return BUSSINESS_EXCEPTION_PREFIX + subSystemCode + moduleCode + errorCode;
	}
}
