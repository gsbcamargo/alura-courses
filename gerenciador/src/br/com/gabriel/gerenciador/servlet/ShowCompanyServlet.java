package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Company;
import br.com.gabriel.gerenciador.model.Database;

@WebServlet("/showCompany")
public class ShowCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = new Database();
		
		Company company = database.getCompanyById(id);
		
		System.out.println("Empresa: " + company.getName());
		
		request.setAttribute("company", company);
		RequestDispatcher rd = request.getRequestDispatcher("/modifyCompanyForm.jsp");
		rd.forward(request, response);
	}

}
