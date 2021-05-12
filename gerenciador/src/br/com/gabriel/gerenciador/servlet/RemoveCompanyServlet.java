package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Database;

@WebServlet("/removeCompany")
public class RemoveCompanyServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Database database = new Database();
		database.removeCompany(id);
		
		response.sendRedirect("companyList");
	}

}
