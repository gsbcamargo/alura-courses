package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.action.Action;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
//@WebFilter("/input")
public class ControllerFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControllerFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String actionParam = request.getParameter("action");
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
		
	}

}
