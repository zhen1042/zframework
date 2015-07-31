package com.zhen.sys.controller;

import static com.zhen.core.annotation.ActionAnnotation.Type.NO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhen.core.annotation.ActionAnnotation;
import com.zhen.core.controller.BaseController;

@Controller("manageController")
@RequestMapping({"/sys/login.do"})
public class ManageController extends BaseController {

	
	@ActionAnnotation(name = "系統登錄驗證", check = NO)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return getView(request);
	}
}
