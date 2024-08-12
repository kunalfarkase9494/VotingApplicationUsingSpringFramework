package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.UserDao;

public class UserSignUp extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String uage = request.getParameter("uage");
		
		ModelAndView mv1 = new ModelAndView("userlogin");
		ModelAndView mv2 = new ModelAndView("signup","msg","You are Under Age");
		ModelAndView mv3 = new ModelAndView("signup","msg1","Username already exists..");
		
		
		String path = "D:\\Advance java\\Spring-core\\VotingApp\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		UserDao uDao = cxt.getBean("uDao",UserDao.class);
		
		if(Integer.valueOf(uage)>=18) {
			int ra  = uDao.addUser(uname, upass, Integer.valueOf(uage));
			if(ra==0) {
				return mv3;
			}else {
				return mv1;
			}
			
		}else {
			return mv2;
			
		}
		
	}

}
