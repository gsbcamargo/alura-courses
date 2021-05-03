package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newCompany")
public class NewCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa.");
		
		String companyName = request.getParameter("nome");
		
		Company company = new Company();
		company.setName(companyName);
		
		Database database = new Database();
		database.add(company);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " + companyName + " cadastrada com sucesso.</body></html>");
	}

}
