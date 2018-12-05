package com.imooc.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imooc.demo.entity.GroupMember;
import com.imooc.demo.entity.VoteChoice;
import com.imooc.demo.entity.VoteInfo;
import com.imooc.demo.entity.VoteInfo;
@Service
public interface WeEditService {


	VoteInfo getVoteInfoById(int voteInfoId);

	boolean addVoteInfo(String userID,String deadLine,int isFaceless,int voteAttri,int groupID);
	
	boolean addCount(int voteID,int num);
	
	boolean deleteVoteInfo(int voteID);
	
	boolean insertChoice(int voteID,String choice,int num);
	
	boolean deadLineJudge(int voteID);
	
	boolean voteJudge(int voteID,String userID,int num);
	
	boolean addUserCondition(int voteID,String userID,int choiceNumber);
	
	boolean addComm(int voteID,String userID,String comm);
	
	boolean addGroup();
	
	boolean addMember(int groupID,String userID,int level);
	
	List<GroupMember> getGroupByUserID(String userID);
	
	List<VoteInfo> getVoteInfoByGroupID(int groupID);
	
	boolean removeGroup(int groupID);
	
	boolean removeMember(int groupID,String userID);
	
	int getGroupSize(int groupID);
	
	boolean updateGroupSize(int size,int groupID);
	
}
