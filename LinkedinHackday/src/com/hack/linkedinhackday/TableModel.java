package com.hack.linkedinhackday;

import java.io.Serializable;
import java.util.ArrayList;

public class TableModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private ArrayList<TableValueModel> tableID;

	public TableModel() {
	}

	public ArrayList<TableValueModel> getTableID() {
		return tableID;
	}

	public void setTableID(ArrayList<TableValueModel> tableID) {
		this.tableID = tableID;
	}
	
	public class TableValueModel {
		private boolean booked;
		
		private String tableID;
		
		public boolean getBooked() {
			return booked;
		}
		public void setBooked(Boolean booked) {
			this.booked = booked;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}