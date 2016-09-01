package br.com.fiap.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.bean.LivrosBeanRemote;
import br.com.fiap.entity.Livros;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/ExemploQueue") })
public class LivrosMDB implements MessageListener {

	public LivrosMDB() {
		// TODO Auto-generated constructor stub
	}

	public void onMessage(Message message) {
		ObjectMessage object = (ObjectMessage) message;
		
		try {
			Livros livro = (Livros) object.getObject();
			
			InitialContext ctx = new InitialContext();
			LivrosBeanRemote service = (LivrosBeanRemote) ctx.lookup("ejb:/03_LivrosEJB/LivrosBean!br.com.fiap.bean.LivrosBeanRemote");
			
			service.add(livro);
			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}