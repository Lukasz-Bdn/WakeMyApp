package pl.lukaszbudyn.wakemyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.lukaszbudyn.wakemyapp.entity.Website;

public interface WebsiteRepository extends JpaRepository<Website, Long> {
//	@Query("SELECT w FROM Website w WHERE w.startHour > :now AND w.stopHour < :now")
//	List<Website> findValidHours(@Param("now") int now);
	
	@Query("SELECT w FROM Website w WHERE w.daysKeepAwake LIKE :today")
	List<Website> findWebsitesForToday(@Param("today") String today);
}