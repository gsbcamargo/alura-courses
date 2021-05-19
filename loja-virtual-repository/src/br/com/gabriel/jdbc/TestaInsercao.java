package br.com.gabriel.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	public static void main(String[] args) throws SQLException {
		
		String nome = "";
		String descricao = "";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = 
				connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
		
	}

}
