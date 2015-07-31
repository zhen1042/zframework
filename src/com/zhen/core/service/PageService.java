package com.zhen.core.service;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhen.core.domain.PageParam;
import com.zhen.core.domain.PageResult;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = Throwable.class)
public class PageService extends AbstractPageService implements ServletContextAware {

	protected ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
	@Override
	public PageResult pageQuery(PageParam pageParam) throws Exception {
		return getService().pageQuery(pageParam);
	}

	@Override
	public PageResult pageQuery(PageParam pageParam,
			Map<String, String> sortAlias) throws Exception {
		return getService().pageQuery(pageParam, sortAlias);
	}
	
	private String driverClassName;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    
	/**
     * 得到分页bean
     * @return AbstractPageService
     */
    private AbstractPageService getService() {
        BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(this.servletContext);
        if (driverClassName.contains("DmDriver")) {
            return (AbstractPageService) factory.getBean("dmPageService");
        }
        else if (driverClassName.contains("OracleDriver")) {
            return (AbstractPageService) factory.getBean("oraclePageService");
        }
        else if (driverClassName.contains("mysql")) {
            return (AbstractPageService) factory.getBean("mysqlPageService");
        }
        else {
            return (AbstractPageService) factory.getBean("cursorPageService");
        }
    }
}
