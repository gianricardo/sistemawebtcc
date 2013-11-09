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
			String sql = "insert into usuario" +
						 "(usuario, senha, nome, adm)" +
						 "values (?,?,?,?)";
			
			try{
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				stmt.setString(1, usuario.getUsuario());
				stmt.setString(2, usuario.getSenha());
				stmt.setString(3, usuario.getNome());
				stmt.setInt(4, usuario.getAdm());
				
				stmt.execute();
				stmt.close();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
		
		public Usuario validaUsuario(String UsuarioLogin, String senha){
			String sql = "select * from usuario where usuario='"+UsuarioLogin+"' and senha='"+senha+"'";
			try{
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				ResultSet usuarioDeRetorno = stmt.executeQuery();
				if(usuarioDeRetorno.next()){
					Usuario usuario = new Usuario();
					usuario.setUsuario(usuarioDeRetorno.getString("usuario"));
					usuario.setSenha(usuarioDeRetorno.getString("senha"));
					usuario.setAdm(Integer.parseInt(usuarioDeRetorno.getString("adm")));
					usuario.setUsuarioID(usuarioDeRetorno.getInt("usuarioID"));
					
					return usuario;
				}
				stmt.execute();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return null;
		}
		
		public Usuario consultarUsuario(int id){
			String sql = "select * from usuario where usuarioID="+id;
			try{
				// prepared statement para o select
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				// seta os valores
				ResultSet usuarioDeRetorno = stmt.executeQuery();
				if(usuarioDeRetorno.next()){
					Usuario usuario = new Usuario();
					usuario.setUsuario(usuarioDeRetorno.getString("usuario"));
					usuario.setSenha(usuarioDeRetorno.getString("senha"));
					usuario.setNome(usuarioDeRetorno.getString("nome"));
					usuario.setUsuarioID(Integer.parseInt(usuarioDeRetorno.getString("usuarioID")));
					usuario.setAdm(Integer.parseInt(usuarioDeRetorno.getString("adm")));
					
					return usuario;
				}
				stmt.execute();
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return null;
		}
		
		public boolean editarUsuario(Usuario usuario) {
			String comando = "Update usuario set nome=?, usuario=?, senha=? where usuarioID=" + usuario.getUsuarioID();
			PreparedStatement p;
			try {
				p = connection.prepareStatement(comando);
				p.setString(1, usuario.getNome());
				p.setString(2, usuario.getUsuario());
				p.setString(3, usuario.getSenha());
				p.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
