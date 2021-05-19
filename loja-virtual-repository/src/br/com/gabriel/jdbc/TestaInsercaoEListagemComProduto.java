package br.com.gabriel.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gabriel.jdbc.dao.ProdutoDAO;
import br.com.gabriel.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("CÔMODA", "CÔMODA VERTICAL");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvarProduto(comoda);

			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}

}
