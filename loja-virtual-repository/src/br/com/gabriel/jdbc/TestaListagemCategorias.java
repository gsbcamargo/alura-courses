package br.com.gabriel.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gabriel.jdbc.dao.CategoriaDAO;
import br.com.gabriel.jdbc.modelo.Categoria;
import br.com.gabriel.jdbc.modelo.Produto;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDao.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}
