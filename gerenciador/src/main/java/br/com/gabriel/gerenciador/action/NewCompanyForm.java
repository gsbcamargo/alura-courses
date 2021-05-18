package br.com.gabriel.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCompanyForm implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		return "forward:newCompanyForm.jsp";
		
	}

}
