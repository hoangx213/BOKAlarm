package de.hx.bokalarm;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BOKAlarmService extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent myIntent = new Intent(context, MeldungActivity.class)
				.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		myIntent.putExtra("Meldung", intent.getStringExtra("Meldung"));
		myIntent.putExtra("Detail", intent.getStringExtra("Detail"));
		context.startActivity(myIntent);
	}

}
