package br.com.gabriel.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private static List<Company> companyList = new ArrayList<>();
	
	public void add(Company company) {
		Database.companyList.add(company);
	}
	
	public List<Company> getCompanies() {
		return Database.companyList;
	}

}
