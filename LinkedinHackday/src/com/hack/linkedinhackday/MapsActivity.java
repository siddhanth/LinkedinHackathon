package com.hack.linkedinhackday;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class MapsActivity extends FragmentActivity implements
		OnInfoWindowClickListener {

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
		BitmapDescriptor bd = BitmapDescriptorFactory
				.fromResource(R.drawable.cross);
		map.addMarker(new MarkerOptions().position(currentLoc).icon(bd));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 14));
		map.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
		CircleOptions circle = new CircleOptions();
		circle.center(currentLoc).fillColor(Color.parseColor("#4000CDCD"))
				.radius(2000).strokeColor(Color.parseColor("#00000000"));
		map.addCircle(circle);

		List<Place> result = new ArrayList<Place>();
		Place place = new Place();
		place.setId("1");
		place.setLatitude(12.971339);
		place.setLongitude(77.638289);
		place.setName("ABC");
		place.setStatus("Free");
		result.add(place);

		place = new Place();
		place.setId("2");
		place.setLatitude(12.972545);
		place.setLongitude(77.631755);
		place.setName("DEF");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("3");
		place.setLatitude(12.967276);
		place.setLongitude(77.633643);
		place.setName("GHI");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("4");
		place.setLatitude(12.965770);
		place.setLongitude(77.640510);
		place.setName("JKL");
		place.setStatus("Free");
		result.add(place);

		place = new Place();
		place.setId("5");
		place.setLatitude(12.969283);
		place.setLongitude(77.646089);
		place.setName("MNO");
		place.setStatus("Free");
		result.add(place);

		place = new Place();
		place.setId("6");
		place.setLatitude(12.967610);
		place.setLongitude(77.649779);
		place.setName("PQR");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("7");
		place.setLatitude(12.974804);
		place.setLongitude(77.650981);
		place.setName("STU");
		place.setStatus("Full");
		result.add(place);

		place = new Place();
		place.setId("8");
		place.setLatitude(12.978902);
		place.setLongitude(77.647462);
		place.setName("VWX");
		place.setStatus("Full");
		result.add(place);

		place = new Place();
		place.setId("9");
		place.setLatitude(12.980909);
		place.setLongitude(77.640767);
		place.setName("YZA");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("10");
		place.setLatitude(12.979655);
		place.setLongitude(77.636304);
		place.setName("BCD");
		place.setStatus("Free");
		result.add(place);

		if (result == null || result.isEmpty()) {
		} else {
			for (int i = 0; i < result.size(); i++) {
				BitmapDescriptor bdresturant = null;
				if (result.get(i).getStatus().equalsIgnoreCase("free")) {
					bdresturant = BitmapDescriptorFactory
							.fromResource(R.drawable.free);
				} else if (result.get(i).getStatus().equalsIgnoreCase("full")) {
					bdresturant = BitmapDescriptorFactory
							.fromResource(R.drawable.full);
				} else if (result.get(i).getStatus()
						.equalsIgnoreCase("Filling Fast")) {
					bdresturant = BitmapDescriptorFactory
							.fromResource(R.drawable.filling_fast);
				}
				map.addMarker(new MarkerOptions()
						.position(
								new LatLng(result.get(i).getLatitude(), result
										.get(i).getLongitude()))
						.title(result.get(i).getName())
						.snippet(result.get(i).getStatus()).icon(bdresturant));

			}
		}

		map.setOnInfoWindowClickListener(this);

	}

	public static void main(String[] args) {

	}

	@Override
	public void onInfoWindowClick(Marker marker) {
		if(marker.getSnippet().equalsIgnoreCase("free")){
			Intent i = new Intent(context, SeatMapActivity.class);
			startActivity(i);
		} else if(marker.getSnippet().equalsIgnoreCase("full")){
			Intent i = new Intent(context, TablesFullActivity.class);
			startActivity(i);
		} else if(marker.getSnippet().equalsIgnoreCase("filling fast")){
			Intent i = new Intent(context, SeatMapActivity.class);
			startActivity(i);
		}
	}
}
