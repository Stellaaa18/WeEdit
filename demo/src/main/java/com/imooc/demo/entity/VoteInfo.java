package com.imooc.demo.entity;


public class VoteInfo{
	// 主键ID
	private int voteID;
	// 名称
	private String userID;
	// 权重，越大越排前显示
	private int isFaceless;
	// 创建时间
	private String launchTime;
	// 更新时间
	private String deadLine;

	private int voteAttri;

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getIsFaceless() {
		return isFaceless;
	}

	public void setIsFaceless(int isFaceless) {
		this.isFaceless = isFaceless;
	}

	public String getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(String launchTime) {
		this.launchTime = launchTime;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public int getVoteAttri() {
		return voteAttri;
	}

	public void setVoteAttri(int voteAttri) {
		this.voteAttri = voteAttri;
	}

	

}
