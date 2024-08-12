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

public class DeleteCandidate extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String aname = request.getParameter("aname");
		String cid = request.getParameter("cid");
		
		String path = "D:\\Advance java\\Spring-core\\VotingApp\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		cxt.getBean("cDao",CandidateDao.class).deleteCandidate(Integer.valueOf(cid));
		
		List<Candidate>  l =  cxt.getBean("cDao",CandidateDao.class).readAll();
		request.getSession().setAttribute("cl", l);
		
		ModelAndView mv = new ModelAndView("adminhome","acheck",aname);
		return mv;
	}

}
