package com.example.chatapp;

import java.net.MalformedURLException;

import org.json.JSONObject;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;


public class MainActivity extends Activity {

	SocketIO socket;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			socket = new SocketIO("http://192.168.178.39:3000/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		socket.connect(new IOCallback() {
			
			@Override
		    public void on(String event, IOAcknowledge ack, Object... args) {
		        if ("chat".equals(event) && args.length > 0) {
		            Toast.makeText(MainActivity.this, args[0].toString(), Toast.LENGTH_LONG).show();
		        }
		    }
			
			@Override
			public void onMessage(JSONObject arg0, IOAcknowledge arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onMessage(String arg0, IOAcknowledge arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(SocketIOException arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDisconnect() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onConnect() {
				// TODO Auto-generated method stub
				
			}
		});
		socket.emit("chat", "hello world");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
