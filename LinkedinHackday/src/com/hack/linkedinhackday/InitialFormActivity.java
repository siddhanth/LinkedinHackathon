package com.hack.linkedinhackday;

import java.util.Calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class InitialFormActivity extends Activity implements
		android.view.View.OnClickListener {

	Context context;
	Button timePicker;
	Button next;
	EditText numberOfPeople;
	String numberPeople;
	String time;
	TimePickerDialog TPD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial_form);

		context = this;

		Parse.initialize(this, "vMFTELLhOo9RDRql9HpV9lKRot5xQTCCD63wkYdQ",
				"mdz7n8XUjy3u0MSQRnuwmogqXZrw3qJnRwmRxx0g");
		PushService.setDefaultPushCallback(this, InitialFormActivity.class);
		ParseInstallation.getCurrentInstallation().saveInBackground();

		CharSequence text = ParseInstallation.getCurrentInstallation()
				.getObjectId();
		int duration = Toast.LENGTH_LONG;
		HackDayApp.customerID = ParseInstallation.getCurrentInstallation().getObjectId();

		System.out.println("customer id is " + HackDayApp.customerID);

		/*Toast toast = Toast.makeText(context, text, duration);
		toast.show();

		toast = Toast.makeText(context, "Aplication opened", duration);
		toast.show();
*/
		ParseAnalytics.trackAppOpened(getIntent());

		numberPeople = null;
		time = null;

		timePicker = (Button) findViewById(R.id.time_picker);
		numberOfPeople = (EditText) findViewById(R.id.edit_no_of_ppl);
		next = (Button) findViewById(R.id.next);

		timePicker.setOnClickListener(this);
		next.setOnClickListener(this);

		numberOfPeople.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				numberPeople = s.toString();
			}
		});

	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			time = hourOfDay + ":" + minute;
			timePicker.setText(time);
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.time_picker:
			TPD = new TimePickerDialog(context, mTimeSetListener,
					19, 30, true);
			TPD.show();
			break;

		case R.id.next:
			if (numberPeople == null || numberPeople.equals("")
					|| numberPeople.equals("0")) {
				Toast.makeText(context, "Please select number of people",
						Toast.LENGTH_LONG).show();
			} else if (time == null || time.equals("")) {
				Toast.makeText(context, "Please select time of booking",
						Toast.LENGTH_LONG).show();
			} else {
				Intent i = new Intent(context, MapsActivity.class);
				i.putExtra("numberOfPeople", numberPeople);
				i.putExtra("time", time);
				i.putExtra("fromScreen", "initialScreen");
				startActivity(i);
			}
		}
	}

}