package com.Model;


public class Candidate {
	int cid;
	String name;
	String email;
	String cparty;
	int votes;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCparty() {
		return cparty;
	}

	public void setCparty(String cparty) {
		this.cparty = cparty;
	}
	
	
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	@Override
	public String toString() {
		return "Candidate [cid=" + cid + ", name=" + name + ", email=" + email + ", cparty=" + cparty + ", votes="
				+ votes + "]";
	}
	
	
}
