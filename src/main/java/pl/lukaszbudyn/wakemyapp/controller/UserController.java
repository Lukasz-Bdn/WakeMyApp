package pl.lukaszbudyn.wakemyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.lukaszbudyn.wakemyapp.entity.User;
import pl.lukaszbudyn.wakemyapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;

	@GetMapping("/all")
	public String userAll(Model m) {
		List<User> users = userRepo.findAll();
		m.addAttribute("users", users);
		return "user/showall";
	}
	
	@GetMapping("/toggleenable/{id}")
	public String disableEnable(@PathVariable long id) {
		User user = userRepo.findOne(id);
		user.toggleDisableEnable();
		userRepo.save(user);
		return "redirect:/user/all";
	}
	
}