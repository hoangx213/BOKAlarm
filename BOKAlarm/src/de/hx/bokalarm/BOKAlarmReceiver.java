package de.hx.bokalarm;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class BOKAlarmReceiver extends WakefulBroadcastReceiver {

	AlarmManager alarmM;
	PendingIntent alarmIntent;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent service = new Intent(context, BOKAlarmService.class);
		startWakefulService(context, service);
	}

	public void setAlarm(Context context) {
		alarmM = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, BOKAlarmReceiver.class);
		alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTimeInMillis(System.currentTimeMillis());
		calendar2.set(Calendar.HOUR_OF_DAY, 23);
		calendar2.set(Calendar.MINUTE, 59);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, 10);
		long x = calendar.getTimeInMillis();
		long y = calendar2.getTimeInMillis();
//		alarmM.setInexactRepeating(AlarmManager.RTC_WAKEUP,
//				calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,
//				alarmIntent);
		alarmM.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);

	}

}
