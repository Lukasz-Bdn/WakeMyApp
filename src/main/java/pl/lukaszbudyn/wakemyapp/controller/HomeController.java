package pl.lukaszbudyn.wakemyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.lukaszbudyn.wakemyapp.app.WebPinger;
import pl.lukaszbudyn.wakemyapp.app.WebPingerImpl;
import pl.lukaszbudyn.wakemyapp.entity.Website;

@Controller("/")
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		Website website = new Website("heroku", "https://spare-part-mgr.herokuapp.com/");
		WebPinger webPinger = new WebPingerImpl();
		webPinger.pingOneWebsite(website);
		return "index";
	}
}