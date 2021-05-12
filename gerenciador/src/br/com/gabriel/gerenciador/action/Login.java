package br.com.gabriel.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Database;
import br.com.gabriel.gerenciador.model.User;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Database database = new Database();
		User user = database.doesUserExist(login, password);
		
		if(user != null) {
			System.out.println("Usu�rio existe.");
			System.out.println(login + " logando.");
			return "redirect:input?action=ListCompany";
		} else {
			System.out.println("Usu�rio desconhecido.");
			return "redirect:input?action=LoginForm";
		}
	}

}
