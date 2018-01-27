package pl.lukaszbudyn.wakemyapp.scheduler;

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
	
	@Scheduled(cron="0/20 * * * * ?")
	public void pingEvery29Minutes() {
//		List<Website> websites = websiteRepo.findAll();
//		webPinger.pingAllWebsites(websites);
		Website website = new Website("heroku", "https://spare-part-mgr.herokuapp.com/");
		webPinger.pingOneWebsite(website);
	}
	
}