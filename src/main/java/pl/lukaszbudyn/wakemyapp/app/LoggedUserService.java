package pl.lukaszbudyn.wakemyapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pl.lukaszbudyn.wakemyapp.entity.User;
import pl.lukaszbudyn.wakemyapp.repository.UserRepository;

@Component
public class LoggedUserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User getLoggedUser() {
		String loggeUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		User loggedUser = userRepo.findOneByEmail(loggeUserEmail);
		return loggedUser;
	}
}