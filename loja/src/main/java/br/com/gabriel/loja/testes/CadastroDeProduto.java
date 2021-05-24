package br.com.gabriel.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.gabriel.loja.dao.CategoriaDao;
import br.com.gabriel.loja.dao.ProdutoDao;
import br.com.gabriel.loja.modelo.Categoria;
import br.com.gabriel.loja.modelo.Produto;
import br.com.gabriel.loja.util.JpaUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {

		cadastrarProduto();
		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		System.out.println(produto.getPreco());
		
		List<Produto> buscarTodos = produtoDao.buscarTodos();
		buscarTodos.forEach(p -> System.out.println(p.getNome()));
		
		List<Produto> buscarPorNome = produtoDao.buscarPorNome("Lenovo ThinkPad");
		buscarPorNome.forEach(p -> System.out.println(p.getNome()));
		
		List<Produto> buscarPorNomeCategoria = produtoDao.buscarPorNomeDaCategoria("INFORMATICA");
		buscarPorNomeCategoria.forEach(prod -> System.out.println(prod.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoPeloNome("Lenovo ThinkPad");
		System.out.println(precoDoProduto);
		
	}

	private static void cadastrarProduto() {
		Categoria informatica = new Categoria("INFORMATICA");
		Produto notebook = new Produto("Lenovo ThinkPad", "Awesome workstation", new BigDecimal("8000"), informatica);
		
		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(informatica);
		produtoDao.cadastrar(notebook);

		em.getTransaction().commit();
		em.close();
		
	}

}
