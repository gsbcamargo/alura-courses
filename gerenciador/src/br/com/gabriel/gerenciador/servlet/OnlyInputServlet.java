package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.action.CompanyCreator;
import br.com.gabriel.gerenciador.action.CompanyEditor;
import br.com.gabriel.gerenciador.action.CompanyListener;
import br.com.gabriel.gerenciador.action.CompanyRemover;
import br.com.gabriel.gerenciador.action.CompanyShower;

@WebServlet("/input")
public class OnlyInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String actionParam = request.getParameter("action");
	
	if (actionParam.equals("ListCompany")) {
		CompanyListener actionList = new CompanyListener();
		actionList.execute(request, response);
		
	} else if (actionParam.equals("RemoveCompany")) {
		CompanyRemover actionRemove = new CompanyRemover();
		actionRemove.execute(request, response);
		
	} else if (actionParam.equals("ShowCompany")) {
		CompanyShower actionShow = new CompanyShower();
		actionShow.execute(request, response);
		
	} else if (actionParam.equals("EditCompany")) { 
		CompanyEditor actionEdit = new CompanyEditor();
		actionEdit.execute(request, response);
		
	} else if (actionParam.equals("NewCompany")) { 
		CompanyCreator actionCreate= new CompanyCreator();
		actionCreate.execute(request, response);
	
	}
	
	}

}
