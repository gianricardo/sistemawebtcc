package br.com.sistemaWebTCC.entity;

import java.sql.Timestamp;


public class Configuracao {
	private Timestamp hora1;
	private Timestamp hora2;
	private Timestamp hora3;
	private Timestamp hora4;
	private int qtdGramas;
	public Timestamp getHora1() {
		return hora1;
	}
	public void setHora1(Timestamp hora1) {
		this.hora1 = hora1;
	}
	public Timestamp getHora2() {
		return hora2;
	}
	public void setHora2(Timestamp hora2) {
		this.hora2 = hora2;
	}
	public Timestamp getHora3() {
		return hora3;
	}
	public void setHora3(Timestamp hora3) {
		this.hora3 = hora3;
	}
	public Timestamp getHora4() {
		return hora4;
	}
	public void setHora4(Timestamp hora4) {
		this.hora4 = hora4;
	}
	public int getQtdGramas() {
		return qtdGramas;
	}
	public void setQtdGramas(int qtdGramas) {
		this.qtdGramas = qtdGramas;
	}

}
