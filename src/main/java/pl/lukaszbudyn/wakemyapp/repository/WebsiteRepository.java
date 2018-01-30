package pl.lukaszbudyn.wakemyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.lukaszbudyn.wakemyapp.entity.User;
import pl.lukaszbudyn.wakemyapp.entity.Website;

public interface WebsiteRepository extends JpaRepository<Website, Long> {
	@Query("SELECT w FROM Website w WHERE w.daysKeepAwake LIKE %:today% AND w.startHour<=:hourNow AND w.stopHour>=:hourNow")
	List<Website> findWebsitesToPingNow(@Param("today") String today, @Param("hourNow") int hourNow);

	@Query("SELECT w FROM Website w WHERE w.user=:loggedUser")
	List<Website> findAllByUser(@Param("loggedUser") User loggedUser);
}