package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.MyqslConfiguration;

public class MysqlConnectionFactory {
	
	private Connection connection = null;

	public Connection getConnection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(MyqslConfiguration.getUrl(), MyqslConfiguration.getUsuario(), MyqslConfiguration.getSenha());
			
		} catch (ClassNotFoundException e) {
			System.err.println("Classe não encontrada: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Erro ao abrir uma conexão: " + e.getMessage());
		}
		
		return this.connection;

	}
	
	public boolean closeConnection() {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro ao fechar a conexão: " + e.getMessage());
		}
		
		return false;
	}

}
