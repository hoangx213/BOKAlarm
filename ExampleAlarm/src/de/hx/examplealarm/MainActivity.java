package de.hx.examplealarm;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Toast mToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.one_shot);
		button.setOnClickListener(mOneShotListener);
	}

	private OnClickListener mOneShotListener = new OnClickListener() {
		public void onClick(View v) {

			Intent intent = new Intent(MainActivity.this, MyAlarmReceiver.class);
			PendingIntent sender = PendingIntent.getBroadcast(
					MainActivity.this, 0, intent, 0);

			// We want the alarm to go off 10 seconds from now.
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			calendar.add(Calendar.SECOND, 10);

			// <span id="IL_AD9" class="IL_AD">Schedule</span> the alarm!
			AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);

			// Tell the user about what we did.
			if (mToast != null) {
				mToast.cancel();
			}
			mToast = Toast.makeText(MainActivity.this, "Alarm Started",
					Toast.LENGTH_LONG);
			mToast.show();
		}
	};
}