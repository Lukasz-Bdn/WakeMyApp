package pl.lukaszbudyn.wakemyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.lukaszbudyn.wakemyapp.app.WebPinger;

@Controller("/")
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		try {
			WebPinger.pingWebsites();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}