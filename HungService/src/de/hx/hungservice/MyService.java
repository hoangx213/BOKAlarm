package de.hx.hungservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MyService extends BroadcastReceiver {

	SharedPreferences sharedPref;
	@Override
	public void onReceive(Context context, Intent intent) {
		sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
		String url = sharedPref.getString("url", "");
		Intent myIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(url));
		myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		Intent myIntent = new Intent(context, Web.class);
//		myIntent.putExtra("url", url);
//		myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		context.startActivity(myIntent);
	}

}