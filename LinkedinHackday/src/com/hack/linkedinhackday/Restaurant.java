package com.hack.linkedinhackday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Restaurant {

	private String rId;
	private Map<Integer, Integer> tableTypeCount;
	private List<Table> tableList;

	public Restaurant() {
		tableTypeCount = new HashMap<Integer, Integer>();
	}

	public String getRestaurantId() {
		return rId;
	}

	public void setRestaurantId(String restaurantId) {
		this.rId = restaurantId;
	}

	public Map<Integer, Integer> getTableTypeCount() {
		return tableTypeCount;
	}

	public void setTableTypeCount(Map<Integer, Integer> tableTypeCount) {
		this.tableTypeCount = tableTypeCount;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(2, 2);
		Gson gs = new Gson();
		System.out.println(gs.toJson(map));
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}
}