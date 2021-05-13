package br.com.gabriel.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabriel.gerenciador.model.Company;
import br.com.gabriel.gerenciador.model.Database;

public class ListCompany implements Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("userSigned") == null) {
			return "redirect:input?action=LoginForm";
		}
		
		System.out.println("Ação: Listando empresas.");

		
		Database dataBase = new Database();
		List<Company> list = dataBase.getCompanies();

		request.setAttribute("companies", list);
		
		return "forward:companyList.jsp";

	}

}
