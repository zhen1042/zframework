package com.zhen.core.dao;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@SuppressWarnings({"unchecked"})
@Repository("sqlDao")
public class SqlDaoImpl extends SqlSessionDaoSupport implements SqlDao {

	private Log logger = LogFactory.getLog(getClass());
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public Map query(String sqlID, Object object, String keyProperty) throws DataAccessException {
		printSql(sqlID,object);
		return super.getSqlSession().selectMap(sqlID, object, keyProperty);
	}

	@Override
	public <T> T query(String sqlID, Object object) throws DataAccessException {
		printSql(sqlID,object);
		return super.getSqlSession().selectOne(sqlID, object);
	}

	@Override
	public <T> T query(String sqlID) throws DataAccessException {
		return query(sqlID,null);
	}

	@Override
	public <T> List<T> list(String sqlID, Object object) throws DataAccessException {
		printSql(sqlID,object);
		return super.getSqlSession().selectList(sqlID, object);
	}

	@Override
	public <T> List<T> list(String sqlID) throws DataAccessException {
		return list(sqlID,null);
	}

	@Override
	public Object create(String sqlID, Object object) throws DataAccessException {
		printSql(sqlID,object);
		return super.getSqlSession().insert(sqlID, object);
	}

	@Override
	public int update(String sqlID, Object object) throws DataAccessException {
		printSql(sqlID,object);
		return super.getSqlSession().update(sqlID, object);
	}

	@Override
	public int delete(String sqlID, Object object) throws DataAccessException {
		printSql(sqlID,object);
		return super.getSqlSession().delete(sqlID, object);
	}

	@Override
	public Connection getConnection() {
		return DataSourceUtils.getConnection(this.getDataSource());
	}

	@Override
	public void releaseConnection(Connection connection) {
		DataSourceUtils.releaseConnection(connection, this.getDataSource());
	}

	@Override
	public DataSource getDataSource() {
		return this.getDataSource();
	}
	
	/**
     * 打印sql执行语句
     *
     * @param sqlID     sql语句id
     * @param parameter 参数对象
     */
    private void printSql(String sqlID, Object parameter) {
        if (logger.isInfoEnabled()) {
            Configuration configuration = (Configuration) super.getSqlSession().getConfiguration();

            MappedStatement statement = configuration.getMappedStatement(sqlID);
            BoundSql sql = statement.getBoundSql(parameter);
            Object parameterObject = sql.getParameterObject();
            List<ParameterMapping> parameterMappings = sql.getParameterMappings();
            String strSql = sql.getSql();
            strSql = strSql.replaceAll("[\\s]+", " ");
            logger.info(sqlID + ":\n " + strSql);
            String param = "參數：\n";
            String value = "";
            if (parameterMappings.size() > 0 && parameterObject != null) {
            	MetaObject metaObject = configuration.newMetaObject(parameterObject);
            	for (ParameterMapping parameterMapping : parameterMappings) {
            		String propertyName = parameterMapping.getProperty();
            		if (metaObject.hasGetter(propertyName)) {
            			Object obj = metaObject.getValue(propertyName);
            			value = getParameterValue(obj);
            			param += value + "\n";
            		} else if (sql.hasAdditionalParameter(propertyName)) {
            			Object obj = sql.getAdditionalParameter(propertyName);
            			value = getParameterValue(obj);
            			param += value + "\n";
            		}
            	}
            }
            logger.info(param);
        }
    }

    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj == null) {
            value = "null";
        } else if (obj instanceof java.util.Date) {
            value = dateFormat.format(obj);
        } else {
            value = obj.toString();
        }
        return value;
    }
}
