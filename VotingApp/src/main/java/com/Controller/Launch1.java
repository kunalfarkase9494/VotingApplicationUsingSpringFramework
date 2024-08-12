package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class Launch1 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		
		if(username.equals("admin_01") && password.equals("admin@321")) {
			mv.setViewName("adminhome");
			mv.addObject("acheck", username);
		}else 
		{
			mv.setViewName("admin");
		}
		
		return mv;
	}
	
}
