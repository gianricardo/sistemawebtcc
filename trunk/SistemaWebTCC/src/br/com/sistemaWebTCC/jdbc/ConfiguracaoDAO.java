package br.com.sistemaWebTCC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistemaWebTCC.bd.Conexao;
import br.com.sistemaWebTCC.entity.Configuracao;


public class ConfiguracaoDAO {

private Connection connection;
	
	public ConfiguracaoDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.connection = new Conexao().abrirConexao();
	}
	
		public void cadastraConfiguracao(Configuracao config){
			String sql = "insert into configuracao" +
						 "(hora1, hora2, hora3, hora4, quantidadeEmGramas)" +
						 "values (?,?,?,?,?)";
			
			try{
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				stmt.setString(1, config.getHora1());
				stmt.setString(2, config.getHora1());
				stmt.setString(3, config.getHora1());
				stmt.setString(4, config.getHora1());
				stmt.setString(5, config.getQtdGramas());
				
				stmt.execute();
				stmt.close();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
		public Configuracao consultarConfig(){
			String sql = "select * from configuracao";
			try{
				// prepared statement para o select
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				ResultSet configDeRetorno = stmt.executeQuery();
				if(configDeRetorno.next()){
					Configuracao config = new Configuracao();
					
					config.setUsuarioID(Integer.parseInt(configDeRetorno.getString("configID")));
					config.setHora1(configDeRetorno.getString("hora1"));
					config.setHora2(configDeRetorno.getString("hora2"));
					config.setHora3(configDeRetorno.getString("hora3"));
					config.setHora4(configDeRetorno.getString("hora4"));
					config.setQtdGramas(configDeRetorno.getString("quantidadeEmGramas"));
					
					return config;
				}
				stmt.execute();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return null;
		}
}
