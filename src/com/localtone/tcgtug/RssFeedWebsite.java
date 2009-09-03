/**
 * Created by Justin Grammens
 * Copyright Localtone Interactive. All Rights Reserved.
 */

package com.localtone.tcgtug;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RssFeedWebsite {
	
	public static List<RssFeedWebsite> feedItems = new ArrayList<RssFeedWebsite>();
	
	private String title;
	private String link;
	private String pubDate;
	
	public RssFeedWebsite(String title, String link, String pubDate) {
		this.title = title;
		this.link = link;
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getPubDate() {
		return pubDate;
	}
	
	
	public static void loadFeedList() {
		
		String url = "http://www.tc-gtug.org/rss.xml";
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			
			Document doc = builder.parse(new URL(url).openStream());

			NodeList nodes = doc.getElementsByTagName("item");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				NodeList titleNode = element.getElementsByTagName("title");
				Element titleLine = (Element) titleNode.item(0);
				String title = titleLine.getFirstChild().getNodeValue();

				NodeList linkNode = element.getElementsByTagName("link");
				Element linkLine = (Element) linkNode.item(0);
				String link = linkLine.getFirstChild().getNodeValue();

				NodeList pubNode = element.getElementsByTagName("pubDate");
				Element pubLine = (Element) pubNode.item(0);
				String pubDate = pubLine.getFirstChild().getNodeValue();
				
				RssFeedWebsite rssFeed = new RssFeedWebsite(title, link, pubDate);
				feedItems.add(rssFeed);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
