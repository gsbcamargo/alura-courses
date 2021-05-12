package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Company;
import br.com.gabriel.gerenciador.model.Database;

@WebServlet("/modifyCompany")
public class ModifyCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Alterando empresa.");
		
		String companyName = request.getParameter("name");
		String companyOpeningDate = request.getParameter("openingDate");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date openingDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			openingDate = sdf.parse(companyOpeningDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println("Id: " + id);
		
		Database database = new Database();
		Company company = database.getCompanyById(id);
		company.setName(companyName);
		company.setOpeningDate(openingDate);
		
		response.sendRedirect("companyList");
		
		
	}

}
