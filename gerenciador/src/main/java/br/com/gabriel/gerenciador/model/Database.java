package br.com.gabriel.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
	
	private static List<Materia> list = new ArrayList<>();
	private static List<User> userList = new ArrayList<>();
	private static Integer sequentialKey = 1;
	
	static {
		Materia company1 = new Materia();
		company1.setId(sequentialKey++);
		company1.setName("Alura");
		Materia company2 = new Materia();
		company2.setId(sequentialKey++);
		company2.setName("Caelum");
		list.add(company1);
		list.add(company2);
		
		User user1 = new User();
		user1.setLogin("gabriel");
		user1.setPassword("12345");
		User user2 = new User();
		user2.setLogin("yana");
		user2.setPassword("12345");
		userList.add(user1);
		userList.add(user2);
	}

	public void add(Materia company) {
		company.setId(Database.sequentialKey++);
		Database.list.add(company);
	}
	
	public List<Materia> getCompanies(){
		return Database.list;
	}

	public void removeCompany(Integer id) {
		
		Iterator<Materia> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			Materia company = iterator.next();
			if (company.getId() == id) {
				iterator.remove();
			}
		}
		
	}

	public Materia getCompanyById(Integer id) {
		for (Materia company : list) {
			if (company.getId() == id) {
				return company;
			}
		}
		return null;
	}

	public User doesUserExist(String login, String password) {
		for (User user : userList) {
			if (user.equals(login, password)) {
				return user;
			}
		}
		return null;
	}
}
