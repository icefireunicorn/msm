package mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.springframework.stereotype.Component;
@Component("messageListenerExample2")
public class MessageListenerExample2 implements MessageListener {
	public void onMessage(Message message) {
        if (message instanceof ObjectMessage) { 
        	ObjectMessage msg = (ObjectMessage)message;
		  try {
			System.out.println("OnMessage Received  :"+msg.getObject().toString());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
}
}
