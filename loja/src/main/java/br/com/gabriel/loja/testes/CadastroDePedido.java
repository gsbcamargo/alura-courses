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

public class CadastroDePedido {

	public static void main(String[] args) {
		
		popularBancoDados();
		
		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.bucarPorId(1l);
		
		em.getTransaction().begin();
		

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(5, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
	}
	
	private static void popularBancoDados() {
		Categoria informatica = new Categoria("INFORMATICA");
		Produto notebook = new Produto("Lenovo ThinkPad", "Awesome workstation", new BigDecimal("8000"), informatica);
		
		Cliente cliente = new Cliente("Gabriel", "123456");
		
		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();

		categoriaDao.cadastrar(informatica);
		produtoDao.cadastrar(notebook);
		clienteDao.cadastrar(cliente);

		em.getTransaction().commit();
		em.close();
		
	}
	

}
