package pl.lukaszbudyn.wakemyapp.app;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.lukaszbudyn.wakemyapp.entity.Website;

@Component
public interface WebPinger {
	public void pingAllWebsites(List<Website> websites);
	public void pingOneWebsite(Website website);
}