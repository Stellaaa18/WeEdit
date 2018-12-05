package com.imooc.demo.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.demo.dao.WeEdit;
import com.imooc.demo.entity.GroupMember;
import com.imooc.demo.entity.UserCondition;
import com.imooc.demo.entity.VoteChoice;
import com.imooc.demo.entity.VoteComm;
import com.imooc.demo.entity.VoteInfo;
import com.imooc.demo.service.WeEditService;
import com.imooc.demo.tools.*;


@Service
public class ServiceImpl implements WeEditService {
	@Autowired
	private WeEdit weEdit;


	@Override
	public VoteInfo getVoteInfoById(int voteInfoId) {
		return weEdit.queryVoteInfoById(voteInfoId);
	}

	

	@Transactional
	@Override
	public boolean deleteVoteInfo(int voteInfoId) {
		weEdit.deleteVoteInfo(voteInfoId);
		return true;
		
	}

	@Override
	public boolean addVoteInfo(String userID,String deadLine,int isFaceless,int voteAttri,int groupID) {
	
		//weEdit.queryVoteInfoById(voteID);
		String curTime = tool.getTime();
		weEdit.insertVoteInfo(userID, curTime, deadLine, isFaceless, voteAttri, groupID);
		return true;
	}

	
	@Override
	public boolean insertChoice(int voteID,String choice,int num) {
		VoteChoice voteChoice = new VoteChoice();
		voteChoice.setChoice(choice);
		voteChoice.setChoiceNumber(num);
		voteChoice.setVoteID(voteID);
		voteChoice.setChoiceCount(0);
		weEdit.insertChoice(voteChoice);
		return true;
	}
	@Transactional
	@Override
	public boolean deadLineJudge(int voteID) {
		VoteInfo temp = getVoteInfoById(voteID);
		
		String curTime = tool.getTime();
		String deadLine = temp.getDeadLine();
		if(curTime.compareTo(deadLine)>=0) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addCount(int voteID,int num) {
		int count = weEdit.queryCountByID(voteID, num).getChoiceCount() + 1;
		weEdit.updateCount(count, voteID, num);
		return true;
	}
	
	
	@Override
	public boolean voteJudge(int voteID,String userID,int num) {
		int voteAttri = getVoteInfoById(voteID).getVoteAttri();
		if(voteAttri==1) {
			UserCondition temp = weEdit.queryConditionBy2ID(voteID,userID);
			if(temp!=null) {
				return false;
			}
		}
		else if(voteAttri==0) {
			UserCondition temp = weEdit.queryConditionBy3ID(voteID, userID, num);
			if(temp!=null) {
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean addUserCondition(int voteID,String userID,int choiceNumber) {
		UserCondition userCondition = new UserCondition();
		String voteTime = tool.getTime();
		userCondition.setChoiceNumber(choiceNumber);
		userCondition.setUserID(userID);
		userCondition.setVoteID(voteID);
		userCondition.setVoteTime(voteTime);
		weEdit.insertUserCondition(userCondition);
		return true;
		}



	@Override
	public boolean addComm(int voteID, String userID, String comm) {
		
		VoteComm voteComm = new VoteComm();
		voteComm.setUserID(userID);
		voteComm.setVoteID(voteID);
		voteComm.setComment(comm);
		weEdit.insertVoteComm(voteComm);
		return true;
	}



	@Override
	public boolean addGroup() {
		String curTime = tool.getTime();
		weEdit.insertGroup(curTime, 0);
		return true;
	}



	@Override
	public boolean addMember(int groupID, String userID, int level) {
		String curTime = tool.getTime();
		weEdit.insertMember(groupID, userID, curTime, level);
		return true;
	}



	@Override
	public List<GroupMember> getGroupByUserID(String userID) {
		return weEdit.queryGroupByUserID(userID);
	}


	@Override
	public List<VoteInfo> getVoteInfoByGroupID(int groupID) {
		return weEdit.queryVoteInfoByGroupID(groupID);
	}



	@Override
	public boolean removeGroup(int groupID) {
		weEdit.deleteGroup(groupID);
		return true;
	}



	@Override
	public boolean removeMember(int groupID, String userID) {
		weEdit.deleteMember(groupID, userID);
		return true;
	}



	@Override
	public int getGroupSize(int groupID) {
		
		return weEdit.queryGroupSize(groupID);
	}



	@Override
	public boolean updateGroupSize(int size, int groupID) {
		weEdit.updateGroupSize(size, groupID);
		return true;
	}

	
	

}
