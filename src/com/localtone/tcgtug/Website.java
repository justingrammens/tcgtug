/**
 * Created by Justin Grammens
 * Copyright Localtone Interactive. All Rights Reserved.
 */

package com.localtone.tcgtug;

import com.localtone.tcgtug.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Website extends Activity {

	WebView webView;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.website);

		String link = this.getIntent().getStringExtra("link");
			
		webView = (WebView) findViewById(R.id.web_view);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(link);

	}

}
