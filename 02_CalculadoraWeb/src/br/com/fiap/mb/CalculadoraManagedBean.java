package br.com.fiap.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.interfaces.CalculadoraLocal;

@ManagedBean(name="calcMB")
public class CalculadoraManagedBean {

	@EJB
	private CalculadoraLocal calc;

	private double x, y;

	private String resultado;

	public CalculadoraLocal getCalc() {
		return calc;
	}

	public void setCalc(CalculadoraLocal calc) {
		this.calc = calc;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	} 

	public void somar(){
		double result = calc.somar(x, y);
		setResultado("Soma = " + result);
	}
	public void subtrair(){
		double result = calc.subtrair(x, y);
		setResultado("Subtra��o = " + result);
	}
	public void multiplicar(){
		double result = calc.multiplicar(x, y);
		setResultado("Multiplica��o = " + result);
	}
	public void dividir(){
		double result = calc.dividir(x, y);
		setResultado("Divis�o = " + result);
	} 

}
