package com.zhen.core.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zhen.core.domain.PageParam;
import com.zhen.core.domain.PageResult;
import com.zhen.core.util.StringUtil;

/**
 * 抽象的分页逻辑bean
 * User: Administrator
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractPageService {

	protected Log logger = LogFactory.getLog(this.getClass());
    /**
     * 得到排序字段的别名
     *
     * @param sortAlias 排序字段Map
     * @param sort      页面提交的排序字段
     * @return String
     */
    protected String getSortAlias(Map sortAlias, String sort) {
        return sortAlias == null || !sortAlias.containsKey(sort) ? sort : (String) sortAlias.get(sort);
    }


    /**
     * 判断重复排序
     *
     * @param columnSort
     * @param defaultSort
     * @return
     */
    protected boolean repeatSort(String columnSort, String defaultSort) {
        return !StringUtil.isEmpty(columnSort) && !StringUtil.isEmpty(defaultSort) && defaultSort.indexOf(columnSort) != -1;
    }

    /**
     * 分页查询
     * @param pageParam 查询条件
     * @return PageResult
     * @throws Exception 异常
     */
    public abstract PageResult pageQuery(PageParam pageParam) throws Exception;

    /**
     * 分页查询
     * @param pageParam 查询条件
     * @param sortAlias 排序字段转换
     * @return PageResult
     * @throws Exception 异常
     */
    public abstract PageResult pageQuery(PageParam pageParam, Map<String,String> sortAlias) throws Exception;
}
