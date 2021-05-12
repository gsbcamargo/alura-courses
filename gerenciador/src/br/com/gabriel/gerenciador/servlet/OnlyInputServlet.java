package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class OnlyInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String actionParam = request.getParameter("action");
	
	if (actionParam.equals("CompanyList")) {
		System.out.println("Listando empresas.");
	} else if (actionParam.equals("RemoveCompany")) {
		System.out.println("Removendo empresas.");
	} else if (actionParam.equals("ShowCompany")) {
		System.out.println("Mostrando dados da empresa.");
	}
	
	}

}
