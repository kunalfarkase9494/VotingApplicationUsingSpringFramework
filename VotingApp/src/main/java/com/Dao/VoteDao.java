package com.Dao;


import org.springframework.jdbc.core.JdbcTemplate;


public class VoteDao {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	int ra =0;
	public int addVote(String uname,int cid){
		try {
			ra = jt.update("insert into votetable values(?,?)",uname,cid);
			
		} catch (Exception e) {
			ra=0;
		}finally {
			return ra;
		}
	}
	
	
}
