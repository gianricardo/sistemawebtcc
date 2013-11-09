package br.com.sistemaWebTCC.entity;

public class Configuracao {
	private int usuarioID;
	private String hora1;
	private String hora2;
	private String hora3;
	private String hora4;
	private String qtdGramas;
	
	public String getHora1() {
		return hora1;
	}
	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}
	public String getHora2() {
		return hora2;
	}
	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}
	public String getHora3() {
		return hora3;
	}
	public void setHora3(String hora3) {
		this.hora3 = hora3;
	}
	public String getHora4() {
		return hora4;
	}
	public void setHora4(String hora4) {
		this.hora4 = hora4;
	}
	public String getQtdGramas() {
		return qtdGramas;
	}
	public void setQtdGramas(String qtdGramas) {
		this.qtdGramas = qtdGramas;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

}
