package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/companyList")
public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Database dataBase = new Database();
		List<Company> list = dataBase.getCompanies();

		request.setAttribute("companies", list);

		RequestDispatcher rd = request.getRequestDispatcher("/companyList.jsp");
		rd.forward(request, response);

	}
}
