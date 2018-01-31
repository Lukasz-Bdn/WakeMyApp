package pl.lukaszbudyn.wakemyapp.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pl.lukaszbudyn.wakemyapp.app.WebPinger;
import pl.lukaszbudyn.wakemyapp.entity.Website;
import pl.lukaszbudyn.wakemyapp.repository.WebsiteRepository;

@Component
public class WebPingerScheduler {

	@Autowired
	WebPinger webPinger;
	@Autowired
	WebsiteRepository websiteRepo;
	
	@Scheduled(cron="0 0/20 * * * ?")
	public void pingEvery29Minutes() {
		List<Website> websites = getWebsitesToPing();
		webPinger.pingAllWebsites(websites);
	}
	
	private List<Website> getWebsitesToPing() {
		String currentDay = getCurrentDay();
		int currentHour = getCurrentHour();
		List<Website> websites = websiteRepo.findWebsitesToPingNow(currentDay, currentHour);
		return websites;
	}

	public String getCurrentDay() {
		Calendar rightNow = Calendar.getInstance();
		Date date = rightNow.getTime();
		String currentDay = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
		return currentDay;
	}
	
	public int getCurrentHour() {
		Calendar rightNow = Calendar.getInstance();
		int hourNow = rightNow.get(Calendar.HOUR_OF_DAY);
		return hourNow;
	}
}