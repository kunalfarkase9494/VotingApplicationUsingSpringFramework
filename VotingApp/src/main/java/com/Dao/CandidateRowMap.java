package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Model.Candidate;

public class CandidateRowMap implements RowMapper<Candidate>{

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate cd = new Candidate();
		cd.setCid(rs.getInt("cid"));
		cd.setName(rs.getString("name"));
		cd.setCparty(rs.getString("party"));
		cd.setEmail(rs.getString("email"));
		cd.setVotes(rs.getInt("votes"));
		return cd;
	}
	
	

}
