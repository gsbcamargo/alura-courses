package br.com.gabriel.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.gabriel.loja.dao.CategoriaDao;
import br.com.gabriel.loja.dao.ProdutoDao;
import br.com.gabriel.loja.modelo.Categoria;
import br.com.gabriel.loja.modelo.Produto;
import br.com.gabriel.loja.util.JpaUtil;

public class TesteCriteria {

	public static void main(String[] args) {

		popularBancoDeDados();
		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		produtoDao.buscarPorParametrosComCriteria("PS5", null, LocalDate.now());
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("4500"), videogames);
		Produto macbook = new Produto("Macbook", "Macbook pro retina", new BigDecimal("10000"), informatica);

		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);

		em.getTransaction().commit();
		em.close();
	}

}
