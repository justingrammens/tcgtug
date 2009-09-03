/**
 * Created by Justin Grammens
 * Copyright Localtone Interactive. All Rights Reserved.
 */

package com.localtone.tcgtug;

import com.localtone.tcgtug.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TCGTUG extends TabActivity {

	TabHost mTabHost;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		RssFeedWebsite.loadFeedList();
		RssFeedGoogleGroup.loadFeedList();
		
		setContentView(R.layout.main);

		Intent websiteItent = new Intent(this, Website.class);
		websiteItent.putExtra("link", "http://tc-gtug.org/");
		
		Intent websiteRssFeedList = new Intent(this, RssFeedWebsiteList.class);
		Intent googleGroupRssFeedList = new Intent(this, RssFeedGoogleGroupList.class);
		
		mTabHost = getTabHost();
		
		mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator(
		"Website").setContent(websiteItent));
		
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("Website RSS")
				.setContent(websiteRssFeedList));
		
		mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("Google Group")
				.setContent(googleGroupRssFeedList));
		
		mTabHost.setCurrentTab(0);
	}
	
}