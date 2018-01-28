package pl.lukaszbudyn.wakemyapp.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.lukaszbudyn.wakemyapp.entity.User;
import pl.lukaszbudyn.wakemyapp.repository.UserRepository;

@Controller("/")
public class HomeController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String home() {
		return "home/home";
	}
	
	@GetMapping("login")
	public String loginGet() {
		return "home/login";
	}

	@PostMapping("login")
	public String loginPost() {
		return "redirect:/";
	}

	@GetMapping("register")
	public String registerGet(Model m) {
		m.addAttribute("user", new User());
		return "home/register";
	}

	@PostMapping("register")
	@Transactional
	public String registerPost(@Valid @ModelAttribute User user, BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "redirect:register";
		}
		if (!user.isPasswordCorrent(user.getConfirmPassword())) {
			m.addAttribute("error", "Please make sure that both passwords match!");
			return "home/register";
		}
		user.setEnabled(true);
		this.userRepo.save(user);
		return "redirect:/login";
	}

	@GetMapping("403")
	public String accessDenied() {
		return "errors/accessDenied";
	}

}
