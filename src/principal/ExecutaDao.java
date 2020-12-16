package principal;
import java.sql.Connection;

import dao.UsuarioDao;
import database.MysqlConnectionFactory;
import entidade.Usuario;

public class ExecutaDao {

	public static void main(String[] args) {

		MysqlConnectionFactory connectionFactory = new MysqlConnectionFactory();
		Connection conexao = connectionFactory.getConnection();

		if (conexao != null) {
			UsuarioDao usuarioDao = new UsuarioDao(conexao);
			
			// Buscar todos os registros do banco
			System.out.println(usuarioDao.getAll());

			// Buscando um usuário específico pelo ID
//			System.out.println(usuarioDao.getById(5));
			
			// Excluir um usuário
//			Usuario usuarioParaDelecao = new Usuario();
//			usuarioParaDelecao.setId(6);
//			usuarioDao.delete(usuarioParaDelecao);
			
			// Atualizando umm registro
//			Usuario usuarioParaAtualizacao = new Usuario();
//			usuarioParaAtualizacao.setId(3);
//			usuarioParaAtualizacao.setNome("Camila Saraiva");
//			usuarioParaAtualizacao.setEmail("camila.saraiva@exemplo.com");
//			usuarioParaAtualizacao.setSenha("1234");
//			usuarioParaAtualizacao.setAtivo(true);
//			usuarioDao.update(usuarioParaAtualizacao);

			// Inserindo um novo usuário
//			Usuario usuarioParaInsercao = new Usuario();
//			usuarioParaInsercao.setNome("Antonio Macena");
//			usuarioParaInsercao.setEmail("antonio.macena@exemplo.com");
//			usuarioParaInsercao.setSenha("1234");
//			usuarioParaInsercao.setAtivo(true);
//			usuarioDao.insert(usuarioParaInsercao);
			
			System.out.println(usuarioDao.getAll());

			connectionFactory.closeConnection();
		}

	}

}
