package com.zhen.core.service;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhen.core.dao.SqlDao;

/**
 * 基础逻辑bean
 * SysUser: Administrator
 * To change this template use File | Settings | File Templates.
 */
public class BaseService implements ServletContextAware {

    protected ServletContext servletContext;

    @Autowired
    @Qualifier("sqlDao")
    protected SqlDao sqlDao;

    @Autowired
    @Qualifier("pageService")
    protected AbstractPageService pageService;
    
	protected Log logger = LogFactory.getLog(this.getClass());

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public WebApplicationContext getWebApplicationContext() {
        return WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
    }

    public SqlDao getSqlDao() {
        return sqlDao;
    }

    public void setSqlDao(SqlDao sqlDao) {
        this.sqlDao = sqlDao;
    }

    public AbstractPageService getPageService() {
        return pageService;
    }

    public void setPageService(AbstractPageService pageService) {
        this.pageService = pageService;
    }

    public <T> T getBean(String id) {
        return (T) getWebApplicationContext().getBean(id);
    }

    /**
     * 根据给定表名，找到该表中某个字段中记录的最大值，常用在添加数据时查询最大排序号
     *
     * @param tableName   表名
     * @param orderColumn 排序字段名
     * @throws Exception
     */
//    public Long queryLastOrder(String tableName, String orderColumn)
//            throws Exception {
//        if (StringUtil.isEmpty(tableName) || StringUtil.isEmpty(orderColumn)) {
//            throw new Exception("参数错误");
//        }
//
//        String sql = "SELECT MAX(" + orderColumn + ") FROM " + tableName;
//        Long temp = sqlDao.query("common.queryMaxOrder", sql);
//        if (temp == null) {
//            temp = 0L;
//        }
//        return temp + 1;
//    }

//    /**
//     * 记录上移
//     *
//     * @param tableName   表名
//     * @param orderColumn 排序字段名
//     * @param pkColumn    主键字段
//     * @param pkValue     主键值
//     * @param curOrder    当前的排序号
//     * @param whereSql    过滤条件（必须使用AND开头）,用于指定在某些特定位置的排序，如新闻只能和所在栏目下的新闻排序: AND 栏目id='102'
//     * @throws Exception
//     */
//    public void moveUp(String tableName, String orderColumn, String pkColumn,
//                       String pkValue, String curOrder, String whereSql) throws Exception {
//        if (StringUtil.isEmpty(tableName) || StringUtil.isEmpty(orderColumn)
//                || StringUtil.isEmpty(pkColumn) || StringUtil.isEmpty(pkValue)
//                || StringUtil.isEmpty(curOrder)) {
//            throw new Exception("参数错误");
//        }
//
//        if (StringUtil.isEmpty(whereSql)) {
//            whereSql = "";
//        }
//
//        String sql = "SELECT TOP 1 " + pkColumn + " AS TARPK, " + orderColumn
//                + " AS TARORDER FROM " + tableName + " WHERE " + orderColumn + "<"
//                + curOrder + " " + whereSql + " ORDER BY " + orderColumn + " DESC";
//        Map<String, Object> map = sqlDao.query("common.queryRecord", sql);
//        if (map == null || map.isEmpty()) {
//            return;
//        }
//
//        Object tarPk = ValueUtils.getValueFromMap(map, "TARPK");
//        Object tarOrder = ValueUtils.getValueFromMap(map, "TARORDER");
//        if (StringUtil.isEmpty(tarPk) || StringUtil.isEmpty(tarOrder)) {
//            return;
//        }
//
//        String update1 = "UPDATE " + tableName + " SET " + orderColumn + "='"
//                + tarOrder + "' WHERE " + pkColumn + "='" + pkValue + "'";
//
//        String update2 = "UPDATE " + tableName + " SET " + orderColumn + "='"
//                + curOrder + "' WHERE " + pkColumn + "='" + tarPk + "'";
//
//        sqlDao.update("common.executeSql", update1);
//        sqlDao.update("common.executeSql", update2);
//    }
//
//    /**
//     * 记录下移
//     *
//     * @param tableName   表名
//     * @param orderColumn 排序字段名
//     * @param pkColumn    主键字段
//     * @param pkValue     主键值
//     * @param curOrder    当前的排序号
//     * @param whereSql    过滤条件（必须使用AND开头）,用于指定在某些特定位置的排序，如新闻只能和所在栏目下的新闻排序: AND 栏目id='102'
//     * @throws Exception
//     */
//    public void moveDown(String tableName, String orderColumn, String pkColumn,
//                         String pkValue, String curOrder, String whereSql) throws Exception {
//        if (StringUtil.isEmpty(tableName) || StringUtil.isEmpty(orderColumn)
//                || StringUtil.isEmpty(pkColumn) || StringUtil.isEmpty(pkValue)
//                || StringUtil.isEmpty(curOrder)) {
//            throw new Exception("参数错误");
//        }
//
//        if (StringUtil.isEmpty(whereSql)) {
//            whereSql = "";
//        }
//
//        String sql = "SELECT TOP 1 " + pkColumn + " AS TARPK, " + orderColumn
//                + " AS TARORDER FROM " + tableName + " WHERE " + orderColumn + ">"
//                + curOrder + " " + whereSql + " ORDER BY " + orderColumn + " ASC";
//        Map<String, Object> map = sqlDao.query("common.queryRecord", sql);
//        if (map == null || map.isEmpty()) {
//            return;
//        }
//
//        Object tarPk = ValueUtils.getValueFromMap(map, "TARPK");
//        Object tarOrder = ValueUtils.getValueFromMap(map, "TARORDER");
//        if (StringUtil.isEmpty(tarPk) || StringUtil.isEmpty(tarOrder)) {
//            return;
//        }
//
//        String update1 = "UPDATE " + tableName + " SET " + orderColumn + "='"
//                + tarOrder + "' WHERE " + pkColumn + "='" + pkValue + "'";
//
//        String update2 = "UPDATE " + tableName + " SET " + orderColumn + "='"
//                + curOrder + "' WHERE " + pkColumn + "='" + tarPk + "'";
//
//        sqlDao.update("common.executeSql", update1);
//        sqlDao.update("common.executeSql", update2);
//    }
}
