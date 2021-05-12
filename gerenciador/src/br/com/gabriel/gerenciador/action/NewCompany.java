package br.com.gabriel.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Company;
import br.com.gabriel.gerenciador.model.Database;

public class NewCompany implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Cadastrando nova empresa");
		
		String companyName = request.getParameter("name");
		String companyCreationDate = request.getParameter("openingDate");
		
		Date openingDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = sdf.parse(companyCreationDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Company company = new Company();
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		Database dataBase = new Database();
		dataBase.add(company);
		
		request.setAttribute("company", company.getName());
		
		return "redirect:input?action=ListCompany";
		
	}

}
