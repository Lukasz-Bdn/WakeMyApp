package pl.lukaszbudyn.wakemyapp.entity;

import java.net.URL;

public class Website {
	String name;
	String stringUrl;
	
	public Website(String name, String stringUrl) {
		super();
		this.name = name;
		this.stringUrl = stringUrl;
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
