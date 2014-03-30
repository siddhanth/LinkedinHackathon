package com.hack.linkedinhackday;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyCustomReceiver extends BroadcastReceiver {
	private static final String TAG = "MyCustomReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		try {
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, "Here in custom handler",
					duration);

			String action = intent.getAction();
			if (action.equals("com.example.updateView")) {
				System.out.println("update view");
			} else if (action.equals("com.example.updateBooking")) {
				System.out.println("update booking");
			} else if (action.equals("com.example.updateMessage")) {
				System.out.println("update message");
			}
			String channel = intent.getExtras().getString("com.parse.Channel");
			JSONObject json = new JSONObject(intent.getExtras().getString(
					"com.parse.Data"));

			Iterator itr = json.keys();

			while (itr.hasNext()) {
				String key = (String) itr.next();
				System.out.println("..." + key + " => " + json.getString(key));
			}
			if(action.equals("com.example.updateView")){
				SeatMapActivity sma = new SeatMapActivity();
				String message = json.getString("message");
				sma.onTableBooked(message);
			}else if(action.equals("com.example.updateBooking")){
				final int NOTIFICATION_ID = 1;
				NotificationManager mNotificationManager;
				NotificationCompat.Builder builder;
				mNotificationManager = (NotificationManager) context
						.getSystemService(Context.NOTIFICATION_SERVICE);
				Bundle extras = new Bundle();
				Intent notificationIntent = new Intent(context, MapsActivity.class);
				notificationIntent.putExtra("message", json.getString("message"));
				notificationIntent.putExtra("header", "Copper Chimney");
				notificationIntent.putExtra("fromScreen", "notification");
				notificationIntent.putExtra("numberOfPeople", "2");
				notificationIntent.putExtra("time", "22:20");

				notificationIntent.putExtra("notification", extras);
				TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
				// Adds the back stack
				//stackBuilder.addParentStack(OffersAcitvity.class);
				// Adds the Intent to the top of the stack
				stackBuilder.addNextIntent(notificationIntent);
				// Gets a PendingIntent containing the entire back stack
				PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
						PendingIntent.FLAG_UPDATE_CURRENT);

				long[] vibratePattern = { 0, 500, 1000 };
				Uri notificationSound = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
				NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
						context)
						.setSmallIcon(R.drawable.food_icon)
						.setContentTitle("Copper Chimney")
						.setAutoCancel(true)
						.setStyle(
								new NotificationCompat.BigTextStyle().bigText(json.getString("message")))
						.setContentText(json.getString("message"))
						.setVibrate(vibratePattern).setSound(notificationSound);

				mBuilder.setContentIntent(resultPendingIntent);
				mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());				
			}
		} catch (JSONException e) {
		}
	}
}