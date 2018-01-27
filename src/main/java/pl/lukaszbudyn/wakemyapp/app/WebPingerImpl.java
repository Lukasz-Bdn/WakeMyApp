package pl.lukaszbudyn.wakemyapp.app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import pl.lukaszbudyn.wakemyapp.entity.Website;

public class WebPingerImpl implements WebPinger {
 
	@Override
	public void pingAllWebsites(List<Website> websites) {
		for (Website website : websites) {
			pingOneWebsite(website);
		}
	}

	public void pingOneWebsite(Website website) {
		try {
			URL siteUrl = new URL(website.getStringUrl());
			HttpURLConnection connection = (HttpURLConnection) siteUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            connection.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
