package de.hx.hungservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends Activity {

	WebView webView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.web);
//	    getWindow().requestFeature(Window.FEATURE_NO_TITLE);
	    String url = getIntent().getStringExtra("url");
	    webView = (WebView)findViewById(R.id.webview);
	    webView.setWebViewClient(new WebViewClient());
	    webView.setWebChromeClient(new WebChromeClient());
	    webView.getSettings().setJavaScriptEnabled(true);
	    
	    webView.loadUrl(url);
	    // TODO Auto-generated method stub
	}

}
