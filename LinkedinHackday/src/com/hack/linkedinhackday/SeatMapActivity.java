package com.hack.linkedinhackday;

import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.CursorJoiner.Result;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

public class SeatMapActivity extends Activity implements OnClickListener,
		ResponseInterface {

	static ImageButton table1;
	static ImageButton table2;
	static ImageButton table3;
	static ImageButton table4;
	static ImageButton table5;
	static ImageButton table6;
	static ImageButton table7;
	static ImageButton table8;
	static ImageButton table9;
	static ImageButton table10;
	static ImageButton table11;
	static ImageButton table12;
	static ImageButton table13;
	static ImageButton table14;
	static ImageButton table15;
	static ImageButton table16;
	static ImageButton table17;

	static ProgressDialog progressDialog;

	static Context context;

	String resturantId;
	String time;
	static long timeToSend;
	String numberOfPeople;
	String name;
	String phoneNumber;
	String bookingId;
	String tableID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seatmap);
		context = this;
		
		progressDialog = new ProgressDialog(this);
		progressDialog.setCancelable(false);
		progressDialog.setMessage("Loading resturant layout");
		progressDialog.show();
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				progressDialog.dismiss();
			}
		}, 2500);

		System.out.println("in on create!!!!!");
		System.out.println("from screen "
				+ getIntent().getExtras().getString("fromScreen"));

		table1 = (ImageButton) findViewById(R.id.table_1);
		table2 = (ImageButton) findViewById(R.id.table_2);
		table3 = (ImageButton) findViewById(R.id.table_3);
		table4 = (ImageButton) findViewById(R.id.table_4);
		table5 = (ImageButton) findViewById(R.id.table_5);
		table6 = (ImageButton) findViewById(R.id.table_6);
		table7 = (ImageButton) findViewById(R.id.table_7);
		table8 = (ImageButton) findViewById(R.id.table_8);
		table9 = (ImageButton) findViewById(R.id.table_9);
		table10 = (ImageButton) findViewById(R.id.table_10);
		table11 = (ImageButton) findViewById(R.id.table_11);
		table12 = (ImageButton) findViewById(R.id.table_12);
		table13 = (ImageButton) findViewById(R.id.table_13);
		table14 = (ImageButton) findViewById(R.id.table_14);
		table15 = (ImageButton) findViewById(R.id.table_15);
		table16 = (ImageButton) findViewById(R.id.table_16);
		table17 = (ImageButton) findViewById(R.id.table_17);
		
		numberOfPeople = getIntent().getExtras()
				.getString("numberOfPeople");

		if (isNetworkAvailable()) {
			resturantId = "R1";
			time = getIntent().getExtras().getString("time");
			String[] timeSplit = time.split(":");
			Date d = new Date();
			d.setHours(Integer.parseInt(timeSplit[0]));
			d.setMinutes(Integer.parseInt(timeSplit[1]));
			System.out.println("tiem in mili is " + d.getTime());
			timeToSend = d.getTime();
			numberOfPeople = getIntent().getExtras()
					.getString("numberOfPeople");
			name = "Harman";
			phoneNumber = "9876543210";
			bookingId = null;
			BookingData bookingData = new BookingData();
			bookingData.setBookingId(null);
			bookingData.setName(name);
			bookingData.setBookingTime(timeToSend);
			bookingData.setCustomerId(HackDayApp.customerID);
			bookingData.setNoOfPeople(Integer.parseInt(numberOfPeople));
			bookingData.setPhoneNo(phoneNumber);
			bookingData.setResturantId(resturantId);
			bookingData.setTableId(null);

			Gson gson = new Gson();
			String json = gson.toJson(bookingData);
			System.out.println("json data is " + json);
			Restaurant r1 = new Restaurant();
			String URL = "http://inhackday.herokuapp.com/serve?rId=R1";
			try {
				String x = new AsyncNetwork().execute(URL).get();
				System.out.println("response is " + x);
				r1 = gson.fromJson(x, Restaurant.class);
				System.out.println("using r1" + r1.getRestaurantId());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Toast.makeText(context, "No Network Connection ", Toast.LENGTH_LONG)
					.show();
		}
		
		if (isNetworkAvailable()) {
			resturantId = "R1";
			time = getIntent().getExtras().getString("time");
			String[] timeSplit = time.split(":");
			Date d = new Date();
			d.setHours(Integer.parseInt(timeSplit[0]));
			d.setMinutes(Integer.parseInt(timeSplit[1]));
			System.out.println("tiem in mili is " + d.getTime());
			timeToSend = d.getTime();
			numberOfPeople = getIntent().getExtras()
					.getString("numberOfPeople");
			name = "Harman";
			phoneNumber = "9876543210";
			bookingId = null;
			BookingData bookingData = new BookingData();
			bookingData.setBookingId(null);
			bookingData.setName(name);
			bookingData.setBookingTime(timeToSend);
			bookingData.setCustomerId(HackDayApp.customerID);
			bookingData.setNoOfPeople(Integer.parseInt(numberOfPeople));
			bookingData.setPhoneNo(phoneNumber);
			bookingData.setResturantId(resturantId);
			bookingData.setTableId(null);

			Gson gson = new Gson();
			String json = gson.toJson(bookingData);
			System.out.println("json data is " + json);

			String URL = "http://inhackday.herokuapp.com/cust?action=subscribe&data="
					+ json;
			try {
				new AsyncNetwork().execute(URL).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Toast.makeText(context, "No Network Connection ", Toast.LENGTH_LONG)
					.show();
		}
		
		System.out.println("number of people is " + numberOfPeople);
		
		if(Integer.parseInt(numberOfPeople) >= 9){
			table1.setImageResource(R.drawable.horizontal_2_booked);
			table1.setEnabled(false);
			table2.setImageResource(R.drawable.horizontal_2_booked);
			table2.setEnabled(false);
			table3.setImageResource(R.drawable.horizontal_2_booked);
			table3.setEnabled(false);
			table8.setImageResource(R.drawable.vertical_2_booked);
			table8.setEnabled(false);
			table9.setImageResource(R.drawable.vertical_2_booked);
			table9.setEnabled(false);
			table10.setImageResource(R.drawable.vertical_2_booked);
			table10.setEnabled(false);
			table11.setImageResource(R.drawable.vertical_2_booked);
			table11.setEnabled(false);
			table12.setImageResource(R.drawable.vertical_2_booked);
			table12.setEnabled(false);
			table13.setImageResource(R.drawable.vertical_2_booked);
			table13.setEnabled(false);
			table14.setImageResource(R.drawable.vertical_2_booked);
			table14.setEnabled(false);
			table15.setImageResource(R.drawable.vertical_4_booked);
			table15.setEnabled(false);
			table16.setImageResource(R.drawable.vertical_4_booked);
			table16.setEnabled(false);
			table17.setImageResource(R.drawable.vertical_4_booked);
			table17.setEnabled(false);
			table4.setImageResource(R.drawable.umbrella_booked);
			table4.setEnabled(false);
			table5.setImageResource(R.drawable.umbrella_booked);
			table5.setEnabled(false);
			table6.setImageResource(R.drawable.umbrella_booked);
			table6.setEnabled(false);
			table7.setImageResource(R.drawable.umbrella_booked);
			table7.setEnabled(false);
		}else if(Integer.parseInt(numberOfPeople) >= 5){
			table1.setImageResource(R.drawable.horizontal_2_booked);
			table1.setEnabled(false);
			table2.setImageResource(R.drawable.horizontal_2_booked);
			table2.setEnabled(false);
			table3.setImageResource(R.drawable.horizontal_2_booked);
			table3.setEnabled(false);
			table8.setImageResource(R.drawable.vertical_2_booked);
			table8.setEnabled(false);
			table9.setImageResource(R.drawable.vertical_2_booked);
			table9.setEnabled(false);
			table10.setImageResource(R.drawable.vertical_2_booked);
			table10.setEnabled(false);
			table11.setImageResource(R.drawable.vertical_2_booked);
			table11.setEnabled(false);
			table12.setImageResource(R.drawable.vertical_2_booked);
			table12.setEnabled(false);
			table13.setImageResource(R.drawable.vertical_2_booked);
			table13.setEnabled(false);
			table14.setImageResource(R.drawable.vertical_2_booked);
			table14.setEnabled(false);
			table15.setImageResource(R.drawable.vertical_4_booked);
			table15.setEnabled(false);
			table16.setImageResource(R.drawable.vertical_4_booked);
			table16.setEnabled(false);
			table17.setImageResource(R.drawable.vertical_4_booked);
			table17.setEnabled(false);
		}else if(Integer.parseInt(numberOfPeople) > 3){
			table1.setImageResource(R.drawable.horizontal_2_booked);
			table1.setEnabled(false);
			table2.setImageResource(R.drawable.horizontal_2_booked);
			table2.setEnabled(false);
			table3.setImageResource(R.drawable.horizontal_2_booked);
			table3.setEnabled(false);
			table8.setImageResource(R.drawable.vertical_2_booked);
			table8.setEnabled(false);
			table9.setImageResource(R.drawable.vertical_2_booked);
			table9.setEnabled(false);
			table10.setImageResource(R.drawable.vertical_2_booked);
			table10.setEnabled(false);
			table11.setImageResource(R.drawable.vertical_2_booked);
			table11.setEnabled(false);
			table12.setImageResource(R.drawable.vertical_2_booked);
			table12.setEnabled(false);
			table13.setImageResource(R.drawable.vertical_2_booked);
			table13.setEnabled(false);
			table14.setImageResource(R.drawable.vertical_2_booked);
			table14.setEnabled(false);
		}

		table1.setOnClickListener(this);
		table2.setOnClickListener(this);
		table3.setOnClickListener(this);
		table4.setOnClickListener(this);
		table5.setOnClickListener(this);
		table6.setOnClickListener(this);
		table7.setOnClickListener(this);
		table8.setOnClickListener(this);
		table9.setOnClickListener(this);
		table10.setOnClickListener(this);
		table11.setOnClickListener(this);
		table12.setOnClickListener(this);
		table13.setOnClickListener(this);
		table14.setOnClickListener(this);
		table15.setOnClickListener(this);
		table16.setOnClickListener(this);
		table17.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.table_1:
			table1.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 1");
			showDialog("table1");
			break;
		case R.id.table_2:
			table2.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 2");
			showDialog("table2");
			break;
		case R.id.table_3:
			table3.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 3");
			showDialog("table3");
			break;
		case R.id.table_4:
			table4.setImageResource(R.drawable.umbrella_select);
			System.out.println("selecting table 4");
			showDialog("table4");
			break;
		case R.id.table_5:
			table5.setImageResource(R.drawable.umbrella_select);
			System.out.println("selecting table 5");
			showDialog("table5");
			break;
		case R.id.table_6:
			table6.setImageResource(R.drawable.umbrella_select);
			System.out.println("selecting table 6");
			showDialog("table6");
			break;
		case R.id.table_7:
			table7.setImageResource(R.drawable.umbrella_select);
			System.out.println("selecting table 7");
			showDialog("table7");
			break;
		case R.id.table_8:
			table8.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 8");
			showDialog("table8");
			break;
		case R.id.table_9:
			table9.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 9");
			showDialog("table9");
			break;
		case R.id.table_10:
			table10.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 10");
			showDialog("table10");
			break;
		case R.id.table_11:
			table11.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 11");
			showDialog("table11");
			break;
		case R.id.table_12:
			table12.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 12");
			showDialog("table12");
			break;
		case R.id.table_13:
			table13.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 13");
			showDialog("table13");
			break;
		case R.id.table_14:
			table14.setImageResource(R.drawable.vertical_2_select);
			System.out.println("selecting table 14");
			showDialog("table14");
			break;
		case R.id.table_15:
			table15.setImageResource(R.drawable.vertical_4_select);
			System.out.println("selecting table 15");
			showDialog("table15");
			break;
		case R.id.table_16:
			table16.setImageResource(R.drawable.vertical_4_select);
			System.out.println("selecting table 16");
			showDialog("table16");
			break;
		case R.id.table_17:
			table17.setImageResource(R.drawable.vertical_4_select);
			System.out.println("selecting table 17");
			showDialog("table17");
			break;
		}
	}

	public void showDialog(final String tableId) {
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
		alertBuilder.setCancelable(false)
				.setMessage("Do you want to book the selected table?").create();
		alertBuilder.setNegativeButton("No",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (tableId.equalsIgnoreCase("table1")) {
							table1.setImageResource(R.drawable.horizontal_2);
						} else if (tableId.equalsIgnoreCase("table2")) {
							table2.setImageResource(R.drawable.horizontal_2);
						} else if (tableId.equalsIgnoreCase("table3")) {
							table3.setImageResource(R.drawable.horizontal_2);
						} else if (tableId.equalsIgnoreCase("table4")) {
							table4.setImageResource(R.drawable.umbrella);
						} else if (tableId.equalsIgnoreCase("table5")) {
							table5.setImageResource(R.drawable.umbrella);
						} else if (tableId.equalsIgnoreCase("table6")) {
							table6.setImageResource(R.drawable.umbrella);
						} else if (tableId.equalsIgnoreCase("table7")) {
							table7.setImageResource(R.drawable.umbrella);
						} else if (tableId.equalsIgnoreCase("table8")) {
							table8.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table9")) {
							table9.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table10")) {
							table10.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table11")) {
							table11.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table12")) {
							table12.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table13")) {
							table13.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table14")) {
							table14.setImageResource(R.drawable.vertical_2);
						} else if (tableId.equalsIgnoreCase("table15")) {
							table15.setImageResource(R.drawable.vertical_4);
						} else if (tableId.equalsIgnoreCase("table16")) {
							table16.setImageResource(R.drawable.vertical_4);
						} else if (tableId.equalsIgnoreCase("table17")) {
							table17.setImageResource(R.drawable.vertical_4);
						}
						dialog.dismiss();
					}
				});
		alertBuilder.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						sendTableToBackend(tableId);
						dialog.dismiss();
					}
				});
		alertBuilder.show();
	}

	private void sendTableToBackend(String tableId) {
		if (isNetworkAvailable()) {
			progressDialog = new ProgressDialog(this);
			progressDialog.setCancelable(false);
			progressDialog.setMessage("Booking your table..");
			progressDialog.show();
			BookingData bookingData = new BookingData();
			bookingData.setBookingId(bookingId);
			bookingData.setName(name);
			bookingData.setBookingTime(timeToSend);
			bookingData.setCustomerId(HackDayApp.customerID);
			bookingData.setNoOfPeople(Integer.parseInt(numberOfPeople));
			bookingData.setPhoneNo(phoneNumber);
			bookingData.setResturantId(resturantId);
			bookingData.setTableId(tableId);

			Gson gson = new Gson();
			String json = gson.toJson(bookingData);
			System.out.println("json data is " + json);

			String URL = "http://inhackday.herokuapp.com/cust?action=book&data="
					+ json;
			try {
				new AsyncNetwork().execute(URL).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// System.out.println("in send table to backend  " + URL);
			/*
			 * HttpPost httpPost = new HttpPost(URL); PostRequest postRequest =
			 * new PostRequest(); postRequest.responseObject = this;
			 * postRequest.responseType = new Object();
			 * postRequest.execute(httpPost);
			 */
		} else {
			Toast.makeText(context, "No Network Connection ", Toast.LENGTH_LONG)
					.show();
		}

	}

	public boolean isNetworkAvailable() {
		boolean netWorkAvailable = false;
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			netWorkAvailable = true;
		} else {
			netWorkAvailable = false;
		}
		return netWorkAvailable;
	}

	@Override
	public void didReceiveData(Object data) {
		/*
		 * progressDialog.dismiss(); AlertDialog.Builder alertBuilder = new
		 * AlertDialog.Builder(context);
		 * alertBuilder.setMessage("Your Table has been booked successfully")
		 * .setCancelable(false) .setNeutralButton("Ok", new
		 * DialogInterface.OnClickListener() {
		 * 
		 * @Override public void onClick(DialogInterface dialog, int which) {
		 * dialog.dismiss(); } }); alertBuilder.show();
		 */
	}

	@Override
	public void didReceiveError(String message, int statusCode) {
		progressDialog.dismiss();
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
		alertBuilder.setMessage(message).setCancelable(false)
				.setNeutralButton("Ok", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		alertBuilder.show();

	}

	public void onTableBooked(String message) {
		String[] splitMessage = message.split("_");
		for (int i = 0; i < splitMessage.length; i++) {
			System.out.println("************* " + splitMessage[i]);
		}
		
		if (splitMessage[2].equals(HackDayApp.customerID)) {
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
			tableID = splitMessage[0];
			System.out.println("table id is " + tableID);
			System.out.println("table 1 is " +  table1);
			if (tableID.equalsIgnoreCase(table1.getContentDescription()
					.toString())) {
				table1.setImageResource(R.drawable.horizontal_2_select);
			} else if (tableID.equalsIgnoreCase(table2
					.getContentDescription().toString())) {
				table2.setImageResource(R.drawable.horizontal_2_select);
			} else if (tableID.equalsIgnoreCase(table3
					.getContentDescription().toString())) {
				table3.setImageResource(R.drawable.horizontal_2_select);
			} else if (tableID.equalsIgnoreCase(table4
					.getContentDescription().toString())) {
				table4.setImageResource(R.drawable.umbrella_select);
			} else if (tableID.equalsIgnoreCase(table5
					.getContentDescription().toString())) {
				table5.setImageResource(R.drawable.umbrella_select);
			} else if (tableID.equalsIgnoreCase(table6
					.getContentDescription().toString())) {
				table6.setImageResource(R.drawable.umbrella_select);
			} else if (tableID.equalsIgnoreCase(table7
					.getContentDescription().toString())) {
				table7.setImageResource(R.drawable.umbrella_select);
			} else if (tableID.equalsIgnoreCase(table8
					.getContentDescription().toString())) {
				table8.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table9
					.getContentDescription().toString())) {
				table9.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table10
					.getContentDescription().toString())) {
				table10.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table11
					.getContentDescription().toString())) {
				table11.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table12
					.getContentDescription().toString())) {
				table12.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table13
					.getContentDescription().toString())) {
				table13.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table14
					.getContentDescription().toString())) {
				table14.setImageResource(R.drawable.vertical_2_select);
			} else if (tableID.equalsIgnoreCase(table15
					.getContentDescription().toString())) {
				table15.setImageResource(R.drawable.vertical_4_select);
			} else if (tableID.equalsIgnoreCase(table16
					.getContentDescription().toString())) {
				table16.setImageResource(R.drawable.vertical_4_select);
			} else if (tableID.equalsIgnoreCase(table17
					.getContentDescription().toString())) {
				table17.setImageResource(R.drawable.vertical_4_select);
			}
			AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
			alertBuilder.setMessage("Your Table has been booked successfully")
					.setCancelable(false)
					.setNeutralButton("Ok", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			alertBuilder.show();
		} else {
			System.out.println("difference between timing is " + (Math.abs(timeToSend-Long.parseLong(splitMessage[1]))));
			if((Math.abs(timeToSend-Long.parseLong(splitMessage[1]))) <= 1800000){
				tableID = splitMessage[0];
				if (tableID.equalsIgnoreCase(table1.getContentDescription()
						.toString())) {
					table1.setImageResource(R.drawable.horizontal_2_booked);
				} else if (tableID.equalsIgnoreCase(table2
						.getContentDescription().toString())) {
					table2.setImageResource(R.drawable.horizontal_2_booked);
				} else if (tableID.equalsIgnoreCase(table3
						.getContentDescription().toString())) {
					table3.setImageResource(R.drawable.horizontal_2_booked);
				} else if (tableID.equalsIgnoreCase(table4
						.getContentDescription().toString())) {
					table4.setImageResource(R.drawable.umbrella_booked);
				} else if (tableID.equalsIgnoreCase(table5
						.getContentDescription().toString())) {
					table5.setImageResource(R.drawable.umbrella_booked);
				} else if (tableID.equalsIgnoreCase(table6
						.getContentDescription().toString())) {
					table6.setImageResource(R.drawable.umbrella_booked);
				} else if (tableID.equalsIgnoreCase(table7
						.getContentDescription().toString())) {
					table7.setImageResource(R.drawable.umbrella_booked);
				} else if (tableID.equalsIgnoreCase(table8
						.getContentDescription().toString())) {
					table8.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table9
						.getContentDescription().toString())) {
					table9.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table10
						.getContentDescription().toString())) {
					table10.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table11
						.getContentDescription().toString())) {
					table11.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table12
						.getContentDescription().toString())) {
					table12.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table13
						.getContentDescription().toString())) {
					table13.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table14
						.getContentDescription().toString())) {
					table14.setImageResource(R.drawable.vertical_2_booked);
				} else if (tableID.equalsIgnoreCase(table15
						.getContentDescription().toString())) {
					table15.setImageResource(R.drawable.vertical_4_booked);
				} else if (tableID.equalsIgnoreCase(table16
						.getContentDescription().toString())) {
					table16.setImageResource(R.drawable.vertical_4_booked);
				} else if (tableID.equalsIgnoreCase(table17
						.getContentDescription().toString())) {
					table17.setImageResource(R.drawable.vertical_4_booked);
				}
			}
		}

	}

}
