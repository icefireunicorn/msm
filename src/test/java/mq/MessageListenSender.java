package mq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageListenSender {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:conf/activemq-listener.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");
		Destination destination2 = (Destination) context
				.getBean("destination2");
//		jmsTemplate.convertAndSend(destination, "My first Message");
		jmsTemplate.send(destination, new MessageCreator() {
			public ObjectMessage createMessage(Session session)
					throws JMSException {
				ObjectMessage message = session.createObjectMessage();
				message.setObject("My first Message");
				return message;
			}
		});
		System.out.println("MESSAGE SENT TO myMessageQueue");
		jmsTemplate.convertAndSend(destination2, "My second Message");
//		send(destination2, new MessageCreator() {
//			public ObjectMessage createMessage(Session session)
//					throws JMSException {
//				ObjectMessage message = session.createObjectMessage();
//				message.setObject("My second Message");
//				return message;
//			}
//		});


		System.out.println("MESSAGE SENT TO myMessageTopic");
	}
}
