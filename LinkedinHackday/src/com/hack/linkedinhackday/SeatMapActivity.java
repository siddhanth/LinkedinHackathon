package com.hack.linkedinhackday;

import org.apache.http.client.methods.HttpPost;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class SeatMapActivity extends Activity implements OnClickListener,
		ResponseInterface {

	ImageButton table1;
	ImageButton table2;
	ImageButton table3;
	ImageButton table4;
	ImageButton table5;
	ImageButton table6;
	ImageButton table7;
	ImageButton table8;
	ImageButton table9;
	ImageButton table10;
	ImageButton table11;
	ImageButton table12;
	ImageButton table13;
	ImageButton table14;
	ImageButton table15;
	ImageButton table16;
	ImageButton table17;

	ProgressDialog progressDialog;

	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seatmap);
		context = this;
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
			String URL = "http://inhackday.herokuapp.com/cust?action=book&tableId="
					+ tableId;
			System.out.println("in send table to backend  " + URL);
			HttpPost httpPost = new HttpPost(URL);
			PostRequest postRequest = new PostRequest();
			postRequest.responseObject = this;
			postRequest.responseType = new Object();
			postRequest.execute(httpPost);
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
		progressDialog.dismiss();
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

}
