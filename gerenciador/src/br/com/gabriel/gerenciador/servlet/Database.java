package br.com.gabriel.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private static List<Company> list = new ArrayList<>();
	
	static {
		Company company1 = new Company();
		company1.setName("Alura");
		Company company2 = new Company();
		company2.setName("Caelum");
		list.add(company1);
		list.add(company2);
	}

	public void add(Company company) {
		Database.list.add(company);
	}
	
	public List<Company> getCompanies(){
		return Database.list;
	}

}
