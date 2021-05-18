import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		
		boolean resultado = 
				stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidad de linhas que foram modificadas: " + linhasModificadas); 
	}

}
