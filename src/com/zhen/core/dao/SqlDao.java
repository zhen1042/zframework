package com.zhen.core.dao;


import org.springframework.dao.DataAccessException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Map;


/**
 * 数据访问对象的接口
 * To change this template use File | Settings | File Templates.
 */
public interface SqlDao {

//    public void initOracleSort(String nls_sort) throws DataAccessException;

    /**
     * 以Map的形式返回结果集
     *
     * @param sqlID       sql语句id
     * @param object      查询参数
     * @param keyProperty map的key值，对应于结果集中的字段
     * @return Map
     * @throws DataAccessException
     */
    public Map query(String sqlID, Object object, String keyProperty) throws DataAccessException;

    /**
     * 获得单个记录
     *
     * @param sqlID  sql语句id
     * @param object 查询参数
     * @return Object
     * @throws DataAccessException 数据库访问异常
     */
    public <T> T query(String sqlID, Object object) throws DataAccessException;


    /**
     * 获得单个记录（无参数）
     *
     * @param sqlID sql语句id
     * @return Object
     * @throws DataAccessException 数据库访问异常
     */
    public <T> T query(String sqlID) throws DataAccessException;

    /**
     * 获得记录集
     *
     * @param sqlID  sql语句id
     * @param object 查询参数
     * @return List
     * @throws DataAccessException 数据库访问异常
     */
    public <T> List<T> list(String sqlID, Object object) throws DataAccessException;

    /**
     * 获得记录集（无参数）
     *
     * @param sqlID sql语句id
     * @return List
     * @throws DataAccessException 数据库访问异常
     */
    public <T> List<T> list(String sqlID) throws DataAccessException;

    /**
     * 插入记录
     *
     * @param sqlID  sql语句id
     * @param object 插入对象
     * @return object 返回自动生成的主键
     * @throws DataAccessException 数据库访问异常
     */
    public Object create(String sqlID, Object object) throws DataAccessException;


    /**
     * 更新记录
     *
     * @param sqlID  sql语句id
     * @param object 更新对象
     * @return int 返回更新记录数
     * @throws DataAccessException 数据库访问异常
     */
    public int update(String sqlID, Object object) throws DataAccessException;


    /**
     * 删除记录
     *
     * @param sqlID  sql语句id
     * @param object 删除对象
     * @return int 删除影响的记录数
     * @throws DataAccessException 数据库访问异常
     */
    public int delete(String sqlID, Object object) throws DataAccessException;

    public Connection getConnection();

    public void releaseConnection(Connection connection);

    public DataSource getDataSource();
    
}
