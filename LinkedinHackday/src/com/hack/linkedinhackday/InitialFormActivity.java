package com.hack.linkedinhackday;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class InitialFormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial_form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.initial_form, menu);
		return true;
	}

}
