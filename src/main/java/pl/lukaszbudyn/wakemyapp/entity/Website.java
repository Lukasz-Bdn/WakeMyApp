package pl.lukaszbudyn.wakemyapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Website {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String name;
	String stringUrl;
	
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
}
