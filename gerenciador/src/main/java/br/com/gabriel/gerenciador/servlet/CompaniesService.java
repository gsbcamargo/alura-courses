package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

//import com.google.gson.Gson;

import br.com.gabriel.gerenciador.model.Materia;
import br.com.gabriel.gerenciador.model.Database;

/**
 * Servlet implementation class ListCompanyService
 */
@WebServlet("/companies")
public class CompaniesService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Materia> companies = new Database().getCompanies();
		
		String value = request.getHeader("Accept");
		
		System.out.println(value);
		
		if(value.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("company", Materia.class);
			String xml = xstream.toXML(companies);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else if (value.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(companies);
	
			response.setContentType("application/json");
			response.getWriter().print(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
			
		
		

		
	
	}

}
