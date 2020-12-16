package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.Usuario;

public class UsuarioDao implements DaoGenerico {

	Connection conexao = null;

	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean insert(Object object) {

		Usuario usuario = (Usuario) object;

		Statement insercao;
		try {
			insercao = this.conexao.createStatement();
			return insercao.execute("INSERT INTO usuario (nome, email, senha, ativo) VALUES ('" + usuario.getNome()
					+ "', '" + usuario.getEmail() + "', '" + usuario.getSenha() + "', " + usuario.isAtivo() + ")");
		} catch (SQLException e) {
			System.err.println("Erro ao inserir registro: " + e.getMessage());
		}

		return false;
	}

	@Override
	public Object getById(int id) {
		Statement sentenca;
		try {
			sentenca = this.conexao.createStatement();
			ResultSet rs = sentenca.executeQuery("SELECT * FROM usuario WHERE id = " + id);

			rs.first();

			Usuario usuarioBanco = new Usuario();
			
			usuarioBanco.setId(rs.getInt("id"));
			usuarioBanco.setNome(rs.getString("nome"));
			usuarioBanco.setEmail(rs.getString("email"));
			usuarioBanco.setSenha(rs.getString("senha"));
			usuarioBanco.setAtivo(rs.getBoolean("ativo"));

			return (Object) usuarioBanco;

		} catch (SQLException e) {
			System.err.println("Erro ao recuperar registro: " + e.getMessage());
		}

		return null;
	}

	@Override
	public List<Object> getAll() {
		List<Object> listaDeUsuarios = new ArrayList<Object>();

		Statement sentenca;
		try {
			sentenca = this.conexao.createStatement();
			ResultSet rs = sentenca.executeQuery("SELECT * FROM usuario");

			while (rs.next()) {

				Usuario usuarioBanco = new Usuario();

				usuarioBanco.setId(rs.getInt("id"));
				usuarioBanco.setNome(rs.getString("nome"));
				usuarioBanco.setEmail(rs.getString("email"));
				usuarioBanco.setSenha(rs.getString("senha"));
				usuarioBanco.setAtivo(rs.getBoolean("ativo"));

				listaDeUsuarios.add((Object) usuarioBanco);
			}

			return listaDeUsuarios;

		} catch (SQLException e) {
			System.err.println("Erro ao recuperar registros: " + e.getMessage());
		}

		return null;

	}

	@Override
	public boolean update(Object object) {
		Usuario usuario = (Usuario) object;

		Statement atualizacao;
		try {
			atualizacao = this.conexao.createStatement();
			return atualizacao.execute(
					"UPDATE usuario SET nome='" + usuario.getNome() + "', email='" + usuario.getEmail() + "', senha='"
							+ usuario.getSenha() + "', ativo=" + usuario.isAtivo() + " WHERE id = " + usuario.getId());
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar registro: " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean delete(Object object) {
		Usuario usuario = (Usuario) object;

		Statement delecao;
		try {
			delecao = this.conexao.createStatement();
			return delecao.execute("DELETE FROM usuario WHERE id = " + usuario.getId());
		} catch (SQLException e) {
			System.err.println("Erro ao excluir registro: " + e.getMessage());
		}

		return false;
	}

}
