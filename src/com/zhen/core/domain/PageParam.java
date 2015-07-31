package com.zhen.core.domain;



/**
 * @author 600804
 * 翻頁參數對象
 */
@SuppressWarnings({"unchecked"})
public class PageParam extends SerializeCloneable {

	private String countSql;
	private String recordSql;
	private String defaultSort;
	private String sort;
	private String order;
	private String head;
	private String foot;
	private String sortOrder;
	private String refresh;
	private long queryTime;
	private long page;
	private long rows;
	private long recordCount;
	private long totalPage;
	
	public String getCountSql() {
		return countSql;
	}
	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}
	public String getRecordSql() {
		return recordSql;
	}
	public void setRecordSql(String recordSql) {
		this.recordSql = recordSql;
	}
	public String getDefaultSort() {
		return defaultSort;
	}
	public void setDefaultSort(String defaultSort) {
		this.defaultSort = defaultSort;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getRefresh() {
		return refresh;
	}
	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}
	public long getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(long queryTime) {
		this.queryTime = queryTime;
	}
	public long getPage() {
		Long intPage = page;
		Long totalPage = getTotalPage();
		intPage = totalPage <= 0 ? 0 : intPage < 1 ? 1 : intPage > totalPage ? totalPage : intPage;
		return intPage;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getRows() {
		return rows;
	}
	public void setRows(long rows) {
		this.rows = rows;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getTotalPage() {
		long count = this.getRecordCount();
		long rows = this.getRows();
		totalPage = count > 0 && rows > 0 ? (int) Math.ceil((double) count / (double) rows) : 0L;
        return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
	public void reset() {
        setRows(getRows());
        setPage(getPage());
        setRecordCount(getRecordCount());
        setTotalPage(getTotalPage());
        setQueryTime(getQueryTime());

        if (getSort() != null && getSort().length() > 0) {
            if (getOrder() == null || !getOrder().equals("asc") && !getOrder().equals("desc")) {
                setOrder("asc");
            }
        }
    }
}
