package com.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Model.Candidate;
import com.Model.User;

public class CandidateDao {
	
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	int ra =0; 
	public int addCandidate(int id,String name,String email,String party) {
		try {
			String sql = "insert into Candidate values(?,?,?,?,0)";
			ra =jt.update(sql,id,name,email,party);
		
		} catch (Exception e) {
			// TODO: handle exception
			ra=0;
		}
		finally {
			return ra;
		}
		
		
	}
	
	public List<Candidate> readAll(){
		String sql = "select * from Candidate";
		return jt.query(sql, new CandidateRowMap());
	}
	
	public void deleteCandidate(int cid) {
		jt.update("delete from candidate where cid=?",cid);
		jt.update("delete from votetable where cid=?",cid);
	}
	
	
	public void insertVote(int cid) {
		List<Candidate> l =  jt.query("select * from Candidate", new CandidateRowMap());
		for(Candidate c:l) {
			if(cid == c.getCid()) {
				int newVote = c.getVotes()+1;
				jt.update("update candidate set votes=? where cid=?",newVote,cid);
				break;
			}
		}
	  
	}
}
