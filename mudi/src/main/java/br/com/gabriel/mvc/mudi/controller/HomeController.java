package br.com.gabriel.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gabriel.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();

		pedido.setNomeProduto("Kindle");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61X0ISBpD-L._AC_SL1000_.jpg");
		pedido.setUrlProduto(
				"https://www.amazon.com.br/Kindle-10a-gera%C3%A7%C3%A3o-ilumina%C3%A7%C3%A3o-embutida/dp/B07FQK1TS9/ref=asc_df_B07FQK1TS9/?tag=googleshopp00-20&linkCode=df0&hvadid=432951822456&hvpos=&hvnetw=g&hvrand=17413742439289834887&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001634&hvtargid=pla-901759904091&psc=1");
		pedido.setDescricao("Anything really just for testing purposes");

		List<Pedido> pedidos = Arrays.asList(pedido, pedido, pedido, pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
