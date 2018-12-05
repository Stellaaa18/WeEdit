package com.imooc.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo.dao.WeEdit;
import com.imooc.demo.entity.GroupMember;
import com.imooc.demo.entity.VoteInfo;
import com.imooc.demo.service.WeEditService;

@RestController
@RequestMapping("/superadmin")
public class WeEditController {
	@Autowired
	private WeEditService weEditService;
	private WeEdit weEdit;

	//投票操作接口
	@RequestMapping(value = "/vote", method = RequestMethod.GET)
	private String vote(int voteID,String userID, int num) {
		if(!weEditService.deadLineJudge(voteID)){
			return "你来晚了小老弟";
			}
		if(!weEditService.voteJudge(voteID,userID,num)) {
			return "你已经投过了小老弟";
		}
		weEditService.addUserCondition(voteID, userID, num);
		weEditService.addCount(voteID,num);
		return "success";
		
	}
	
	//发布投票接口
	@RequestMapping(value = "/launchVote", method = RequestMethod.GET)
	private String launchVote(String userID,String deadLine,int isFaceless,int voteAttri,int groupID) {
		
//		if(weEditService.getVoteInfoById(voteID)!=null) {
//			return "重复发布投票";
//		}
		
		weEditService.addVoteInfo(userID, deadLine, isFaceless, voteAttri,groupID);
		return "发布投票成功";
	}
	
	//添加选项接口
	@RequestMapping(value = "/addChoice", method = RequestMethod.GET)
	private String addChoice(int voteID,String choice,int num) {
		
		weEditService.insertChoice(voteID, choice, num);
		return "添加选项成功";
	}
	
	//删除投票接口
	@RequestMapping(value = "/deleteVote", method = RequestMethod.GET)
	private String deleteVote(int voteID) {
		
		weEditService.deleteVoteInfo(voteID);
		return "删除投票成功";
	}
	
	//投票评论接口
	@RequestMapping(value = "/voteComm", method = RequestMethod.GET)
	private String voteComm(int voteID,String userID,String comm) {
		weEditService.addComm(voteID, userID, comm);
		return "投票评论成功";
	}
	
	//创建分组接口
	@RequestMapping(value = "/addGroup", method = RequestMethod.GET)
	private String addGroup() {
		weEditService.addGroup();
		return "创建分组成功";
	
	}
	//添加人员接口
	@RequestMapping(value = "/addMember", method = RequestMethod.GET)
	private String addMember(int groupID,String userID,int level) {
		weEditService.addMember(groupID, userID, level);
		int size = weEditService.getGroupSize(groupID) + 1;
		weEditService.updateGroupSize(size, groupID);
		return "当前组内人数："+size;
	}
	//获取用户所加入组的接口
	@RequestMapping(value = "/getGroupByUserID", method = RequestMethod.GET)
	private HashMap getGroupByUserID(String userID) {
		HashMap modelMap = new HashMap<String, Object>();
		List<GroupMember> list= weEditService.getGroupByUserID(userID);
		modelMap.put("GroupInfoByUserID", list);
		return modelMap;
	}
	//获取组内任务接口
	@RequestMapping(value = "/getVoteInfoByGroupID", method = RequestMethod.GET)
	private HashMap getVoteInfoByGroupID(int groupID) {
		HashMap modelMap = new HashMap<String, Object>();
		List<VoteInfo> list= weEditService.getVoteInfoByGroupID(groupID);
		modelMap.put("VoteInfoByGroupID", list);
		return modelMap;
	}
	//删除分组
	@RequestMapping(value = "/removeGroup", method = RequestMethod.GET)
	private String removeGroup(int groupID) {
		weEditService.removeGroup(groupID);
		return "删除分组成功";
	}
	
	//移除组员
	@RequestMapping(value = "/removeMember", method = RequestMethod.GET)
	private String removeMember(int groupID,String userID) {
		weEditService.removeMember(groupID, userID);
		int size = weEditService.getGroupSize(groupID) - 1;
		weEditService.updateGroupSize(size, groupID);
		return "当前组内人数："+size;
	}
	
}
//	/**
//	 * 通过区域Id获取区域信息
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/getvoteInfobyid", method = RequestMethod.GET)
//	private Map<String, Object> getint voteIDById(Integer voteInfoId) {
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		// 获取区域信息
//		int voteID voteInfo = voteInfoService.getint voteIDById(voteInfoId);
//		modelMap.put("voteInfo", voteInfo);
//		return modelMap;
//	}
//
//	/**
//	 * 添加区域信息
//	 * 
//	 * @param voteInfoStr
//	 * @param request
//	 * @return
//	 * @throws IOException
//	 * @throws JsonMappingException
//	 * @throws JsonParseException
//	 */
//	@RequestMapping(value = "/addvoteInfo", method = RequestMethod.POST)
//	private Map<String, Object> addint voteID(@RequestBody int voteID voteInfo)
//			throws JsonParseException, JsonMappingException, IOException {
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		// 添加区域信息
//		modelMap.put("success", voteInfoService.addint voteID(voteInfo));
//		return modelMap;
//	}
//
//	/**
//	 * 修改区域信息，主要修改名字
//	 * 
//	 * @param voteInfoStr
//	 * @param request
//	 * @return
//	 * @throws IOException
//	 * @throws JsonMappingException
//	 * @throws JsonParseException
//	 */
//	@RequestMapping(value = "/modifyvoteInfo", method = RequestMethod.POST)
//	private Map<String, Object> modifyint voteID(@RequestBody int voteID voteInfo)
//			throws JsonParseException, JsonMappingException, IOException {
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		// 修改区域信息
//		modelMap.put("success", voteInfoService.modifyint voteID(voteInfo));
//		return modelMap;
//	}
//
//	@RequestMapping(value = "/removevoteInfo", method = RequestMethod.GET)
//	private Map<String, Object> removeint voteID(Integer voteInfoId) {
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		// 修改区域信息
//		modelMap.put("success", voteInfoService.deleteint voteID(voteInfoId));
//		return modelMap;
//	}
//
////}
