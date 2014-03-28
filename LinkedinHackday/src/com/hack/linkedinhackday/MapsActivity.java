package com.hack.linkedinhackday;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

	LocationManager locationManager;
	Resources res;
	GoogleMap map;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		context = this;
		res = this.getResources();
		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		Parse.initialize(this, "vMFTELLhOo9RDRql9HpV9lKRot5xQTCCD63wkYdQ", 
				"mdz7n8XUjy3u0MSQRnuwmogqXZrw3qJnRwmRxx0g");
		PushService.setDefaultPushCallback(this, MapsActivity.class);
		ParseInstallation.getCurrentInstallation().saveInBackground();

		Context context = getApplicationContext();
		CharSequence text = ParseInstallation.getCurrentInstallation()
				.getObjectId();
		int duration = Toast.LENGTH_LONG;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

		toast = Toast.makeText(context, "Aplication opened", duration);
		toast.show();

		ParseAnalytics.trackAppOpened(getIntent());

		Double lat = 12.971891;
		Double lon = 77.641154;
		LatLng currentLoc = new LatLng(lat, lon);
		map.addMarker(new MarkerOptions().position(currentLoc));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 10));
		map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

		ArrayList<Place> result = new ArrayList<Place>();
		if (result == null || result.isEmpty()) {
		} else {
			for (int i = 0; i < result.size(); i++) {
				map.addMarker(new MarkerOptions()
						.position(
								new LatLng(result.get(i).getLatitude(), result
										.get(i).getLongitude())).flat(true)
						.title(result.get(i).getName()));

				System.out.println("********** result is******"
						+ result.get(i).getName());

			}
		}

	}

	public static void main(String[] args) {
		
	}
}
