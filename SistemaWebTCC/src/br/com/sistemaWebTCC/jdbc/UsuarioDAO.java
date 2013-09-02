package br.com.sistemaWebTCC.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistemaWebTCC.bd.Conexao;
import br.com.sistemaWebTCC.entity.Usuario;


public class UsuarioDAO {

private Connection connection;
	
	public UsuarioDAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.connection = new Conexao().abrirConexao();
	}
	
	//Recebe um usuario e adiciona no BD
		public void cadastraUsuario(Usuario usuario){
			String sql = "insert into usuarios" +
						 "(nome, usuario, senha)" +
						 "values (?,?,?)";
			
			try{
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getUsuario());
				stmt.setString(3, usuario.getSenha());
				
				stmt.execute();
				stmt.close();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		/*
		public boolean validaUsuario(String usuario){
			String sql = "select usuario from usuarios where usuario=usuario";
			System.out.println("Entrou VALIDA USUARIO!!");
			try{
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				ResultSet usuarioDeRetorno = stmt.executeQuery();
				while(usuarioDeRetorno.next()){
					Usuario user = new Usuario();
					user.setUsuario(user.getUsuario());
					
					System.out.println("testeee: "+user.getUsuario());
					if(user.getUsuario().equals("usuario")){
						return true;
					}else{
						return false;
					}
				}
				stmt.execute();
				stmt.close();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
			return false;
		}
*/
}
