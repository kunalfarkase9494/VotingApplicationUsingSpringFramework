package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.CandidateDao;
import com.Model.Candidate;

public class Launch4 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String aname = request.getParameter("aname");
		
		ModelAndView mv = new ModelAndView();
		
		String path = "D:\\Advance java\\Spring-core\\VotingApp\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		List<Candidate>  l =  cxt.getBean("cDao",CandidateDao.class).readAll();
		
		request.getSession().setAttribute("cl", l);
		mv.setViewName("adminhome");
		mv.addObject("acheck", aname);
		return mv;
	}
	
}
