package com.grayMatter;

public class Address {
	private String city;
	private String state;
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	
	public Address() {
		super();
	}
	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	
	

}
