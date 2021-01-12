package com.everis.dar.springairline.model;

public class Aircraft {
	private String model;
	private Integer year;
	
	
	public Aircraft(String model, Integer year) {
		this.model = model;
		this.year = year;
	}

	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
}
