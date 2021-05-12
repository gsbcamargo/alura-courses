package br.com.gabriel.gerenciador.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Company;
import br.com.gabriel.gerenciador.model.Database;

public class CompanyShower {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Ação: Mostrando empresas.");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = new Database();
		
		Company company = database.getCompanyById(id);
		
		System.out.println("Empresa: " + company.getName());
		
		request.setAttribute("company", company);
		RequestDispatcher rd = request.getRequestDispatcher("/editCompanyForm.jsp");
		rd.forward(request, response);
	}	
}
