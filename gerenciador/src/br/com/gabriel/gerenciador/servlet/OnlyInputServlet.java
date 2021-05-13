package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabriel.gerenciador.action.NewCompany;
import br.com.gabriel.gerenciador.action.NewCompanyForm;
import br.com.gabriel.gerenciador.action.Action;
import br.com.gabriel.gerenciador.action.EditCompany;
import br.com.gabriel.gerenciador.action.ListCompany;
import br.com.gabriel.gerenciador.action.RemoveCompany;
import br.com.gabriel.gerenciador.action.ShowCompany;

@WebServlet("/input")
public class OnlyInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String actionParam = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean userNotSigned = (session.getAttribute("userSigned") == null);
		boolean isAProtectedAction = !(actionParam.equals("Login") || actionParam.equals("LoginForm"));
		
		if (isAProtectedAction && userNotSigned) {
			response.sendRedirect("input?action=LoginForm");
			return;
		}
		
		String className = "br.com.gabriel.gerenciador.action." + actionParam;
		
		String name;
		
		try {
			Class classParam = Class.forName(className); // carregue a classe com o nome
			Action action = (Action) classParam.newInstance();
			name = action.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] typeAndAddress = name.split(":");
		if (typeAndAddress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAndAddress[1]);
	}
	
//	String name = null;
	
//	if (actionParam.equals("ListCompany")) {
//		ListCompany actionList = new ListCompany();
//		name = actionList.execute(request, response);
//		
//	} else if (actionParam.equals("RemoveCompany")) {
//		RemoveCompany actionRemove = new RemoveCompany();
//		name = actionRemove.execute(request, response);
//		
//	} else if (actionParam.equals("ShowCompany")) {
//		ShowCompany actionShow = new ShowCompany();
//		name = actionShow.execute(request, response);
//		
//	} else if (actionParam.equals("EditCompany")) { 
//		EditCompany actionEdit = new EditCompany();
//		name = actionEdit.execute(request, response);
//		
//	} else if (actionParam.equals("NewCompany")) { 
//		NewCompany actionCreate= new NewCompany();
//		name = actionCreate.execute(request, response);
//	
//	} else if (actionParam.equals("NewCompanyForm")) { 
//		NewCompanyForm actionCreate= new NewCompanyForm();
//		name = actionCreate.execute(request, response);
//	
//	}
	

	
	}

}
