package pl.lukaszbudyn.wakemyapp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="website")
public class Website {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@NotNull
	@NotEmpty
	String name;
	@URL
	String stringUrl;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	private String startDayOfWeek;
	private String stopDayOfWeek;
	private int startHour;
	private int stopHour;
	
	public Website() {
		super();
	}

	public Website(String name, String stringUrl) {
		super();
		this.name = name;
		this.stringUrl = stringUrl;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStringUrl() {
		return stringUrl;
	}
	
	public void setStringUrl(String stringUrl) {
		this.stringUrl = stringUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStartDayOfWeek() {
		return startDayOfWeek;
	}

	public void setStartDayOfWeek(String startDayOfWeek) {
		this.startDayOfWeek = startDayOfWeek;
	}

	public String getStopDayOfWeek() {
		return stopDayOfWeek;
	}

	public void setStopDayOfWeek(String stopDayOfWeek) {
		this.stopDayOfWeek = stopDayOfWeek;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStopHour() {
		return stopHour;
	}

	public void setStopHour(int stopHour) {
		this.stopHour = stopHour;
	}
	
}
