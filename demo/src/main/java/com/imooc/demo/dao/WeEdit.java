package com.imooc.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.demo.entity.GroupMember;
import com.imooc.demo.entity.UserCondition;
import com.imooc.demo.entity.UserGroup;
import com.imooc.demo.entity.VoteChoice;
import com.imooc.demo.entity.VoteComm;
import com.imooc.demo.entity.VoteInfo;
import com.imooc.demo.entity.VoteInfo;

public interface WeEdit {

	VoteInfo queryVoteInfoById(int voteID);

	int insertVoteInfo(@Param("userID")String userID,@Param("launchTime")String launchTime,@Param("deadLine")String deadLine,@Param("isFaceless")int isFaceless,@Param("voteAttri")int voteAttri,@Param("groupID")int groupID);

	int updateVoteInfo(VoteInfo voteInfo);

	int deleteVoteInfo(int voteID);
	
	int insertChoice(VoteChoice voteChoice);
	
	int insertVoteComm(VoteComm voteComm);
	
	int insertUserCondition(UserCondition userCondition);
	
	UserCondition queryConditionBy2ID(@Param("voteID")int voteID,@Param("userID")String userID);
	
	UserCondition queryConditionBy3ID(@Param("voteID")int voteID,@Param("userID")String userID,@Param("choiceNumber")int choiceNumber);
	
	VoteChoice queryCountByID(@Param("voteID")int voteID,@Param("choiceNumber")int choiceNumber);
	
	int updateCount(@Param("count")int count,@Param("voteID")int voteID,@Param("choiceNumber")int choiceNumber);
	
	int insertGroup(@Param("createTime")String createTime,@Param("size")int size);
	
	int insertMember(@Param("groupID")int groupID,@Param("userID")String userID,@Param("addTime")String addTime,@Param("level")int level);
	
	List<GroupMember> queryGroupByUserID(String userID);
	
	List<VoteInfo> queryVoteInfoByGroupID(int groupID);
	
	int deleteGroup(int groupID);
	
	int deleteMember(@Param("groupID")int groupID,@Param("userID")String userID);
	
	int queryGroupSize(int groupID);
	
	boolean updateGroupSize(@Param("size")int size,@Param("groupID")int groupID);
}
