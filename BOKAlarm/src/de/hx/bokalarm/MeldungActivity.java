package de.hx.bokalarm;

import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MeldungActivity extends Activity {

	Ringtone r;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.meldung);

	    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	    
	    TextView meldungTextView = (TextView) findViewById(R.id.meldungTextView);
	    meldungTextView.setText(getIntent().getStringExtra("Meldung"));
	    
	    TextView detailTextView = (TextView) findViewById(R.id.detailTextView);
	    String text =  getIntent().getStringExtra("Detail");
	    detailTextView.setText(getIntent().getStringExtra("Detail"));
	    
	    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
	    r = RingtoneManager.getRingtone(getApplicationContext(), notification);
	    r.play();
	    
	    Button stopButtonView = (Button)findViewById(R.id.stopButton1);
	    stopButtonView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				r.stop();
			}
		});
	}

}
