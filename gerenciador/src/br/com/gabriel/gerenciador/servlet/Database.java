package br.com.gabriel.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
	
	private static List<Company> list = new ArrayList<>();
	private static Integer sequentialKey = 1;
	
	static {
		Company company1 = new Company();
		company1.setId(sequentialKey++);
		company1.setName("Alura");
		Company company2 = new Company();
		company2.setId(sequentialKey++);
		company2.setName("Caelum");
		list.add(company1);
		list.add(company2);
	}

	public void add(Company company) {
		company.setId(Database.sequentialKey++);
		Database.list.add(company);
	}
	
	public List<Company> getCompanies(){
		return Database.list;
	}

	public void removeCompany(Integer id) {
		
		Iterator<Company> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			Company company = iterator.next();
			if (company.getId() == id) {
				iterator.remove();
			}
		}
		
	}

	public Company getCompanyById(Integer id) {
		for (Company company : list) {
			if (company.getId() == id) {
				return company;
			}
		}
		return null;
	}
}
