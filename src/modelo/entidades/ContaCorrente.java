package modelo.entidades;

import modelo.excecoes.Excecoes;

public class ContaCorrente {

	//Atributos
	private Integer numeroDaConta;
	private String correntista;
	private Double saldoDaConta;
	private Double limiteDeSaque;
	
	//Construtores
	public ContaCorrente() {
	}
	public ContaCorrente(Integer numeroDaConta, String correntista, Double saldoDaConta, Double limiteDeSaque) {
		this.numeroDaConta = numeroDaConta;
		this.correntista = correntista;
		this.saldoDaConta = saldoDaConta;
		this.limiteDeSaque = limiteDeSaque;
	}

	//GETs e SETs
	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}
	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}
	public String getCorrentista() {
		return correntista;
	}
	public void setCorrentista(String correntista) {
		this.correntista = correntista;
	}
	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void setLimiteDeSaque(Double limiteDeSaque) {
		this.limiteDeSaque = limiteDeSaque;
	}
	
	public Double getSaldoDaConta() {
		return saldoDaConta;
	}

	//Métodos
	public void deposito (Double deposito) {
		this.saldoDaConta += deposito;
	}
	public void saque (Double saque) throws Excecoes {
		if (saque > getLimiteDeSaque()) {
			throw new Excecoes ("saque acima do limite de $" + String.format("%.2f",getLimiteDeSaque()));
		}
		if (saque > getSaldoDaConta()) {
			throw new Excecoes ("saldo insuficiente. O Saldo atual é de: " + String.format("%.2f", getSaldoDaConta()));
		}
		this.saldoDaConta -= saque;
	}
	
	//Método para impressão
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Novo saldo: $%.2f", getSaldoDaConta())
				+ " - Operação realizada com sucesso!";
	}
}
