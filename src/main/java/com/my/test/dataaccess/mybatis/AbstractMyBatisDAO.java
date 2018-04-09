/************************************************************************************
 *  Copyright 2012 WZITech Corporation. All rights reserved.
 *
 *	模	块：		AbstractMybatisBaseDAO
 *	包	名：		com.wzitech.chaos.framework.dataaccess.mybatis
 *	项目名称：	chaos-dataaccess 
 *	作	者：		Shawn
 *	创建时间：	2012-4-14
 *	描	述：		MyBatis DAO的抽象泛型基类. 
 *	更新纪录：	1. Shawn 创建于 2012-4-14 上午1:32:35
 *
 ************************************************************************************/
package com.my.test.dataaccess.mybatis;

import com.my.test.common.utils.GenericsUtils;
import com.my.test.dataaccess.BaseEntity;
import com.my.test.dataaccess.pagination.GenericPage;
import org.apache.commons.lang3.Validate;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis DAO的抽象泛型基类<br/>
 * 继承于MyBatis Spring的SqlSessionDaoSupport,提供了基于泛型的数据访问方法.
 *
 * @author Shawn
 */
public abstract class AbstractMyBatisDAO<T extends BaseEntity, PK extends Serializable> extends SqlSessionDaoSupport
        implements IMyBatisBaseDAO<T, PK> {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractMyBatisDAO.class);

    protected Class<T> entityClass;

    protected String mapperNamespace;

    @SuppressWarnings("unchecked")
    public AbstractMyBatisDAO() {
        // 通过范型反射，取得在子类中定义的class.
        this.entityClass = GenericsUtils.getSuperClassGenricType(getClass());
        this.mapperNamespace = entityClass.getName();
    }

    /**
     * @return the sqlmapNamespace
     */
    public String getMapperNamespace() {
        return mapperNamespace;
    }

    /**
     * @param mapperNamespace the sqlmapNamespace to set
     */
    public void setMapNamespace(String mapperNamespace) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(mapperNamespace);

        this.mapperNamespace = mapperNamespace;
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#count()
     */
    @Override
    public int count() {
        return (Integer) this.getSqlSession().selectOne(this.mapperNamespace + MyBatisPostfixConstants.COUNT);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#countByMap(java.util.Map)
     */
    @Override
    public int countByMap(Map<String, Object> queryParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(queryParam);

        return (Integer) this.getSqlSession().selectOne(this.mapperNamespace + MyBatisPostfixConstants.COUNT_BY_MAP, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#countLikeByMap(java.util.Map)
     */
    @Override
    public int countLikeByMap(Map<String, Object> queryParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(queryParam);

        return (Integer) this.getSqlSession().selectOne(this.mapperNamespace + MyBatisPostfixConstants.COUNT_LIKE_BY_MAP, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#insert(java.lang.Object)
     */
    @Override
    public Object insert(T entity) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notNull(entity);

        long affectedRows = this.getSqlSession().insert(this.mapperNamespace + MyBatisPostfixConstants.INSERT, entity);
//		entity.setId(id);
        return affectedRows;
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#batchInsert(java.util.List)
     */
    @Override
    public int batchInsert(List<T> list) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(list);

        // 使用update代替insert
        // 以便获取影响记录行数
        return this.getSqlSession().update(this.mapperNamespace + MyBatisPostfixConstants.BATCH_INSERT, list);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#insertByStatement(java.lang.String, java.util.Map)
     */
    @Override
    public int insertByStatement(String statementPostfix, Map<String, Object> insertParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(statementPostfix);
        Validate.notEmpty(insertParam);

        // 使用update代替insert
        // 以便获取影响记录行数
        return this.getSqlSession().update(this.mapperNamespace + "." + statementPostfix, insertParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#updateById(java.lang.Object)
     */
    @Override
    public int update(T entity) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notNull(entity);

        List<T> list = new ArrayList<T>();
        list.add(entity);

        return batchUpdate(list);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#batchUpdate(java.util.List)
     */
    @Override
    public int batchUpdate(List<T> list) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(list);
        Validate.noNullElements(list);

        return this.getSqlSession().update(this.mapperNamespace + MyBatisPostfixConstants.BATCH_UPDATE, list);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#updateById(java.io.Serializable, java.util.Map)
     */
    @Override
    public int updateById(PK id, Map<String, Object> updateParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(updateParam);

        List<PK> ids = new ArrayList<PK>();
        ids.add(id);

        return batchUpdateByIds(ids, updateParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#batchUpdateByIds(java.util.List, java.util.Map)
     */
    @Override
    public int batchUpdateByIds(List<PK> ids, Map<String, Object> updateParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(ids);
        Validate.notEmpty(updateParam);
        Validate.noNullElements(ids);

        updateParam.put("ids", ids);

        return this.getSqlSession().update(this.mapperNamespace + MyBatisPostfixConstants.BATCH_UPDATE_BY_IDS, updateParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#updateByStatement(java.lang.String, java.util.Map)
     */
    @Override
    public int updateByStatement(String statementPostfix, Map<String, Object> queryParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(statementPostfix);
        Validate.notEmpty(queryParam);

        return this.getSqlSession().update(this.mapperNamespace + "." + statementPostfix, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#delete(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public int delete(T entity) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notNull(entity);
        Validate.notNull(entity.getId());

        return deleteById((PK) entity.getId());
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#deleteById(java.io.Serializable)
     */
    @Override
    public int deleteById(PK id) {
        List<PK> ids = new ArrayList<PK>();
        ids.add(id);

        return batchDeleteByIds(ids);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#batchDelete(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public int batchDelete(List<T> list) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(list);
        Validate.noNullElements(list);

        List<PK> ids = new ArrayList<PK>();
        for (T entity : list) {
            ids.add((PK) entity.getId());
        }

        return batchDeleteByIds(ids);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#batchDeleteByIds(java.util.List)
     */
    @Override
    public int batchDeleteByIds(List<PK> ids) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(ids);
        Validate.noNullElements(ids);

        return this.getSqlSession().delete(this.mapperNamespace + MyBatisPostfixConstants.BATCH_DELETE_BY_IDS, ids);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#deleteByMap(java.util.Map)
     */
    @Override
    public int deleteByMap(Map<String, Object> deleteParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(deleteParam);

        return this.getSqlSession().delete(this.mapperNamespace + MyBatisPostfixConstants.DELETE_BY_MAP, deleteParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#deleteByStatement(java.lang.String, java.util.Map)
     */
    @Override
    public int deleteByStatement(String statementPostfix, Map<String, Object> deleteParam) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(statementPostfix);
        Validate.notEmpty(deleteParam);

        return this.getSqlSession().delete(this.mapperNamespace + "." + statementPostfix, deleteParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectById(java.io.Serializable)
     */
    @Override
    public T selectById(PK id) {
        return this.getSqlSession().selectOne(this.mapperNamespace + MyBatisPostfixConstants.SELECT_BY_ID, id);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByIds(java.util.List)
     */
    @Override
    public List<T> selectByIds(List<PK> ids) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notEmpty(ids);
        Validate.noNullElements(ids);

        return this.getSqlSession().selectList(this.mapperNamespace + MyBatisPostfixConstants.SELECT_BY_IDS, ids);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectUniqueByProp(java.lang.String, java.lang.Object)
     */
    @Override
    public T selectUniqueByProp(String propertyName, Object propertyValue) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(propertyName);
        Validate.notNull(propertyValue);

        Map<String, Object> queryParam = new HashMap<String, Object>();
        queryParam.put(propertyName, propertyValue);

        return this.getSqlSession().selectOne(this.mapperNamespace + MyBatisPostfixConstants.SELECT_UNIQUE_BY_PROP, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectByProp(java.lang.String, java.lang.Object)
     */
    @Override
    public List<T> selectByProp(String propertyName, Object propertyValue) {
        return selectByProp(propertyName, propertyValue, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectByProp(java.lang.String, java.lang.Object, java.lang.String, boolean)
     */
    @Override
    public List<T> selectByProp(String propertyName, Object propertyValue, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(propertyName);
        Validate.notNull(propertyValue);
        Validate.notBlank(orderBy);

        Map<String, Object> queryParam = new HashMap<String, Object>();
        queryParam.put(propertyName, propertyValue);

        return selectByMap(queryParam, orderBy, isAsc);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectByProp(java.lang.String, java.lang.Object, int, int)
     */
    @Override
    public GenericPage<T> selectByProp(String propertyName, Object propertyValue, int pageSize, int startIndex) {
        return selectByProp(propertyName, propertyValue, pageSize, startIndex, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectByProp(java.lang.String, java.lang.Object, int, int, java.lang.String, boolean)
     */
    @Override
    public GenericPage<T> selectByProp(String propertyName, Object propertyValue, int pageSize, int startIndex, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(propertyName);
        Validate.notNull(propertyValue);
        Validate.notBlank(orderBy);

        Map<String, Object> queryParam = new HashMap<String, Object>();
        queryParam.put(propertyName, propertyValue);

        return selectByMap(queryParam, pageSize, startIndex, orderBy, isAsc);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectAll()
     */
    @Override
    public List<T> selectAll() {
        return selectByMap(null, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectAll(java.lang.String, boolean)
     */
    @Override
    public List<T> selectAll(String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(orderBy);

        return selectByMap(null, orderBy, isAsc);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectAll(int, int)
     */
    @Override
    public GenericPage<T> selectAll(int pageSize, int startIndex) {
        return selectByMap(null, pageSize, startIndex);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectAll(int, int, java.lang.String, boolean)
     */
    @Override
    public GenericPage<T> selectAll(int pageSize, int startIndex, String orderBy, boolean isAsc) {
        return selectByMap(null, pageSize, startIndex, orderBy, isAsc);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByMap(java.util.Map)
     */
    @Override
    public List<T> selectByMap(Map<String, Object> queryParam) {
        return selectByMap(queryParam, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByMap(java.util.Map, java.lang.String, boolean)
     */
    @Override
    public List<T> selectByMap(Map<String, Object> queryParam, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(orderBy);

        if (null == queryParam) {
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if (isAsc) {
            queryParam.put("ORDER", "ASC");
        } else {
            queryParam.put("ORDER", "DESC");
        }

        return this.getSqlSession().selectList(this.mapperNamespace + MyBatisPostfixConstants.SELECT_BY_MAP, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByMap(java.util.Map, int, int)
     */
    @Override
    public GenericPage<T> selectByMap(Map<String, Object> queryParam, int pageSize, int startIndex) {
        return selectByMap(queryParam, pageSize, startIndex, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByMap(java.util.Map, int, int, java.lang.String, boolean)
     */
    @Override
    public GenericPage<T> selectByMap(Map<String, Object> queryParam, int pageSize, int startIndex, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(orderBy);

        //检查分页参数
        if (pageSize < 1) {
            throw new IllegalArgumentException("分页pageSize参数必须大于1");
        }

        if (startIndex < 0) {
            throw new IllegalArgumentException("分页startIndex参数必须大于0");
        }

        if (null == queryParam) {
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if (isAsc) {
            queryParam.put("ORDER", "ASC");
        } else {
            queryParam.put("ORDER", "DESC");
        }

        int totalSize = countByMap(queryParam);

        // 如果数据Count为0，则直接返回
        if (totalSize == 0) {
            return new GenericPage<T>(startIndex, totalSize, pageSize, null);
        }

        List<T> pagedData = this.getSqlSession().selectList(this.mapperNamespace + MyBatisPostfixConstants.SELECT_BY_MAP,
                queryParam, new RowBounds(startIndex, pageSize));

        return new GenericPage<T>(startIndex, totalSize, pageSize, pagedData);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectIds(java.util.Map)
     */
    @Override
    public List<PK> selectIds(Map<String, Object> queryParam) {
        return selectIds(queryParam, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectIds(java.util.Map, java.lang.String, boolean)
     */
    @Override
    public List<PK> selectIds(Map<String, Object> queryParam, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(orderBy);

        if (null == queryParam) {
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if (isAsc) {
            queryParam.put("ORDER", "ASC");
        } else {
            queryParam.put("ORDER", "DESC");
        }

        return this.getSqlSession().selectList(this.mapperNamespace + MyBatisPostfixConstants.SELECT_IDS, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectIds(java.util.Map, int, int)
     */
    @Override
    public GenericPage<PK> selectIds(Map<String, Object> queryParam, int pageSize, int startIndex) {
        return selectIds(queryParam, pageSize, startIndex, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectIds(java.util.Map, int, int, java.lang.String, boolean)
     */
    @Override
    public GenericPage<PK> selectIds(Map<String, Object> queryParam, int pageSize, int startIndex, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(orderBy);

        //检查分页参数
        if (pageSize < 1) {
            throw new IllegalArgumentException("分页pageSize参数必须大于1");
        }

        if (startIndex < 0) {
            throw new IllegalArgumentException("分页startIndex参数必须大于0");
        }

        if (null == queryParam) {
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if (isAsc) {
            queryParam.put("ORDER", "ASC");
        } else {
            queryParam.put("ORDER", "DESC");
        }

        int totalSize = countByMap(queryParam);

        // 如果数据Count为0，则直接返回
        if (totalSize == 0) {
            return new GenericPage<PK>(startIndex, totalSize, pageSize, null);
        }

        List<PK> pagedData = this.getSqlSession().selectList(this.mapperNamespace + MyBatisPostfixConstants.SELECT_IDS,
                queryParam, new RowBounds(startIndex, pageSize));

        return new GenericPage<PK>(startIndex, totalSize, pageSize, pagedData);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByStatement(java.lang.String, java.util.Map)
     */
    @Override
    public List<T> selectByStatement(String statementPostfix, Map<String, Object> queryParam) {
        return selectByStatement(statementPostfix, queryParam, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByStatement(java.lang.String, java.util.Map, java.lang.String, boolean)
     */
    @Override
    public List<T> selectByStatement(String statementPostfix, Map<String, Object> queryParam, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(statementPostfix);

        if (null == queryParam) {
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if (isAsc) {
            queryParam.put("ORDER", "ASC");
        } else {
            queryParam.put("ORDER", "DESC");
        }

        return this.getSqlSession().selectList(this.mapperNamespace + statementPostfix, queryParam);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByStatement(java.lang.String, java.util.Map, int, int)
     */
    @Override
    public GenericPage<T> selectByStatement(String statementPostfix, Map<String, Object> queryParam, int pageSize, int startIndex) {
        return selectByStatement(statementPostfix, queryParam, pageSize, startIndex, "id", true);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.mybatis.IMyBatisBaseDAO#selectByStatement(java.lang.String, java.util.Map, int, int, java.lang.String, boolean)
     */
    @Override
    public GenericPage<T> selectByStatement(String statementPostfix, Map<String, Object> queryParam, int pageSize, int startIndex, String orderBy, boolean isAsc) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(orderBy);

        //检查分页参数
        if (pageSize < 1) {
            throw new IllegalArgumentException("分页pageSize参数必须大于1");
        }

        if (startIndex < 0) {
            throw new IllegalArgumentException("分页startIndex参数必须大于0");
        }

        if (null == queryParam) {
            queryParam = new HashMap<String, Object>();
        }
        queryParam.put("ORDERBY", orderBy);
        if (isAsc) {
            queryParam.put("ORDER", "ASC");
        } else {
            queryParam.put("ORDER", "DESC");
        }

        int totalSize = countByMap(queryParam);

        // 如果数据Count为0，则直接返回
        if (totalSize == 0) {
            return new GenericPage<T>(startIndex, totalSize, pageSize, null);
        }

        List<T> pagedData = this.getSqlSession().selectList(this.mapperNamespace + "." + statementPostfix,
                queryParam, new RowBounds(startIndex, pageSize));

        return new GenericPage<T>(startIndex, totalSize, pageSize, pagedData);
    }

    /* (non-Javadoc)
     * @see com.wzitech.chaos.framework.server.dataaccess.IBaseHibernateDAO#selectByNativeSql(java.lang.String)
     */
    @Override
    public List<T> selectByNativeSql(String sql) {
        // 检查参数是否为null或者元素长度为0
        // 如果是抛出异常
        Validate.notBlank(sql);

        return this.getSqlSession().selectList(this.mapperNamespace + MyBatisPostfixConstants.SELECT_BY_NATIVE_SQL, sql);
    }
}
