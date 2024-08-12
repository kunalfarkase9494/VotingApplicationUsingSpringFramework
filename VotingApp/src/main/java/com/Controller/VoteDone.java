package com.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.CandidateDao;
import com.Dao.VoteDao;

public class VoteDone extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String uname = request.getParameter("uname");
		String cid = request.getParameter("candidateid");
		
		ModelAndView mv = new ModelAndView("votepage");
		ModelAndView mv1 = new ModelAndView("votepage");
		ModelAndView mv2 = new ModelAndView("votepage");
		
		if(cid!=null){
			
		
			String path = "D:\\Advance java\\Spring-core\\VotingApp\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
			ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
			int ra = cxt.getBean("vDao",VoteDao.class).addVote(uname,Integer.valueOf(cid));
			
			if(ra==1) {
				cxt.getBean("cDao",CandidateDao.class).insertVote(Integer.valueOf(cid));
				mv1.addObject("msg","Your vote is submitted successfully.");
				mv1.addObject("check",uname);
				
				return mv1;
			}
			else {
				mv2.addObject("msg", "Vote was already submitted !!");
				mv2.addObject("check",uname);
				
				return mv2;
			}
		
		}else {
			mv.addObject("msg1","Sorry,there is No Candidate");
			mv.addObject("check",uname);
			return mv;
		}

	}
}