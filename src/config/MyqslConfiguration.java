package config;

public abstract class MyqslConfiguration {

	private static String endereco	= "localhost";
	private static int porta 		= 3306;
	private static String usuario	= "root";
	private static String senha		= "root";
	private static String banco		= "escola";
	private static boolean useSsl	= false;

	public static String getEndereco() {
		return endereco;
	}

	public static int getPorta() {
		return porta;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static String getSenha() {
		return senha;
	}

	public static String getBanco() {
		return banco;
	}

	public static boolean isUseSsl() {
		return useSsl;
	}
	
	public static String getUrl() {
		return "jdbc:mysql://"+ endereco + ":" + porta + "/" + banco + "?useSSL=" + useSsl;
	}

}
