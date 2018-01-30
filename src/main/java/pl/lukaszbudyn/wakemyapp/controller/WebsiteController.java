package pl.lukaszbudyn.wakemyapp.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukaszbudyn.wakemyapp.app.LoggedUserService;
import pl.lukaszbudyn.wakemyapp.entity.User;
import pl.lukaszbudyn.wakemyapp.entity.Website;
import pl.lukaszbudyn.wakemyapp.repository.UserRepository;
import pl.lukaszbudyn.wakemyapp.repository.WebsiteRepository;

@Controller
@RequestMapping("/website")
public class WebsiteController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	WebsiteRepository websiteRepo;
	@Autowired
	LoggedUserService loggedUserService;
	
	@GetMapping("/show")
	public String showUserWebsites(Model m) {
		User loggedUser = loggedUserService.getLoggedUser();
		List<Website> userWebsites = websiteRepo.findWebsitesToPingNow("Tue", 15);
		m.addAttribute("userWebsites", userWebsites);
		return "/website/website";
	}
	
	@GetMapping("/add")
	public String addWebsiteGet(Model m) {
		m.addAttribute("website", new Website());
		m.addAttribute("currentTime", Calendar.getInstance().getTime().toString());
		return "website/add_website";
	}
	
	@PostMapping("/add")
	public String addWebsitePost(@Valid Website website, BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "website/add_website";
		}
		website.setUser(loggedUserService.getLoggedUser());
		websiteRepo.save(website);
		return "redirect:/website/show";
	}
	
}