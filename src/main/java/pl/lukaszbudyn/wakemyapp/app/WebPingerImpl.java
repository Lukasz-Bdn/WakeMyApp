package pl.lukaszbudyn.wakemyapp.app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lukaszbudyn.wakemyapp.entity.Website;
import pl.lukaszbudyn.wakemyapp.repository.WebsiteRepository;

@Component
public class WebPingerImpl implements WebPinger {
	@Autowired
	WebsiteRepository websiteRepo;
	 
	@Override
	public void pingAllWebsites(List<Website> websites) {
		for (Website website : websites) {
			pingOneWebsiteAndUpdateStatus(website);
		}
	}

	public void pingOneWebsiteAndUpdateStatus(Website website) {
		try {
			URL siteUrl = new URL(website.getStringUrl());
			HttpURLConnection connection = (HttpURLConnection) siteUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            String pingStatus = connection.getResponseCode() + " (message: " +connection.getResponseMessage() + ")";
            website.setLastPingStatus(pingStatus);
            website.setLastPingDate(Calendar.getInstance().getTime());
            websiteRepo.save(website);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}