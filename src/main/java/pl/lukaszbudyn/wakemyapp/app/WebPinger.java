package pl.lukaszbudyn.wakemyapp.app;

import java.util.List;

import pl.lukaszbudyn.wakemyapp.entity.Website;

public interface WebPinger {
	public void pingAllWebsites(List<Website> websites);
	public void pingOneWebsite(Website website);
}