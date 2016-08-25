package br.com.fiap.mdb;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import br.com.fiap.entity.*;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(
						propertyName= "destination", propertyValue = "queue/ExemploQueue")
		}) 

public class QueueListenerMDB implements MessageListener {
	 public QueueListenerMDB() {
	 // TODO Auto-generated constructor stub
	 }

	 public void onMessage(Message message) {
	 try {
	 if (message instanceof TextMessage) {
	 System.out.println("Queue: TextMessage recebida em " + new Date());
	 TextMessage msg = (TextMessage) message;
	 System.out.println("Message is : " + msg.getText());
	 } else if (message instanceof ObjectMessage) {
	 System.out.println("Queue: ObjectMessage recebida em " + new Date());
	 ObjectMessage msg = (ObjectMessage) message;
	 
	 
	 
	 Livros livro = (Livros) msg.getObject();
	 System.out.println("Detalhes do cliente: ");
	 System.out.println(livro.getTitulo());
	 System.out.println(livro.getAutor());
	 System.out.println(livro.getPreco());
	 } else {
	 System.out.println("Nenhuma mensagem v�lida!");
	 }

	 } catch (JMSException e) {
	 e.printStackTrace();
	 }
	 }
	}