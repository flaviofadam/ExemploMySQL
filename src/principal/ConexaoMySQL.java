package principal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import entidade.Usuario;

public class ConexaoMySQL {

	public static void main(String[] args) {

		Connection conexao = null;
		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		try {
			String usuario = "root";
			String senha = "root";
			String url = "jdbc:mysql://localhost:3306/escola?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("A conexão está funcionando!");
			
			Statement sentenca = conexao.createStatement();
			ResultSet rs = sentenca.executeQuery("SELECT * FROM usuario;");
			
			while (rs.next()) {
				
				Usuario usuarioBanco = new Usuario();
				
				usuarioBanco.setId(rs.getInt("id"));
				usuarioBanco.setNome(rs.getString("nome"));
				usuarioBanco.setEmail(rs.getString("email"));
				usuarioBanco.setSenha(rs.getString("senha"));
				usuarioBanco.setAtivo(rs.getBoolean("ativo"));
				
				listaDeUsuarios.add(usuarioBanco);
			}
			
			System.out.println(listaDeUsuarios);
			
			Statement insercao = conexao.createStatement();
			insercao.execute("INSERT INTO log (operacao, usuario) VALUES ('SELECT', 1)");
			
		} catch (Exception exception) {
			System.err.println("Ocorreu um problema na conexão: " + exception.getMessage());
		} finally {
			if (conexao != null) {
				try {
					conexao.close();
					System.out.println("Encerrando conexão.");
				} catch (Exception exception) {
				}
			}
		}

	}

}
