package com.hack.linkedinhackday;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

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
import com.google.gson.Gson;

public class MapsActivity extends FragmentActivity implements
		OnInfoWindowClickListener {

	LocationManager locationManager;
	Resources res;
	GoogleMap map;
	Context context;
	String time;
	String numberOfPeople;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		context = this;
		res = this.getResources();
		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		if (getIntent().getExtras().getString("fromScreen")
				.equals("notification")) {
			AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
			alertBuilder
					.setMessage(getIntent().getExtras().getString("message"))
					.setTitle(getIntent().getExtras().getString("header"))
					.setNeutralButton("Ok", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			alertBuilder.show();
		}

		/*
		 * String resturantId = "R1"; time =
		 * getIntent().getExtras().getString("time"); String[] timeSplit =
		 * time.split(":"); Date d = new Date();
		 * d.setHours(Integer.parseInt(timeSplit[0]));
		 * d.setMinutes(Integer.parseInt(timeSplit[1]));
		 * System.out.println("tiem in mili is " + d.getTime()); long timeToSend
		 * = d.getTime(); numberOfPeople =
		 * getIntent().getExtras().getString("numberOfPeople");
		 * 
		 * BookingData bookingData = new BookingData();
		 * bookingData.setBookingId(null); bookingData.setName("Harman");
		 * bookingData.setBookingTime(timeToSend);
		 * bookingData.setCustomerId(HackDayApp.customerID);
		 * bookingData.setNoOfPeople(Integer.parseInt(numberOfPeople));
		 * bookingData.setPhoneNo("9876543210");
		 * bookingData.setResturantId(resturantId);
		 * bookingData.setTableId(null);
		 * 
		 * ArrayList<String> rId = new ArrayList<String>(); rId.add("R1");
		 * rId.add("R2"); rId.add("R3"); rId.add("R4"); rId.add("R5");
		 * rId.add("R6"); rId.add("R7"); rId.add("R8"); rId.add("R9");
		 * rId.add("R10");
		 * 
		 * 
		 * Gson gson = new Gson(); String json = gson.toJson(bookingData);
		 * String restId = gson.toJson(rId); System.out.println("json data is "
		 * + json);
		 * 
		 * String URL =
		 * "http://inhackday.herokuapp.com/rest?action=getData&data=" + json +
		 * "&rId=" + restId; try { String x = new
		 * AsyncNetwork().execute(URL).get();
		 * System.out.println("response x is " + x); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		else {
			numberOfPeople = getIntent().getExtras().getString("numberOfPeople");
			time = getIntent().getExtras().getString("time");
		}
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
		place.setName("Little Italy");
		place.setStatus("Free");
		result.add(place);

		place = new Place();
		place.setId("2");
		place.setLatitude(12.972545);
		place.setLongitude(77.631755);
		place.setName("Barbeque Nation");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("3");
		place.setLatitude(12.967276);
		place.setLongitude(77.633643);
		place.setName("California Kitchen");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("4");
		place.setLatitude(12.965770);
		place.setLongitude(77.640510);
		place.setName("Copper Chimney");
		place.setStatus("Free");
		result.add(place);

		place = new Place();
		place.setId("5");
		place.setLatitude(12.969283);
		place.setLongitude(77.646089);
		place.setName("Pink Berry");
		place.setStatus("Free");
		result.add(place);

		place = new Place();
		place.setId("6");
		place.setLatitude(12.967610);
		place.setLongitude(77.649779);
		place.setName("China Pearl");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("7");
		place.setLatitude(12.974804);
		place.setLongitude(77.650981);
		place.setName("Hunan");
		place.setStatus("Full");
		result.add(place);

		place = new Place();
		place.setId("8");
		place.setLatitude(12.978902);
		place.setLongitude(77.647462);
		place.setName("Punjab Grill");
		place.setStatus("Full");
		result.add(place);

		place = new Place();
		place.setId("9");
		place.setLatitude(12.980909);
		place.setLongitude(77.640767);
		place.setName("Costa Coffee");
		place.setStatus("Filling Fast");
		result.add(place);

		place = new Place();
		place.setId("10");
		place.setLatitude(12.979655);
		place.setLongitude(77.636304);
		place.setName("Toit");
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
		if (marker.getSnippet().equalsIgnoreCase("free")) {
			Intent i = new Intent(context, SeatMapActivity.class);
			i.putExtra("numberOfPeople", numberOfPeople);
			i.putExtra("time", time);
			i.putExtra("fromScreen", "mapScreen");
			i.putExtra("customerId", HackDayApp.customerID);
			startActivity(i);
		} else if (marker.getSnippet().equalsIgnoreCase("full")) {
			Intent i = new Intent(context, TablesFullActivity.class);
			i.putExtra("numberOfPeople", numberOfPeople);
			i.putExtra("fromScreen", "mapScreen");
			i.putExtra("time", time);
			i.putExtra("customerId", HackDayApp.customerID);
			startActivity(i);
		} else if (marker.getSnippet().equalsIgnoreCase("filling fast")) {
			Intent i = new Intent(context, SeatMapActivity.class);
			i.putExtra("numberOfPeople", numberOfPeople);
			i.putExtra("time", time);
			i.putExtra("fromScreen", "mapScreen");
			i.putExtra("customerId", HackDayApp.customerID);
			startActivity(i);
		}
	}
}
