package com.zhen.core.domain;


import java.util.List;

/**
 * 翻页查询返回结果
 * SysUser: Administrator
 */
public class PageResult extends SerializeCloneable {

	private PageParam pageParam;
	private List pageList;
	public PageParam getPageParam() {
		return pageParam;
	}
	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}
	public List getPageList() {
		return pageList;
	}
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}
}
