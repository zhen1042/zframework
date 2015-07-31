package com.zhen.core.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zhen.core.dao.SqlDao;
import com.zhen.core.domain.PageParam;
import com.zhen.core.domain.PageResult;
import com.zhen.core.util.StringUtil;

@Service("oraclePageService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class OraclePageService extends AbstractPageService {

	@Autowired
    @Qualifier("sqlDao")
    protected SqlDao sqlDao;

    public void setSqlDao(SqlDao sqlDao) {
        this.sqlDao = sqlDao;
    }
    
	@Override
	public PageResult pageQuery(PageParam pageParam) throws Exception {
		return pageQuery(pageParam, null);
	}

	/**
     * 分页查询
     * @param pageParam 查询条件
     * @param sortAlias 排序字段转换
     * @return PageResult
     * @throws Exception 异常
     */
	@Override
	public PageResult pageQuery(PageParam pageParam,
			Map<String, String> sortAlias) throws Exception {
		Date dateStart = new Date();
		PageResult pageResult = new PageResult();
		String refresh = pageParam.getRefresh();
		long recordCount;
		
		if (refresh != null && refresh.equals("1")) {
			recordCount = sqlDao.query(pageParam.getCountSql(), pageParam);
			pageParam.setRecordCount(recordCount);
		} else {
			if (pageParam.getRecordCount() == 0) {
				recordCount = sqlDao.query(pageParam.getCountSql(), pageParam);
                pageParam.setRecordCount(recordCount);
			} else {
				recordCount = pageParam.getRecordCount();
			}
		}
		if (pageParam.getRows() == 0) pageParam.setRows(20L);
		if (recordCount > 0) {
			if (pageParam.getPage() == 0) pageParam.setPage(1L);
			Long beginNum = (pageParam.getPage() - 1) * pageParam.getRows();
			Long endNum = (pageParam.getPage() * pageParam.getRows() > recordCount) ?
                    recordCount + 1 : pageParam.getPage() * pageParam.getRows() + 1;
			String head = "select * from (select tmp.*, rownum as row_num from (";
            String foot = ") tmp where rownum < " + endNum + ") where row_num > " + beginNum;
            pageParam.setHead(head);
            pageParam.setFoot(foot);
            String sortOrder = "";
            String columnSort = "";
            String defaultSort = "";
            if (!StringUtil.isEmpty(pageParam.getSort())) {
            	columnSort = getSortAlias(sortAlias, StringUtil.escapeSql(pageParam.getSort()));
                sortOrder += "," + columnSort;
                if (!StringUtil.isEmpty(pageParam.getOrder()) &&
                        (pageParam.getOrder().equalsIgnoreCase("asc") || pageParam.getOrder().equalsIgnoreCase("desc"))) {
                	sortOrder += " " + pageParam.getOrder();
                }
            } else if (!StringUtil.isEmpty(pageParam.getDefaultSort())) {
            	defaultSort = getSortAlias(sortAlias, StringUtil.escapeSql(pageParam.getDefaultSort()));
                if (!repeatSort(columnSort, defaultSort)) {
                    sortOrder += "," + defaultSort;
                }
            }
            
            if (sortOrder.length() > 0) {
                sortOrder = "order by " + sortOrder.substring(1);
            }
            pageParam.setSortOrder(sortOrder);
            pageResult.setPageList(sqlDao.list(pageParam.getRecordSql(), pageParam));
		} else {
			pageParam.setPage(0L);
		}
		
		pageParam.setHead("");
		pageParam.setFoot("");
		pageParam.setRefresh("");
		pageParam.setSortOrder("");
		Date dateEnd = new Date();
        pageParam.setQueryTime(dateEnd.getTime()-dateStart.getTime());
        pageParam.reset();
        pageResult.setPageParam(pageParam);
        logger.info("查询时间："+pageParam.getQueryTime()+"毫秒");
		return pageResult;
	}

}
