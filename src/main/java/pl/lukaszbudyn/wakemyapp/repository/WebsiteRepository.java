package pl.lukaszbudyn.wakemyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukaszbudyn.wakemyapp.entity.Website;

public interface WebsiteRepository extends JpaRepository<Website, Long> {

}
