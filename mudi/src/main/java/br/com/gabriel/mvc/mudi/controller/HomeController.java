package br.com.gabriel.mvc.mudi.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gabriel.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping("/home")
	public String home(Model model) {
		
		Query query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
		List<Pedido> pedidos = query.getResultList();

		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
