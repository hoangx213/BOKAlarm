package de.hx.hungservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button startButton;
	EditText urlText;
	SharedPreferences sharedPref;

	// String myUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		urlText = (EditText) findViewById(R.id.editText1);
		sharedPref = PreferenceManager
				.getDefaultSharedPreferences(MainActivity.this);
		startButton = (Button) findViewById(R.id.button1);
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String url = urlText.getText().toString();
				if (!url.startsWith("http://") && !url.startsWith("https://")) {
					Toast.makeText(MainActivity.this,
							"http:// or https:// required", Toast.LENGTH_LONG)
							.show();
				} else {
					sharedPref.edit().putString("url", url).commit();
					Toast.makeText(MainActivity.this,
							"URL saved", Toast.LENGTH_LONG)
							.show();
				}
				

				// Intent intent = new Intent(MainActivity.this, Web.class);
				// intent.putExtra("url", url);
				// startActivity(intent);
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