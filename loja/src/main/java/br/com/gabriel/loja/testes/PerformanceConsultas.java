package br.com.gabriel.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.gabriel.loja.dao.CategoriaDao;
import br.com.gabriel.loja.dao.ClienteDao;
import br.com.gabriel.loja.dao.PedidoDao;
import br.com.gabriel.loja.dao.ProdutoDao;
import br.com.gabriel.loja.modelo.Categoria;
import br.com.gabriel.loja.modelo.Cliente;
import br.com.gabriel.loja.modelo.ItemPedido;
import br.com.gabriel.loja.modelo.Pedido;
import br.com.gabriel.loja.modelo.Produto;
import br.com.gabriel.loja.util.JpaUtil;

public class PerformanceConsultas {

	public static void main(String[] args) {

		popularBancoDeDados();

		EntityManager em = JpaUtil.getEntityManager();

		Pedido pedido = em.find(Pedido.class, 1l);
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.buscarPedidoComCliente(1l);

		em.close();

		System.out.println(pedido.getCliente().getNome());
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4500"), videogames);
		Produto macbook = new Produto("Macbook", "Macbook pro retina", new BigDecimal("10000"), informatica);

		Cliente cliente = new Cliente("Gabriel", "12313231");

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(40, pedido, videogame));

		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido, macbook));

		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);

		clienteDao.cadastrar(cliente);

		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);

		em.getTransaction().commit();
		em.close();
	}

}
