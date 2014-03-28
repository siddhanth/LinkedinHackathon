package com.hack.linkedinhackday;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class SeatMapActivity extends Activity implements OnClickListener {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seatmap);
		
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
			break;
		case R.id.table_2:
			table2.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 2");
			break;
		case R.id.table_3:
			table3.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 3");
			break;
		case R.id.table_4:
			table4.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 4");
			break;
		case R.id.table_5:
			table5.setImageResource(R.drawable.horizontal_2);
			System.out.println("selecting table 5");
			break;
		case R.id.table_6:
			table6.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 6");
			break;
		case R.id.table_7:
			table7.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 7");
			break;
		case R.id.table_8:
			table8.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 8");
			break;
		case R.id.table_9:
			table9.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 9");
			break;
		case R.id.table_10:
			table10.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 10");
			break;
		case R.id.table_11:
			table11.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 11");
			break;
		case R.id.table_12:
			table12.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 12");
			break;
		case R.id.table_13:
			table13.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 13");
			break;
		case R.id.table_14:
			table14.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 14");
			break;
		case R.id.table_15:
			table15.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 15");
			break;
		case R.id.table_16:
			table16.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 16");
			break;
		case R.id.table_17:
			table17.setImageResource(R.drawable.horizontal_2_select);
			System.out.println("selecting table 17");
			break;
		}
	}
	
	

}
