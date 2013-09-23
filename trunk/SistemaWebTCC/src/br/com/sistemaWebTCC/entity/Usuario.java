package br.com.sistemaWebTCC.entity;

public class Usuario {
	private int usuarioID;
	private String usuario;
	private String senha;
	private String nome;
	private int alimentadorID;
	private int adm;
	
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	public int getAlimentadorID() {
		return alimentadorID;
	}
	public void setAlimentadorID(int alimentadorID) {
		this.alimentadorID = alimentadorID;
	}
	public int getAdm() {
		return adm;
	}
	public void setAdm(int adm) {
		this.adm = adm;
	}
	

}
