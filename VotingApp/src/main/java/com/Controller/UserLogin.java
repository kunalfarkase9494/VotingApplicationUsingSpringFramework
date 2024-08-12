package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.CandidateDao;
import com.Dao.UserDao;
import com.Model.Candidate;
import com.Model.User;

public class UserLogin extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		ModelAndView mv1 = new ModelAndView("votepage","check",uname);
		ModelAndView mv2 = new ModelAndView("userlogin","msg","Invalid username or password");
		
		String path = "D:\\Advance java\\Spring-core\\VotingApp\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		List<Candidate> cl = cxt.getBean("cDao",CandidateDao.class).readAll();
		
		int ra = cxt.getBean("uDao",UserDao.class).checkUser(uname, upass);
		if(ra==1) {
			request.getSession().setAttribute("list", cl);
			return mv1;
		}else {
			return mv2;
		}
	}
	
}
