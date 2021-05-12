package br.com.gabriel.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Company;
import br.com.gabriel.gerenciador.model.Database;

public class CompanyListener {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("A��o: Listando empresas.");

		
		Database dataBase = new Database();
		List<Company> list = dataBase.getCompanies();

		request.setAttribute("companies", list);
		
		return "forward:/companyList.jsp";

	}

}
