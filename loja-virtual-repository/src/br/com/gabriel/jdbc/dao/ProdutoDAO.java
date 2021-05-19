package br.com.gabriel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.gabriel.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());

			preparedStatement.execute();

			try (ResultSet rst = preparedStatement.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.execute();

			try (ResultSet rst = preparedStatement.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

}
