package br.com.fiap.interfaces;

public interface FolhaPagamento {
	void setSalario(double salario);
	void setDesconto(double taxa);
	double calcularINSS();
	double calcularSalarioLiquido();
}