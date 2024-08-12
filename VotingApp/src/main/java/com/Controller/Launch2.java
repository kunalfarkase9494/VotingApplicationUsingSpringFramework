package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.CandidateDao;

public class Launch2 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String cid = request.getParameter("cid");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("cemail");
		String pName = request.getParameter("pname");
		String acheck = request.getParameter("acheck");
		
		ModelAndView mv = new ModelAndView();
		
		
		
		String path = "D:\\Advance java\\Spring-core\\VotingApp\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		
		CandidateDao cDao = cxt.getBean("cDao",CandidateDao.class);
		int ra = cDao.addCandidate(Integer.valueOf(cid), fullname, email, pName);
		if(ra==1) {
			mv.addObject("acheck",acheck);
			mv.setViewName("adminhome");
			mv.addObject("msg","Added Candidate Successfully ...");
		}else {
			mv.setViewName("adminhome");
			mv.addObject("acheck",acheck);
			mv.addObject("msg", "Failed");
		}
		return mv;
	}
	
}
