package com.zhen.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zhen.core.dao.SqlDao;
import com.zhen.core.domain.PageParam;
import com.zhen.core.domain.PageResult;
import com.zhen.core.service.BaseService;
import com.zhen.demo.domain.Hello;
import com.zhen.demo.domain.Sys_log;

@Service("helloService")
public class HelloService extends BaseService {

	@Autowired
	@Qualifier("sqlDao")
	private SqlDao sqlDao;
	
	public Hello queryHello(Hello hello) throws Exception {
		return sqlDao.query("hello.selectHello", hello);
	}
	
	public List<Sys_log> queryList() throws Exception {
		return sqlDao.list("hello.query_list");
	}
	
	public PageResult page(PageParam pageParam) throws Exception {
		pageParam.setCountSql("hello.pageCount");
		pageParam.setRecordSql("hello.pageList");
		return pageService.pageQuery(pageParam);
	}
}
