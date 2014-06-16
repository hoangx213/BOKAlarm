package de.hx.bokalarm;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final static String APP_TAG="BOK";
	Button startAlarmButtonView;
	Button cancelAlarmButtonView;
	BOKAlarmReceiver bokAlarmReceiver = new BOKAlarmReceiver();
	AlarmManager alarmM;
	ArrayList<PendingIntent> pendingIntentList = new ArrayList<PendingIntent>(); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startAlarmButtonView = (Button) findViewById(R.id.startAlarmButton);
		startAlarmButtonView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				bokAlarmReceiver.setAlarm(MainActivity.this);
				alarmM = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
				
				Intent intent = new Intent(MainActivity.this, BOKAlarmService.class);
				intent.putExtra("Meldung", "Bitte Aussehen überprüfen"); 	
				intent.putExtra("Detail", "Arbeitskleidung\nArbeitsschuhe\nIm Servicebereich Haare\nNamenschild\nSmiley");
				PendingIntent alarmIntent0 = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
				PendingIntent alarmIntent1 = PendingIntent.getBroadcast(MainActivity.this, 1, intent, 0);
				pendingIntentList.add(alarmIntent0);
				pendingIntentList.add(alarmIntent1);
				
				intent.putExtra("Meldung", "Bitte WC kontrollieren");
				intent.putExtra("Detail", "Geruch\nHandtücher\nDesinfektionsmitteln\nToilettenpapier\nBoden\nWaschbecken");
				PendingIntent alarmIntent2 = PendingIntent.getBroadcast(MainActivity.this, 2, intent, 0);
				PendingIntent alarmIntent3 = PendingIntent.getBroadcast(MainActivity.this, 3, intent, 0);
				PendingIntent alarmIntent4 = PendingIntent.getBroadcast(MainActivity.this, 4, intent, 0);
				PendingIntent alarmIntent5 = PendingIntent.getBroadcast(MainActivity.this, 5, intent, 0);
				PendingIntent alarmIntent6 = PendingIntent.getBroadcast(MainActivity.this, 6, intent, 0);
				PendingIntent alarmIntent15 = PendingIntent.getBroadcast(MainActivity.this, 15, intent, 0);
				pendingIntentList.add(alarmIntent2);
				pendingIntentList.add(alarmIntent3);
				pendingIntentList.add(alarmIntent4);
				pendingIntentList.add(alarmIntent5);
				pendingIntentList.add(alarmIntent6);
				pendingIntentList.add(alarmIntent15);
				
				intent.putExtra("Meldung", "Bitte Kerzen anzünden");
				intent.putExtra("Detail", "");
				PendingIntent alarmIntent7 = PendingIntent.getBroadcast(MainActivity.this, 7, intent, 0);
				PendingIntent alarmIntent8 = PendingIntent.getBroadcast(MainActivity.this, 8, intent, 0);
				pendingIntentList.add(alarmIntent7);
				pendingIntentList.add(alarmIntent8);
				
				intent.putExtra("Meldung", "Bitte Licht dimmen");
				intent.putExtra("Detail", "");
				PendingIntent alarmIntent9 = PendingIntent.getBroadcast(MainActivity.this, 9, intent, 0);
				pendingIntentList.add(alarmIntent9);
				
				intent.putExtra("Meldung", "Bitte Musik überprüfen");
				intent.putExtra("Detail", "");
				PendingIntent alarmIntent10 = PendingIntent.getBroadcast(MainActivity.this, 10, intent, 0);
				PendingIntent alarmIntent11 = PendingIntent.getBroadcast(MainActivity.this, 11, intent, 0);
				pendingIntentList.add(alarmIntent10);
				pendingIntentList.add(alarmIntent11);
				
				intent.putExtra("Meldung", "Küche: Gemüse und Fleisch-Bitte Vorbereitung überprüfen");
				intent.putExtra("Detail", "");
				PendingIntent alarmIntent12 = PendingIntent.getBroadcast(MainActivity.this, 12, intent, 0);
				PendingIntent alarmIntent13 = PendingIntent.getBroadcast(MainActivity.this, 13, intent, 0);
				PendingIntent alarmIntent14 = PendingIntent.getBroadcast(MainActivity.this, 14, intent, 0);
				pendingIntentList.add(alarmIntent12);
				pendingIntentList.add(alarmIntent13);
				pendingIntentList.add(alarmIntent14);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				
				calendar.set(Calendar.HOUR_OF_DAY, 11);
				calendar.set(Calendar.MINUTE, 30);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent0);
				
				calendar.set(Calendar.HOUR_OF_DAY, 18);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent1);
				
				calendar.set(Calendar.HOUR_OF_DAY, 13);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent2);
				
				calendar.set(Calendar.HOUR_OF_DAY, 15);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent3);
				
				calendar.set(Calendar.HOUR_OF_DAY, 17);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent4);
				
				calendar.set(Calendar.HOUR_OF_DAY, 19);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent5);
				
				calendar.set(Calendar.HOUR_OF_DAY, 21);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent6);
				
				calendar.set(Calendar.HOUR_OF_DAY, 17);
				calendar.set(Calendar.MINUTE, 03);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent7);
				
				calendar.set(Calendar.HOUR_OF_DAY, 21);
				calendar.set(Calendar.MINUTE, 03);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent8);
				
				calendar.set(Calendar.HOUR_OF_DAY, 17);
				calendar.set(Calendar.MINUTE, 06);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent9);
				
				calendar.set(Calendar.HOUR_OF_DAY, 11);
				calendar.set(Calendar.MINUTE, 15);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent10);
				
				calendar.set(Calendar.HOUR_OF_DAY, 18);
				calendar.set(Calendar.MINUTE, 15);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent11);
				
				calendar.set(Calendar.HOUR_OF_DAY, 16);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent12);
				
				calendar.set(Calendar.HOUR_OF_DAY, 19);
				calendar.set(Calendar.MINUTE, 03);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent13);
				
				calendar.set(Calendar.HOUR_OF_DAY, 22);
				calendar.set(Calendar.MINUTE, 30);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent14);
				
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 00);
				alarmM.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, alarmIntent15);
				
//				startActivity(intent);
			}
		});
		
		cancelAlarmButtonView = (Button)findViewById(R.id.cancelAlarmButton);
		cancelAlarmButtonView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				for(PendingIntent alarmIntent : pendingIntentList){
					alarmM.cancel(alarmIntent);
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
