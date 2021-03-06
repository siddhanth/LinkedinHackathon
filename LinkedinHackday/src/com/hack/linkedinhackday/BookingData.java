package com.hack.linkedinhackday;

import java.io.Serializable;

public class BookingData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String tableId;
	private long bookingTime;
	private int noOfPeople;
	private String phoneNo;
	private String bookingId;
	private String customerId;
	private String resturantId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getResturantId() {
		return resturantId;
	}

	public void setResturantId(String resturantId) {
		this.resturantId = resturantId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public long getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(long bookingTime) {
		this.bookingTime = bookingTime;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
