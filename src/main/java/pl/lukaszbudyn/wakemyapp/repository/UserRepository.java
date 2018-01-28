package pl.lukaszbudyn.wakemyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukaszbudyn.wakemyapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}