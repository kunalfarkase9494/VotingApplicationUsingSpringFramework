package com.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Model.User;

public class UserDao {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	int ra=0;
	public int addUser(String uname,String upass,int age) {
		try {
			ra =jt.update("insert into userdata values(?,?,?)",uname,upass,age);
		} catch (Exception e) {
			ra=0;
		}finally {
			return ra;
		}
		
	}
	public int checkUser(String uname,String upass) {
		List<User> l =  jt.query("select * from userdata", new UserRowMapper());
		for(User u:l) {
			if(uname.equals(u.getUser()) && upass.equals(u.getPass())) {
				ra = 1;
				break;
			}else {
				ra = 0;
			}
		}
		return ra;
	}
	

}
