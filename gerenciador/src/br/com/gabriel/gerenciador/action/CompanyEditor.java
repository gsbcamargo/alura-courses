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

public class CompanyEditor {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String companyName = request.getParameter("name");
		String companyOpeningDate = request.getParameter("openingDate");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Ação: Editando empresa " + id);
		
		Date openingDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = sdf.parse(companyOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Database database = new Database();
		Company company = database.getCompanyById(id);
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		return "redirect:input?action=ListCompany";

	}	
}
