package br.com.sistemaWebTCC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistemaWebTCC.bd.Conexao;
import br.com.sistemaWebTCC.entity.Configuracao;
import br.com.sistemaWebTCC.entity.Usuario;


public class ConfiguracaoDAO {

private Connection connection;
	
	public ConfiguracaoDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.connection = new Conexao().abrirConexao();
	}
	
		public void cadastraConfiguracao(Configuracao config){
			String sql = "insert into configuracao" +
						 "(hora1, hora2, hora3, hora4, quantidadeEmGramas)" +
						 "values (?,?,?,?)";
			
			try{
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				stmt.setTimestamp(1, config.getHora1());
				stmt.setTimestamp(2, config.getHora1());
				stmt.setTimestamp(3, config.getHora1());
				stmt.setTimestamp(4, config.getHora1());
				stmt.setInt(5, config.getQtdGramas());
				
				stmt.execute();
				stmt.close();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
}
