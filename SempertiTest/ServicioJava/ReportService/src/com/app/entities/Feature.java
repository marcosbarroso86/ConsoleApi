package com.app.entities;

/**
 * 
 * @author Marcos
 *
 * clase auxiliar , permite guardar la info obtenida como clave=valor
 */

public class Feature {
	
	private String description;
	private String value;
	
	
	
	public Feature(String description, String value) {
		super();
		this.description = description;
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
