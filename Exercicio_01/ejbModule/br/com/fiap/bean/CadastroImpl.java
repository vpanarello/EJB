package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.fiap.interfaces.Cadastro;
@Stateful
public class CadastroImpl implements Cadastro {
	
	List<String> dicionario;
	
	public CadastroImpl() {
		super();
		dicionario = new ArrayList<>();
	}

	@Override
	public List<String> buscarNomes() {
		return dicionario;
	}

	@Override
	public void incluirNome(String nome) {
		dicionario.add(nome);

	}

}
