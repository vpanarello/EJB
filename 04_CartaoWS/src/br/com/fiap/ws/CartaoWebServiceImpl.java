package br.com.fiap.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="CartaoWebService/cartaoendpoint")
public class CartaoWebServiceImpl implements CartaoWebService {

	@Override
	public String validarCartao(@WebParam(name = "numero") String numCartao,
			@WebParam(name = "valor") double valor) {
		if(numCartao.length() != 16){
			return "Cart�o inv�lido";
		}
		else {
			return "D�bito de " + valor + " efetuado com sucesso";
		}
	}

}
