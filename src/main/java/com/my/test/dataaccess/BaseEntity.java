/************************************************************************************
 *  Copyright 2012 WZITech Corporation. All rights reserved.
 *	
 *	模	块：		BaseEntity
 *	包	名：		com.wzitech.chaos.framework.server.dataaccess
 *	项目名称：	chaos-dataaccess 
 *	作	者：		Shawn
 *	创建时间：	2012-4-23
 *	描	述：		Entity基类
 *	更新纪录：	1. Shawn 创建于 2012-4-23 下午8:44:14
 * 				
 ************************************************************************************/
package com.my.test.dataaccess;

//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Entity基类
 * @author Shawn
 *
 */
// 解决Spring Data Redis使用Jason1.X，与Jason2.X不兼容的问题
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BaseEntity implements Serializable {

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * 所有Entity都必须具有Long类型的主键
	 */
	protected Object id;

	/**
	 * 重载Entity类的toString()方法
	 * 返回Entity类所有属性值
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
