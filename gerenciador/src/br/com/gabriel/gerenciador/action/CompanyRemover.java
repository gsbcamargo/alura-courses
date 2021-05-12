package br.com.gabriel.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.model.Database;

public class CompanyRemover {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Ação: Removendo empresa.");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Database database = new Database();
		database.removeCompany(id);
		
		return "redirect:input?action=ListCompany";

	}

}
