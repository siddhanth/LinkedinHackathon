package com.hack.linkedinhackday;

public class DatbaseOrderEntry {

	private String tableId;
	private int tableType;
	private String rId;
	private String customerId;
	private long startTime;
	private long endTime;

	public DatbaseOrderEntry(BookingData bd) {
		this.tableId = bd.getTableId();
		this.tableType = bd.getNoOfPeople();
		this.rId = bd.getResturantId();
		this.customerId = bd.getCustomerId();
		this.startTime = bd.getBookingTime();
		this.endTime = startTime + 3600000;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	public String getRestaurantId() {
		return rId;
	}

	public void setRestaurantId(String restaurantId) {
		this.rId = restaurantId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public long getStart_time() {
		return startTime;
	}

	public void setStart_time(long start_time) {
		this.startTime = start_time;
	}

	public long getEnd_time() {
		return endTime;
	}

	public void setEnd_time(long end_time) {
		this.endTime = end_time;
	}

}