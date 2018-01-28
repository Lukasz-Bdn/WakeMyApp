package pl.lukaszbudyn.wakemyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Website> userWebsites = loggedUser.getWebsites();
		m.addAttribute("userWebsites", userWebsites);
		return "/website/website";
	}
}