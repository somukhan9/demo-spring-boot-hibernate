package com.sam.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class RequestBean {

	public int insert;
	public int update;
	public int delete;
	public int find;
	public int projectId;

	public int projectOid;
	public JsonNode data;
	// private JsonArray data;

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RequestBean [insert=" + insert + ", update=" + update + ", delete=" + delete + ", find=" + find
				+ ", projectId=" + projectId + ", projectOid=" + projectOid + ", data=" + data + "]";
	}

	/*
	 * public String getAction() { System.out.println("Hello Action Get");
	 * if(action.trim().equalsIgnoreCase("i")){ this.insert = 1; }else
	 * if(action.trim().equalsIgnoreCase("d")){ this.delete = 1; }else
	 * if(action.trim().equalsIgnoreCase("u")){ this.update = 1; }else
	 * if(action.trim().equalsIgnoreCase("f")){ this.find = 1; } return action; }
	 * 
	 * public void setAction(String action) {
	 * System.out.println("Hello Action Set"); this.action = action;
	 * if(action.trim().equalsIgnoreCase("i")){
	 * System.out.println("Action Insert set"); this.insert = 1; }else
	 * if(action.trim().equalsIgnoreCase("d")){ this.delete = 1; }else
	 * if(action.trim().equalsIgnoreCase("u")){ this.update = 1; }else
	 * if(action.trim().equalsIgnoreCase("f")){ this.find = 1; } }
	 * 
	 * private String action;
	 */
	/*
	 * public int getInsert() { return insert; }
	 * 
	 * public void setInsert(int insert) { this.insert = insert; }
	 * 
	 * public int getUpdate() { return update; }
	 * 
	 * public void setUpdate(int update) { this.update = update; }
	 * 
	 * public int getDelete() { return delete; }
	 * 
	 * public void setDelete(int delete) { this.delete = delete; }
	 * 
	 * public int getFind() { return find; }
	 * 
	 * public void setFind(int find) { this.find = find; }
	 */

	/*
	 * public JsonObject getData() { return data; }
	 * 
	 * public void setData(JsonObject data) { this.data = data; }
	 */

	/*
	 * public RequestBean(String action,JsonObject data){
	 * System.out.println("construnctor"); this.action = action; this.data = data;
	 * 
	 * }
	 * 
	 * 
	 * public RequestBean(int insert, int update, int delete, int find, JsonObject
	 * data) { this.insert = insert; this.update = update; this.delete = delete;
	 * this.find = find; this.data = data; }
	 */

}
