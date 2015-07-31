package com.zhen.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhen.core.annotation.ActionAnnotation;
import com.zhen.core.controller.BaseController;
import com.zhen.core.domain.PageParam;
import com.zhen.core.domain.PageResult;
import com.zhen.core.util.BeanUtil;
import com.zhen.core.util.EasyuiUtil;
import com.zhen.demo.service.HelloService;

@Controller("helloController")
@RequestMapping("/hello_*.do")
public class HelloController extends BaseController {
	
	@Autowired
	@Qualifier("helloService")
	private HelloService helloService;
	
	@ActionAnnotation(name = "顯示主界面", group = "查詢")
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return getView(request);
	}
	
	@ActionAnnotation(name = "顯示主界面列表", group = "查詢")
	public ModelAndView page(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageParam pageParam = BeanUtil.wrapPageBean(request);
		PageResult pageResult = helloService.page(pageParam);
		return responseText(response,EasyuiUtil.toDataGridData(pageResult));
	}
}
