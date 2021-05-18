package br.com.gabriel.gerenciador.model;

import java.util.Date;

public class Materia {
	
	private int id;
	private String name;
	private Date openingDate = new Date();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getOpeningDate() {
		return openingDate;
	}
	
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	
}
