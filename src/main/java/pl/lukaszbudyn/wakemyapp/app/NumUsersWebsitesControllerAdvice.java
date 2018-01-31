package pl.lukaszbudyn.wakemyapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.lukaszbudyn.wakemyapp.repository.UserRepository;
import pl.lukaszbudyn.wakemyapp.repository.WebsiteRepository;

@Controller
@ControllerAdvice
public class NumUsersWebsitesControllerAdvice {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private WebsiteRepository websiteRepo;
	
	@ModelAttribute("numOfUsers")
	public long numOfUsers(Model m) {
		return userRepo.count();
	}
	
	@ModelAttribute("numOfWebsites")
	public long numOfWebsites(Model m) {
		return websiteRepo.count();
	}
}
