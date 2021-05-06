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

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
		
		response.sendRedirect("companyList");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/companyList");
//		request.setAttribute("company", company.getName());
//		rd.forward(request, response);
	}

}
